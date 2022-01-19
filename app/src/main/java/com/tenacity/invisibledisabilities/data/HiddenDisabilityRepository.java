package com.tenacity.invisibledisabilities.data;

import androidx.lifecycle.LiveData;

import com.tenacity.invisibledisabilities.utilities.AppExecutors;

import java.util.List;


public class HiddenDisabilityRepository {

   private static HiddenDisabilityRepository instance;
 private final HiddenDisabilityDao hiddenDisabilityDao;


   public HiddenDisabilityRepository(HiddenDisabilityDao hiddenDisabilityDao) {
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
        AppExecutors.getInstance().diskIO().execute(() ->
                hiddenDisabilityDao.insertHiddenDisability(new HiddenDisability(disabilityId, null)));
    }


    public LiveData<HiddenDisability> getHiddenDisabilityForDisability(String disabilityId) {
        return hiddenDisabilityDao.getHiddenDisabilityForDisability(disabilityId);

    }


    public LiveData <List <HiddenDisability>> getHiddenDisabilities() {
        return hiddenDisabilityDao.getHiddenDisabilities ();
    }

    public LiveData <List <DisabilityAndHiddenDisabilities>> getDisabilityAndHiddenDisabilities() {
        return hiddenDisabilityDao.getDisabilityAndHiddenDisabilities();
    }




}