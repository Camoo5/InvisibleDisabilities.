package com.tenacity.hiddendisabilities.utilities;

import android.content.Context;

import com.tenacity.hiddendisabilities.data.AppDatabase;
import com.tenacity.hiddendisabilities.data.DisabilityRepository;
import com.tenacity.hiddendisabilities.data.HiddenDisabilityRepository;
import com.tenacity.hiddendisabilities.ui.viewmodels.DisabilityDetailViewModelFactory;
import com.tenacity.hiddendisabilities.ui.viewmodels.DisabilityListViewModelFactory;
import com.tenacity.hiddendisabilities.ui.viewmodels.HiddenDisabilityListViewModelFactory;


/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
public class InjectorUtils {

    private static DisabilityRepository getDisabilityRepository(Context context) {
        return DisabilityRepository.getInstance( AppDatabase.getInstance(context.getApplicationContext()).getDisabilityDao());
    }

    private static HiddenDisabilityRepository getHiddenDisabilityRepository(Context context) {
        return HiddenDisabilityRepository.getInstance(
                AppDatabase.getInstance(context.getApplicationContext()).getHiddenDisabilitiesDao());
    }


    public static DisabilityListViewModelFactory provideDisabilityListViewModelFactory(Context context) {
        return new DisabilityListViewModelFactory (getDisabilityRepository ( context ));
    }


    public static HiddenDisabilityListViewModelFactory provideHiddenDisabilityListViewModelFactory (Context context) {
        return new HiddenDisabilityListViewModelFactory (getHiddenDisabilityRepository (context));
    }

    public static DisabilityDetailViewModelFactory provideDisabilityDetailViewModelFactory(Context context, String disabilityId) {
        return new DisabilityDetailViewModelFactory(getDisabilityRepository(context), getHiddenDisabilityRepository(context), disabilityId);
    }









}
