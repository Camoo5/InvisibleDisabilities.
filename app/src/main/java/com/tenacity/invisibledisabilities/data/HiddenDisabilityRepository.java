package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

import com.tenacity.invisibledisabilities.utilities.AppExecutors;

import java.util.List;


public class HiddenDisabilityRepository {
    private static HiddenDisabilityRepository instance;
    private final HiddenDisabilityDao hiddenDisabilityDao;

    private HiddenDisabilityRepository(HiddenDisabilityDao hiddenDisabilityDao) {
        this.hiddenDisabilityDao = hiddenDisabilityDao;
    }

    public static HiddenDisabilityRepository getInstance(HiddenDisabilityDao hiddenDisabilityDao) {
        if (instance == null) {
            synchronized (HiddenDisabilityRepository.class) {
                if (instance == null) {
                    instance = new HiddenDisabilityRepository ( hiddenDisabilityDao );
                }
            }
        }
        return instance;
    }

    public void createHiddenDisability(String disabilityId) {
        AppExecutors.getInstance ().diskIO ().execute ( () ->
                hiddenDisabilityDao.insertHiddenDisability ( new HiddenDisability ( disabilityId, null ) ) );
    }

    public void removeHiddenDisability(HiddenDisability hiddenDisability) {
        AppExecutors.getInstance ().diskIO ().execute ( () ->
                hiddenDisabilityDao.deleteHiddenDisability ( hiddenDisability ) );
    }

    public LiveData <HiddenDisability> getHiddenDisabilityForDisability(String disabilityId) {
        return hiddenDisabilityDao.getHiddenDisabilityForDisability ( disabilityId );
    }

    public LiveData <HiddenDisability> getHiddenDisabilityForCopingStrategy(String copingstrategyId) {
        return hiddenDisabilityDao.getHiddenDisabilityForCopingStrategy ( copingstrategyId );
    }

    public LiveData <HiddenDisability> getHiddenDisabilityForCriteriaOne(String criteriaoneId) {
        return hiddenDisabilityDao.getHiddenDisabilityForCriteriaOne ( criteriaoneId );
    }

    public LiveData <HiddenDisability> getHiddenDisabilityForCriteriaTwo(String criteriatwoId) {
        return hiddenDisabilityDao.getHiddenDisabilityForCriteriaTwo ( criteriatwoId );
    }

    public LiveData <HiddenDisability> getHiddenDisabilityForExtensionToBlueBadge(String extensiontobluebadgeId) {
        return hiddenDisabilityDao.getHiddenDisabilityForExtensionToBlueBadge ( extensiontobluebadgeId );
    }

    public LiveData <HiddenDisability> getHiddenDisabilityForPractitioner(String practitionerId) {
        return hiddenDisabilityDao.getHiddenDisabilityForPractitioner ( practitionerId );
    }

    public LiveData <HiddenDisability> getHiddenDisabilityForSubConsiderations(String subconsiderationsId) {
        return hiddenDisabilityDao.getHiddenDisabilityForSubConsiderations ( subconsiderationsId );

        public LiveData <HiddenDisability> getHiddenDisabilityForSupportingEvidence ( String supportingevidenceId){
            return hiddenDisabilityDao.getHiddenDisabilityForSupportingEvidence ( supportingevidenceId );
        }


    }

    public LiveData <List <HiddenDisability>> getHiddenDisabilities() {
        return hiddenDisabilityDao.getHiddenDisabilities ();
    }

    public LiveData <List <DisabilityAndHiddenDisabilities>> getDisabilityAndHiddenDisabilities() {
        return hiddenDisabilityDao.getDisabilityAndHiddenDisabilities ();
    }
}