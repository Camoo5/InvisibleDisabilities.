package com.tenacity.invisibledisabilities.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.tenacity.invisibledisabilities.data.AppDatabase;
import com.tenacity.invisibledisabilities.data.Disability;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class ConditionDatabaseWorker extends Worker {
    public ConditionDatabaseWorker(@NonNull @NotNull Context context, @NonNull @NotNull WorkerParameters workerParams) {
        super ( context, workerParams );
    }

    @NonNull
    @Override
    public Result doWork() {

        try {
            InputStream inputStream = getApplicationContext().getAssets().open("disabilities.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8 );
            List<Disability> disabilityList = new Gson().fromJson(json, new TypeToken<List<Disability>>() {
            }.getType());
            AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
            appDatabase.disabilityDao ().insertAll(disabilityList);
            return Result.success();
        } catch (IOException e) {
            e.printStackTrace();
            return Result.Failure;
        }
    }
}