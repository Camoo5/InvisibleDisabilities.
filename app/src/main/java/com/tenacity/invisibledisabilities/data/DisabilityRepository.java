
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Repository module for handling data operations.
 */
public class DisabilityRepository {
    private static volatile DisabilityRepository instance;
    private  DisabilityDao disabilityDao;

   DisabilityRepository(DisabilityDao disabilityDao) {
        this.disabilityDao = disabilityDao;
    }

    public LiveData<List<Disability>> getDisabilities() {
        return disabilityDao.getDisabilities();
    }

    public LiveData<Disability> getDisability(String id) {
        return disabilityDao.getDisability(id);
    }

    public LiveData<List<Disability>> getDisabilitiesByCriteriaTypeNumber(int criteriaTypeNo) {
        return disabilityDao.getDisabilitiesByCriteriaTypeNumber(criteriaTypeNo);


    }

    public static DisabilityRepository getInstance(DisabilityDao disabilityDao) {
        if (instance == null) {
            synchronized (DisabilityRepository.class) {
                if (instance == null)
                    instance = new DisabilityRepository(disabilityDao);
            }
        }
        return instance;

    }
}