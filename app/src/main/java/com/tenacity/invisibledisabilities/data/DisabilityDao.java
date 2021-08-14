package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

/**
 * The Data Access Object for the Disability class.
 */
@Dao
public interface DisabilityDao {
    @Insert(onConflict = REPLACE)
    void insertAll(List<com.tenacity.invisibledisabilities.data.Disability> disabilities);

    @Query("SELECT * FROM disabilities ORDER BY name")
    LiveData<List<com.tenacity.invisibledisabilities.data.Disability>> getDisabilities();

    @Query("SELECT * FROM disabilities WHERE id = :disabilityId")
    LiveData<com.tenacity.invisibledisabilities.data.Disability> getDisability(String disabilityId);

    @Query("SELECT * FROM disabilities WHERE criteriaType= :criteriaType ORDER BY name")
    LiveData<List<com.tenacity.invisibledisabilities.data.Disability>> getDisabilitiesByCriteriaType(int criteriaType);
}