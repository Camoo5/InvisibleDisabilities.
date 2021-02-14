package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

/**
 * The Data Access Object for the ExtensionToBlueBadge class.
 */
@Dao
public interface ExtensionToBlueBadgeDao {


    @Query("SELECT * FROM extensiontobluebadge WHERE id = :extensiontobluebadgeId")
    LiveData <ExtensionToBlueBadge> getExtensionToBlueBadge (String extensiontobluebadgeId);



}