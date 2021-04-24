package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

/**
 * The Data Access Object for the CopingStrategy class.
 */
@Dao
public interface CriteriasDao {


    @Query("SELECT * FROM Criterias WHERE id = :criteriaoneId")
    LiveData<Criterias> getCriteriaOne (String criteriaoneId);



}