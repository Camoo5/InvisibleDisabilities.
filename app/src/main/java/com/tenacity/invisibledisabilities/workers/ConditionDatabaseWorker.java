package com.tenacity.invisibledisabilities.workers;

import android.content.Context;
import android.util.JsonReader;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tenacity.invisibledisabilities.data.AppDatabase;
import com.tenacity.invisibledisabilities.data.Disability;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;


public class ConditionDatabaseWorker extends Worker {

    private static final String TAG = ConditionDatabaseWorker.class.getSimpleName ();

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
            InputStream input = getApplicationContext ().getAssets ().open ( "disabilities.json" );
            JsonReader reader = new JsonReader ( new InputStreamReader ( input ) );
            Type disabilityType = new TypeToken <List <Disability>> () {
            }.getType ();
            List <Disability> disabilityList = new Gson ().fromJson ( String.valueOf ( reader ), disabilityType );
            input.close ();

            AppDatabase database = AppDatabase.getInstance ( getApplicationContext () );
            database.getDisabilityDao ().insertAll ( disabilityList );

            return Result.success ();
        } catch (IOException e) {
            Log.e ( TAG, "Error seeding database", e );
            return Result.failure ();
        }
    }
}
