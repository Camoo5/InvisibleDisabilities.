package com.tenacity.invisibledisabilities.utilities;

import android.content.Context;

import com.tenacity.invisibledisabilities.data.AppDatabase;
import com.tenacity.invisibledisabilities.data.CopingStrategyRepository;
import com.tenacity.invisibledisabilities.data.CriteriaOneRepository;
import com.tenacity.invisibledisabilities.data.CriteriaTwoRepository;
import com.tenacity.invisibledisabilities.data.DisabilityRepository;
import com.tenacity.invisibledisabilities.data.ExtensionToBlueBadgeRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.data.PractitionerRepository;
import com.tenacity.invisibledisabilities.data.SubConsiderationsRepository;
import com.tenacity.invisibledisabilities.data.SupportingEvidenceRepository;
import com.tenacity.invisibledisabilities.ui.viewmodels.CopingStrategyViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriaOneViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriaTwoViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityDetailViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityListViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.ExtensionToBlueBadgeViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.HiddenDisabilityListViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.PractitionerViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.SubConsiderationsViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.SupportingEvidenceViewModelFactory;


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

    private static CopingStrategyRepository getCopingStrategyRepository(Context context) {
        return CopingStrategyRepository.getInstance(
                AppDatabase.getInstance(context.getApplicationContext()).getCopingStrategyDao());

    }

    private static CriteriaOneRepository getCriteriaOneRepository(Context context) {
        return CriteriaOneRepository.getInstance(
                AppDatabase.getInstance(context.getApplicationContext()).getCriteriaOneDao());

    }

    private static CriteriaTwoRepository getCriteriaTwoRepository(Context context) {
        return CriteriaTwoRepository.getInstance(
                AppDatabase.getInstance(context.getApplicationContext()).getCriteriaTwoDao());

    }
    private static ExtensionToBlueBadgeRepository getExtensionToBlueBadgeRepository(Context context) {
        return ExtensionToBlueBadgeRepository.getInstance(
                AppDatabase.getInstance(context.getApplicationContext()).getExtensionToBlueBadgeDao());

    }

    private static SubConsiderationsRepository getSubConsiderationsRepository(Context context) {
        return SubConsiderationsRepository.getInstance(
                AppDatabase.getInstance(context.getApplicationContext()).getSubConsiderationsDao());

    }

    private static PractitionerRepository getPractitionerRepository(Context context) {
        return PractitionerRepository.getInstance(
                AppDatabase.getInstance(context.getApplicationContext()).getPractitionerDao());

    }

    private static SupportingEvidenceRepository getSupportingEvidenceRepository(Context context) {
        return SupportingEvidenceRepository.getInstance(
                AppDatabase.getInstance(context.getApplicationContext()).getSupportingEvidenceDao());

    }


    public static DisabilityListViewModelFactory provideDisabilityListViewModelFactory(Context context) {
        return new DisabilityListViewModelFactory (getDisabilityRepository ( context ));
    }


    public static HiddenDisabilityListViewModelFactory HiddenDisabilityListViewModelFactory (Context context) {
        return new HiddenDisabilityListViewModelFactory (getHiddenDisabilityRepository (context));
    }

    public static DisabilityDetailViewModelFactory providerDisabilityDetailViewModelFactory(Context context, String disabilityId) {
        return new DisabilityDetailViewModelFactory(getDisabilityRepository(context), getHiddenDisabilityRepository(context), disabilityId);
    }


    public static CopingStrategyViewModelFactory provideCopingStrategyViewModelFactory(Context context) {
        return new CopingStrategyViewModelFactory (getCopingStrategyRepository ( context ));

    }

    public static CriteriaOneViewModelFactory provideCriteriaOneViewModelFactory(Context context) {
        return new CriteriaOneViewModelFactory (getCriteriaOneRepository ( context ));

    }

    public static CriteriaTwoViewModelFactory provideCriteriaTwoViewModelFactory(Context context) {
        return new CriteriaTwoViewModelFactory (getCriteriaTwoRepository ( context ));

    }

    public static ExtensionToBlueBadgeViewModelFactory provideExtensionToBlueBadgeViewModelFactory(Context context) {
     return new ExtensionToBlueBadgeViewModelFactory ( getExtensionToBlueBadgeRepository ( context ));

    }

    public static SubConsiderationsViewModelFactory provideSubConsiderationsViewModelFactory(Context context) {
        return new SubConsiderationsViewModelFactory ( getSubConsiderationsRepository ( context ));

    }

    public static PractitionerViewModelFactory providePractitionerViewModelFactory(Context context) {
        return new PractitionerViewModelFactory ( getPractitionerRepository ( context ));

    }

    public static SupportingEvidenceViewModelFactory provideSupportingEvidenceViewModelFactory(Context context) {
        return new SupportingEvidenceViewModelFactory ( getSupportingEvidenceRepository ( context ));

    }


}
