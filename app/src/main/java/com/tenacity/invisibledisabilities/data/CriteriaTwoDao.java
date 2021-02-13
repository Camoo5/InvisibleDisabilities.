package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

/**
 * The Data Access Object for the CopingStrategy class.
 */
@Dao
public interface CriteriaTwoDao {


    @Query("SELECT * FROM criteriaTwo WHERE id = :criteriatwoId")
    LiveData<CriteriaTwo> getCriteriaTwo (String criteriatwoId);



}