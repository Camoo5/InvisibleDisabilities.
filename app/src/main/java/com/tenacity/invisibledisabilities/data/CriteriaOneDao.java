package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

/**
 * The Data Access Object for the CopingStrategy class.
 */
@Dao
public interface CriteriaOneDao {


    @Query("SELECT * FROM criteriaOnes WHERE id = :criteriaoneId")
    LiveData<CriteriaOne> getCriteriaOne (String criteriaoneId);



}