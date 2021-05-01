
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

/**
 * Repository module for handling data operations.
 */

public class CriteriasRepository {
    private static CriteriasRepository instance;
    private final CriteriasDao criteriasDao;

    private CriteriasRepository(CriteriasDao criteriasDao) {
        this.criteriasDao = criteriasDao;
    }

    public static CriteriasRepository getInstance(CriteriasDao criteriasDao) {
        if (instance == null) {
            synchronized (CriteriasRepository.class) {
                if (instance == null) {
                    instance = new CriteriasRepository (criteriasDao);
                }
            }
        }
        return instance;
    }



    public LiveData <Criterias> getCriterias(String criteriasId) {
        return this.criteriasDao.getCriterias  (criteriasId);
    }
    }



