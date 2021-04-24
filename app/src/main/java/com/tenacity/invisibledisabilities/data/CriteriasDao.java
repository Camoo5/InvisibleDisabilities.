package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

/**
 * The Data Access Object for the Criterias class.
 */
@Dao
public interface CriteriasDao {


    @Query("SELECT * FROM Criterias WHERE id = :criteriasId")
    LiveData<Criterias> getCriterias (String criteriasId);



}