
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

/**
 * Repository module for handling data operations.
 */
public class CopingStrategyRepository {
    private static CopingStrategyRepository instance;
    private final com.tenacity.invisibledisabilities.data.CopingStrategyDao copingStrategyDao;

    private CopingStrategyRepository(com.tenacity.invisibledisabilities.data.CopingStrategyDao copingStrategyDao) {
        this.copingStrategyDao = copingStrategyDao;
    }

    public static CopingStrategyRepository getInstance(com.tenacity.invisibledisabilities.data.CopingStrategyDao copingStrategyDao) {
        if (instance == null) {
            synchronized (CopingStrategyRepository.class) {
                if (instance == null) {
                    instance = new CopingStrategyRepository(copingStrategyDao);
                }
            }
        }
        return instance;
    }

    public LiveData <CopingStrategy> getCopingStrategy(String copingStrategyId) {
        return this.copingStrategyDao.getCopingStrategy  (copingStrategyId);
    }


    }
