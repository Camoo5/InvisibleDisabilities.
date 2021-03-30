
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

/**
 * Repository module for handling data operations.
 */

public class CriteriaTwoRepository {
    private static CriteriaTwoRepository instance;
    private final CriteriaTwoDao criteriaTwoDao;

    private CriteriaTwoRepository(CriteriaTwoDao criteriaTwoDao) {
        this.criteriaTwoDao = criteriaTwoDao;
    }

    public static CriteriaTwoRepository getInstance(CriteriaTwoDao criteriaTwoDao) {
        if (instance == null) {
            synchronized (CriteriaTwoRepository.class) {
                if (instance == null) {
                    instance = new CriteriaTwoRepository(criteriaTwoDao);
                }
            }
        }
        return instance;
    }

    public LiveData <CriteriaTwo> getCriteriaTwo(String criteriatwoId) {
        return this.criteriaTwoDao.getCriteriaTwo  (criteriatwoId);
    }
}
