
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

/**
 * Repository module for handling data operations.
 */
public class ExtensionToBlueBadgeRepository {
    private static ExtensionToBlueBadgeRepository instance;
    private ExtensionToBlueBadgeDao extensionToBlueBadgeDao;

    private ExtensionToBlueBadgeRepository(ExtensionToBlueBadgeDao extensionToBlueBadgeDao) {
        this.extensionToBlueBadgeDao = extensionToBlueBadgeDao;
    }

    public static ExtensionToBlueBadgeRepository getInstance(ExtensionToBlueBadgeDao extensionToBlueBadgeDao) {
        if (instance == null) {
            synchronized (ExtensionToBlueBadgeRepository.class) {
                if (instance == null) {
                    instance = new ExtensionToBlueBadgeRepository(extensionToBlueBadgeDao);
                }
            }
        }
        return instance;
    }

    public LiveData <ExtensionToBlueBadge> getExtensionToBlueBadge(String extensiontobluebadgeId) {
        return this.extensionToBlueBadgeDao.getExtensionToBlueBadge  (extensiontobluebadgeId);

    }


}
