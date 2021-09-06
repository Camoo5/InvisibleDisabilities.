
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Repository module for handling data operations.
 */
public class DisabilityRepository {
    private final DisabilityDao disabilityDao;
    private static volatile DisabilityRepository instance;

    DisabilityRepository(DisabilityDao disabilityDao) {
        this.disabilityDao = disabilityDao;
    }

    public static DisabilityRepository getInstance(DisabilityDao disabilityDao) {
        if (instance == null) {
            synchronized (DisabilityRepository.class) {
                if (instance == null)
                    instance = new DisabilityRepository ( disabilityDao );
            }
        }
        return instance;

    }

    public LiveData <List <com.tenacity.invisibledisabilities.data.Disability>> getDisabilities() {
        return disabilityDao.getDisabilities ();
    }

    public LiveData <com.tenacity.invisibledisabilities.data.Disability> getDisability(String id) {
        return disabilityDao.getDisability ( id );
    }

    public LiveData <List <com.tenacity.invisibledisabilities.data.Disability>> getDisabilitiesWithCriteriaType(int criteriaType) {
        return disabilityDao.getDisabilitiesByCriteriaType ( criteriaType );
    }
}