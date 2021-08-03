
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.data.DisabilityDao;

import java.util.List;

/**
 * Repository module for handling data operations.
 */
public class DisabilityRepository {
    private static DisabilityRepository instance;
    private final DisabilityDao disabilityDao;

    private DisabilityRepository(DisabilityDao hiddenDisabilityDao) {
        this.disabilityDao = hiddenDisabilityDao;
    }

    public static DisabilityRepository getInstance(DisabilityDao hiddenDisabilityDao) {
        if (instance == null) {
            synchronized (DisabilityRepository.class) {
                if (instance == null) {
                    instance = new DisabilityRepository(hiddenDisabilityDao);
                }
            }
        }
        return instance;
    }

    public LiveData <List<Disability>> getDisabilities() {
        return this.disabilityDao.getDisabilities ();
    }

    public LiveData<Disability> getDisability(String disabilityId) {
        return this.disabilityDao.getDisability(disabilityId);
    }

    public LiveData<List<Disability>> getDisabilitiesWithCriteriaType (int criteriaType) {
        return this.disabilityDao.getDisabilitiesWithCriteriaType (criteriaType);
    }
}