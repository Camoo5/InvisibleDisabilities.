
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Repository module for handling data operations.
 */
public class DisabilityRepository {
    private static DisabilityRepository instance;
    private final com.tenacity.invisibledisabilities.data.DisabilityDao disabilityDao;

    private DisabilityRepository(com.tenacity.invisibledisabilities.data.DisabilityDao hiddenDisabilitiesDao) {
        this.disabilityDao = hiddenDisabilitiesDao;
    }

    public static DisabilityRepository getInstance(com.tenacity.invisibledisabilities.data.DisabilityDao hiddenDisabilitiesDao) {
        if (instance == null) {
            synchronized (DisabilityRepository.class) {
                if (instance == null) {
                    instance = new DisabilityRepository(hiddenDisabilitiesDao);
                }
            }
        }
        return instance;
    }

    public LiveData <List<com.tenacity.invisibledisabilities.data.Disability>> getDisabilities() {
        return this.disabilityDao.getDisabilities ();
    }

    public LiveData<com.tenacity.invisibledisabilities.data.Disability> getDisability(String disabilityId) {
        return this.disabilityDao.getDisability(disabilityId);
    }

    public LiveData<List<com.tenacity.invisibledisabilities.data.Disability>> getDisabilitiesWithCriteriaNumber (int criteriaNumber) {
        return this.disabilityDao.getDisabilitiesWithCriteriaNumber (criteriaNumber);
    }
}