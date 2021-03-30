package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

/**
 * Repository module for handling data operations.
 */

public class SupportingEvidenceRepository {
    private static SupportingEvidenceRepository instance;
    private final SupportingEvidenceDao supportingEvidenceDao;

    private SupportingEvidenceRepository(SupportingEvidenceDao supportingEvidenceDao) {
        this.supportingEvidenceDao = supportingEvidenceDao;
    }

    public static SupportingEvidenceRepository getInstance(SupportingEvidenceDao supportingEvidenceDao) {
        if (instance == null) {
            synchronized (SupportingEvidenceRepository.class) {
                if (instance == null) {
                    instance = new SupportingEvidenceRepository(supportingEvidenceDao);
                }
            }
        }
        return instance;
    }

    public LiveData <SupportingEvidence> getSupportingEvidence(String supportingevidenceId) {
        return this.supportingEvidenceDao.getSupportingEvidence (supportingevidenceId);
    }
}
