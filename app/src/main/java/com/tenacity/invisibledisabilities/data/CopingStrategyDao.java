package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;


/**
 * The Data Access Object for the CopingStrategy class.
 */
@Dao

public interface CopingStrategyDao {

    @Query("SELECT * FROM copingStrategies WHERE id = :copingstrategyId")
    LiveData <CopingStrategy> getCopingStrategy(String copingstrategyId);


}

