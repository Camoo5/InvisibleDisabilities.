package com.tenacity.invisibledisabilities.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

/**
 * The Data Access Object for the [HiddenDisability] class.
 */
@Dao
public interface HiddenDisabilityDao {
    @Query("SELECT * FROM hidden_disabilities")
    LiveData<List<HiddenDisability>> getHiddenDisabilities();

    @Query("SELECT * FROM hidden_disabilities WHERE id = :hiddenDisabilityId")
    LiveData<HiddenDisability> getHiddenDisability(long hiddenDisabilityId);

    @Query("SELECT * FROM hidden_disabilities WHERE disability_id = :disabilityId")
    LiveData<HiddenDisability> getHiddenDisabilityForDisability(@NonNull String disabilityId);

    @Query("SELECT * FROM hidden_disabilities WHERE disability_id = :copingstrategyId")
    LiveData<HiddenDisability> getHiddenDisabilityForCopingStrategy(@NonNull String copingstrategyId);

    @Query("SELECT * FROM hidden_disabilities WHERE disability_id = :criteriaoneId")
    LiveData<HiddenDisability> getHiddenDisabilityForCriteriaOne(@NonNull String criteriaoneId);

    @Query("SELECT * FROM hidden_disabilities WHERE disability_id = :criteriatwoId")
    LiveData<HiddenDisability> getHiddenDisabilityForCriteriaTwo(@NonNull String criteriatwoId);

    @Query("SELECT * FROM hidden_disabilities WHERE disability_id = :extensiontobluebadgeId")
    LiveData<HiddenDisability> getHiddenDisabilityForExtensionToBlueBadge(@NonNull String extensiontobluebadgeId);

    @Query("SELECT * FROM hidden_disabilities WHERE disability_id = :practitionerId")
    LiveData<HiddenDisability> getHiddenDisabilityForPractitioner(@NonNull String practitionerId);

    @Query("SELECT * FROM hidden_disabilities WHERE disability_id = :supportingevidenceId")
    LiveData<HiddenDisability> getHiddenDisabilityForSupportingEvidence(@NonNull String supportingevidenceId);

    @Query("SELECT * FROM hidden_disabilities WHERE subconsiderations_id = :subconsiderationsId")
    LiveData<HiddenDisability> getHiddenDisabilityForSubConsiderations(@NonNull String subconsiderationsId);
    /**
     * This query will tell Room to query both the [Disability] and [HiddenDisability] tables and handle
     * the object mapping.
     */
    @Transaction
    @Query("SELECT * FROM disabilities")
    LiveData<List<DisabilityAndHiddenDisabilities>> getDisabilityAndHiddenDisabilities();

    @Insert
    long insertHiddenDisability(@NonNull HiddenDisability hiddenDisability);

    @Delete
    void deleteHiddenDisability(@NonNull HiddenDisability hiddenDisability);


}