package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * The Data Access Object for the Disability class.
 */
@Dao
public interface DisabilityDao {
    @Query("SELECT * FROM disabilities ORDER BY name")
    LiveData<List<Disability>> getDisabilities();

    @Query("SELECT * FROM disabilities WHERE criteriaTypeNumber = :criteriaTypeNumber ORDER BY name")
    LiveData<List<Disability>> getDisabilitiesWithCriteriaTypeNumber(int criteriaTypeNumber);

    @Query("SELECT * FROM disabilities WHERE id = :disabilityId")
    LiveData<Disability> getDisability(String disabilityId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Disability> disabilities);
}