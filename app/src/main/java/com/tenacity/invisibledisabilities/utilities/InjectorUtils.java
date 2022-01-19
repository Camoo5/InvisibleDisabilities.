package com.tenacity.invisibledisabilities.utilities;

import android.content.Context;

import com.tenacity.invisibledisabilities.data.AppDatabase;
import com.tenacity.invisibledisabilities.data.DisabilityRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityDetailViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityListViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.HiddenDisabilityListViewModelFactory;


/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
public class InjectorUtils {

    private static DisabilityRepository getDisabilityRepository(Context context) {
        return DisabilityRepository.getInstance( AppDatabase.getInstance(context).disabilityDao());
    }

    private static HiddenDisabilityRepository getHiddenDisabilityRepository(Context context) {
        return HiddenDisabilityRepository.getInstance(
                AppDatabase.getInstance(context).hiddenDisabilityDao());
    }


    public static DisabilityListViewModelFactory provideDisabilityListViewModelFactory(Context context) {
        DisabilityRepository repository = getDisabilityRepository ( context );
        return new DisabilityListViewModelFactory ( repository );
    }


    public static HiddenDisabilityListViewModelFactory provideHiddenDisabilityListViewModelFactory (Context context) {
        HiddenDisabilityRepository hiddenDisabilityRepository = getHiddenDisabilityRepository ( context );
        return new HiddenDisabilityListViewModelFactory (hiddenDisabilityRepository);
    }

    public static DisabilityDetailViewModelFactory provideDisabilityDetailViewModelFactory(Context context, String disabilityId) {
        return new DisabilityDetailViewModelFactory(getDisabilityRepository(context), getHiddenDisabilityRepository(context), disabilityId);
    }









}
