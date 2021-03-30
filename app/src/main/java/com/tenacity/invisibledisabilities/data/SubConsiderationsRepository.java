package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

/**
 * Repository module for handling data operations.
 */

public class SubConsiderationsRepository {
    private static SubConsiderationsRepository instance;
    private final SubConsiderationsDao subConsiderationsDao;

    private SubConsiderationsRepository(SubConsiderationsDao subConsiderationsDao) {
        this.subConsiderationsDao = subConsiderationsDao;
    }

    public static SubConsiderationsRepository getInstance(SubConsiderationsDao subConsiderationsDao) {
        if (instance == null) {
            synchronized (SubConsiderationsRepository.class) {
                if (instance == null) {
                    instance = new SubConsiderationsRepository(subConsiderationsDao);
                }
            }
        }
        return instance;
    }

    public LiveData <SubConsiderations> getSubConsiderations(String subconsiderationsId) {
        return this.subConsiderationsDao.getSubConsiderations  (subconsiderationsId);
    }
}
