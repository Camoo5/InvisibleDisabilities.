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

import com.tenacity.invisibledisabilities.data.DisabilityDao;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityDao;
import com.tenacity.invisibledisabilities.utilities.Constants;
import com.tenacity.invisibledisabilities.workers.ConditionDatabaseWorker;
import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.data.HiddenDisability;

/**
 * The Room database for this app
 */
@Database(entities = {HiddenDisability.class, Disability.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract HiddenDisabilityDao getHiddenDisabilitiesDao();
    public abstract DisabilityDao getDisabilityDao();
    private static AppDatabase instance = null;



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
                        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(ConditionDatabaseWorker.class).build();
                        WorkManager.getInstance().enqueue(workRequest);
                    }
                }).build();

    }
}
