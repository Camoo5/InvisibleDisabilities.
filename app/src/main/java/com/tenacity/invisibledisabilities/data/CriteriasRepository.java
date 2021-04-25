
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

/**
 * Repository module for handling data operations.
 */

public class CriteriasRepository {
    private static CriteriasRepository instance;
    private final CriteriasDao criteriaOneDao;

    private CriteriasRepository(CriteriasDao criteriaOneDao) {
        this.criteriaOneDao = criteriaOneDao;
    }

    public static CriteriasRepository getInstance(CriteriasDao criteriaOneDao) {
        if (instance == null) {
            synchronized (CriteriasRepository.class) {
                if (instance == null) {
                    instance = new CriteriasRepository (criteriaOneDao);
                }
            }
        }
        return instance;
    }



    public LiveData <Criterias> getCriterias(String criteriasId) {
        return this.criteriasDao.getCriterias  (criteriasId);
    }
    }



