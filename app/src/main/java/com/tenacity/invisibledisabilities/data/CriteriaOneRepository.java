
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

import com.tenacity.invisibledisabilities.utilities.AppExecutors;

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

    public void createCriteriaOne(String criteriaoneId) {
        AppExecutors.getInstance().diskIO().execute(() ->
                criteriaOneDao.insertCriteriaOne(new CriteriaOne(criteriaoneId, null, null)));
    }

    public void removeCriteriaOne(CriteriaOne  criteriaOne) {
        AppExecutors.getInstance().diskIO().execute(() ->
                criteriaOneDao.deleteCriteriaOne(criteriaOne));
    }

    public LiveData <CriteriaOne> getCriteriaOne(String criteriaoneId) {
        return this.criteriaOneDao.getCriteriaOne  (criteriaoneId);
    }
    }



