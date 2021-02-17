
package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

/**
 * Repository module for handling data operations.
 */

public class PractitionerRepository {
    private static PractitionerRepository instance;
    private PractitionerDao practitionersDao;

    private PractitionerRepository(PractitionerDao practitionerDao) {
        this.practitionersDao= practitionerDao;
    }

    public static PractitionerRepository getInstance(PractitionerDao practionerDao) {
        if (instance == null) {
            synchronized (PractitionerRepository.class) {
                if (instance == null) {
                    instance = new PractitionerRepository (practionerDao);
                }
            }
        }
        return instance;
    }

    public LiveData <Practitioner> getPractitioner(String practitionerId) {
        return this.practitionersDao.getPractitioner (practitionerId);
    }
}

