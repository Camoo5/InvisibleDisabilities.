package com.tenacity.invisibledisabilities.data;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * The Data Access Object for the Disability class.
 */
@Dao
public interface DisabilityDao {
    @Insert(onConflict = REPLACE)
    void insertAll(List<Disability> disabilities);

    @Query("SELECT * FROM disabilities ORDER BY name")
    LiveData<List<Disability>> getDisabilities();

    @Query("SELECT * FROM disabilities WHERE id = :disabilityId")
    LiveData<Disability> getDisability(String disabilityId);

@Query("SELECT * FROM disabilities WHERE invisibleConditionNumber = :invisibleConditionNumber ORDER BY name")
    LiveData<List<Disability>> getDisabilitiesByInvisibleConditionNumber(int invisibleConditionNumber);
}