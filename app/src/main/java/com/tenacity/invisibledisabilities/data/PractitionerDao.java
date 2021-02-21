package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

/**
 * The Data Access Object for the Practitioner class.
 */
@Dao
public interface PractitionerDao {


    @Query("SELECT * FROM Practitioner WHERE id = :practitionersId")
    LiveData<Practitioner> getPractitioner (String practitionersId);



}