package com.tenacity.invisibledisabilities.data;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;


public class HiddenDisabilityRepository {

   static HiddenDisabilityRepository instance;
     HiddenDisabilityDao hiddenDisabilityDao;


   public HiddenDisabilityRepository(HiddenDisabilityDao hiddenDisabilityDao) {
        this.hiddenDisabilityDao = hiddenDisabilityDao;
    }

    public static HiddenDisabilityRepository getInstance(HiddenDisabilityDao hiddenDisabilityDao) {
        if (instance == null) {
            synchronized (HiddenDisability.class) {
                if (instance == null) {
                    instance = new HiddenDisabilityRepository ( hiddenDisabilityDao );
                }
            }
        }
        return instance;
    }

    public void createHiddenDisability(String disabilityId) {
        AsyncTask.execute(() -> {
    HiddenDisability hiddenDisability = new HiddenDisability(disabilityId);
    hiddenDisabilityDao.insertHiddenDisability(hiddenDisability);
});

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