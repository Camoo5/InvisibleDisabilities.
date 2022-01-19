
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Repository module for handling data operations.
 */
public class DisabilityRepository {
    private final DisabilityDao disabilityDao;
    private static DisabilityRepository instance;

   private DisabilityRepository(DisabilityDao hiddenDisabilityDao) {
        this.disabilityDao = hiddenDisabilityDao;
    }

    public static DisabilityRepository getInstance(DisabilityDao hiddenDisabilityDao) {
        if (instance == null) {
            synchronized (DisabilityRepository.class) {
                if (instance == null)
                    instance = new DisabilityRepository(hiddenDisabilityDao);
            }
        }
        return instance;

    }

    public LiveData<List<Disability>> getDisabilities(DisabilityRepository disabilityRepository) {
        return this.disabilityDao.getDisabilities();
    }

    public LiveData<Disability> getDisability(String disabilityid) {
        return this.disabilityDao.getDisability(disabilityid);
    }




}