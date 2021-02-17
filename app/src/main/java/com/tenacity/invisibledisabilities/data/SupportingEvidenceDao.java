package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

/**
 * The Data Access Object for the SupportingEvidenceclass.
 */
@Dao
public interface SupportingEvidenceDao {


    @Query("SELECT * FROM SupportingEvidence WHERE id = :supportingevidenceId")
    LiveData<SupportingEvidence> getSupportingEvidence (String supportingevidenceId);



}