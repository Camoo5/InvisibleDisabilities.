package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

/**
 * The Data Access Object for the SubConsiderations class.
 */
@Dao
public interface SubConsiderationsDao {


    @Query("SELECT * FROM SubConsiderations WHERE id = :subconsiderationsId")
    LiveData<SubConsiderations> getSubConsiderations (String subconsiderationsId);



}