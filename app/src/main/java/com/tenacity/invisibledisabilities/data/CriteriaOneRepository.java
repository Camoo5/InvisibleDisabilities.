
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

/**
 * Repository module for handling data operations.
 */

public class CriteriaOneRepository {
    private static CriteriaOneRepository instance;
    private  CriteriaOneDao criteriaOneDao;

    private CriteriaOneRepository(CriteriaOneDao criteriaOneDao) {
        this.criteriaOneDao = criteriaOneDao;
    }

    public static CriteriaOneRepository getInstance(CriteriaOneDao criteriaOneDao) {
        if (instance == null) {
            synchronized (CriteriaOneRepository.class) {
                if (instance == null) {
                    instance = new CriteriaOneRepository(criteriaOneDao);
                }
            }
        }
        return instance;
    }

    public LiveData <CriteriaOne> getCriteriaOne(String criteriaoneId) {
        return this.criteriaOneDao.getCriteriaOne  (criteriaoneId);
    }
    }



