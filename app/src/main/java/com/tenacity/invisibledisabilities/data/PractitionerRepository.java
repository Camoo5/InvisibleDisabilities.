
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

/**
 * Repository module for handling data operations.
 */

public class PractitionerRepository {
    private static PractitionerRepository instance;
    private final PractitionerDao practitionersDao;

    private PractitionerRepository(PractitionerDao practitionerDao) {
        this.practitionersDao= practitionerDao;
    }

    public static PractitionerRepository getInstance(PractitionerDao practitionerDao) {
        if (instance == null) {
            synchronized (PractitionerRepository.class) {
                if (instance == null) {
                    instance = new PractitionerRepository (practitionerDao);
                }
            }
        }
        return instance;
    }

    public LiveData <Practitioner> getPractitioner(String practitionersId) {
        return this.practitionersDao.getPractitioner (practitionersId);
    }
}

