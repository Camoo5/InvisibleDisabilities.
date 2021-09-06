package com.tenacity.invisibledisabilities.workers;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tenacity.invisibledisabilities.data.AppDatabase;
import com.tenacity.invisibledisabilities.data.Disability;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class ConditionDatabaseWorker extends Worker {


    /**
     * @param appContext   The application {@link Context}
     * @param workerParams Parameters to setup the internal state of this worker
     */

    public ConditionDatabaseWorker(@NonNull Context appContext, @NonNull WorkerParameters workerParams) {
        super ( appContext, workerParams );
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            InputStream inputStream = getApplicationContext ().getAssets ().open ( "disabilities.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read ( buffer );
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8 );
            List<Disability> disabilityList = new Gson().fromJson(json, new TypeToken<List<Disability>>() {
            }.getType());
            AppDatabase database = AppDatabase.getInstance ( getApplicationContext () );
            database.getDisabilityDao ().insertAll ( disabilityList );
            return Result.success ();
        } catch (IOException e) {
            e.printStackTrace();
            return Result.failure ();
        }
    }
}
