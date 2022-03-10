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
@Database(entities = {Disability.class, HiddenDisability.class}, version = 4, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance = null;

    public static void destroyDatabase() {
        instance = null;
    }

    public abstract DisabilityDao disabilityDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null)
                    instance = buildDatabase(context);
            }
        }
        return instance;
    }

    // Create and pre-populate the database. See this article for more details:
    // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
    private static AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, Constants.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);

                        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(ConditionDatabaseWorker.class).build();
                        WorkManager.getInstance(context).enqueue(workRequest);
                    }

                }).build();


    }

    public abstract HiddenDisabilityDao hiddenDisabilityDao();
}