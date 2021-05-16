package com.tenacity.invisibledisabilities.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.tenacity.invisibledisabilities.utilities.Constants;
import com.tenacity.invisibledisabilities.workers.ConditionDatabaseWorker;

/**
 * The Room database for this app
 */
@Database(entities = {HiddenDisability.class, com.tenacity.invisibledisabilities.data.Disability.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract HiddenDisabilityDao getHiddenDisabilitiesDao();

    public abstract DisabilityDao getDisabilityDao();


    private static volatile AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                instance = buildDatabase ( context );
            }
        }
        return instance;
    }

    // Create and pre-populate the database. See this article for more details:
    // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
    private static AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder ( context, AppDatabase.class, Constants.DATABASE_NAME )
                .addCallback ( new RoomDatabase.Callback () {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate ( db );
                        WorkManager.getInstance ( context ).enqueue ( OneTimeWorkRequest.from ( ConditionDatabaseWorker.class ) );
                    }
                } )
                .build ();
    }


}
