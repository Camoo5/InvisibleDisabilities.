package com.tenacity.invisibledisabilities.utilities;

import android.content.Context;

import com.tenacity.invisibledisabilities.data.AppDatabase;
import com.tenacity.invisibledisabilities.data.CopingStrategyRepository;
import com.tenacity.invisibledisabilities.data.DisabilityRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.ui.viewmodels.CopingStrategyViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityDetailViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityListViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.HiddenDisabilityListViewModelFactory;




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

    private static CopingStrategyRepository getCopingStrategyRepository(Context context){
      return CopingStrategyRepository.getInstance(
              AppDatabase.getInstance(context.getApplicationContext()).getCopingStrategyDao());

    }

    public static HiddenDisabilityListViewModelFactory HiddenDisabilityListViewModelFactory (Context context) {
        return new HiddenDisabilityListViewModelFactory (getHiddenDisabilityRepository (context));
    }

    public static DisabilityListViewModelFactory provideDisabilityListViewModelFactory(Context context) {
        return new DisabilityListViewModelFactory (getDisabilityRepository ( context ));
    }

    public static DisabilityDetailViewModelFactory providerDisabilityDetailViewModelFactory(Context context, String disabilityId) {
        return new DisabilityDetailViewModelFactory(getDisabilityRepository(context), getHiddenDisabilityRepository(context), disabilityId);
    }

    public static CopingStrategyViewModelFactory



}