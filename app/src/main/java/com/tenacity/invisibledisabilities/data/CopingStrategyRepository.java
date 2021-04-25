
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;


/**
 * Repository module for handling data operations.
 */
public class CopingStrategyRepository {
    private static CopingStrategyRepository instance;
    private final CopingStrategyDao copingStrategyDao;

    private CopingStrategyRepository(CopingStrategyDao hiddenDisabilitiesDao) {
        this.copingStrategyDao = hiddenDisabilitiesDao;
    }

    public static CopingStrategyRepository getInstance(CopingStrategyDao hiddenDisabilitiesDao) {
        if (instance == null) {
            synchronized (CopingStrategyRepository.class) {
                if (instance == null) {
                    instance = new CopingStrategyRepository(hiddenDisabilitiesDao);
                }
            }
        }
        return instance;
    }


    public LiveData<CopingStrategy> getCopingStrategy(String copingstrategyId) {
        return this.copingStrategyDao.getCopingStrategy (copingstrategyId);
    }


}