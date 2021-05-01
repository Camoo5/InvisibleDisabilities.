package com.tenacity.invisibledisabilities.utilities;

import android.content.Context;

import com.tenacity.invisibledisabilities.data.AppDatabase;
import com.tenacity.invisibledisabilities.data.CopingStrategyRepository;
import com.tenacity.invisibledisabilities.data.CriteriasRepository;
import com.tenacity.invisibledisabilities.data.DisabilityRepository;
import com.tenacity.invisibledisabilities.data.ExtensionToBlueBadgeRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.data.PractitionerRepository;
import com.tenacity.invisibledisabilities.data.SupportingEvidenceRepository;
import com.tenacity.invisibledisabilities.ui.viewmodels.CopingStrategyDetailViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriasDetailViewModelFactory;
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

    private static CopingStrategyRepository getCopingStrategyRepository(Context context) {
        return CopingStrategyRepository.getInstance(
                AppDatabase.getInstance(context.getApplicationContext()).getCopingStrategyDao());

    }

    private static CriteriasRepository getCriteriaOneRepository(Context context) {
        return CriteriasRepository.getInstance(
                AppDatabase.getInstance(context.getApplicationContext()).getCriteriasDao());

    }


    private static ExtensionToBlueBadgeRepository getExtensionToBlueBadgeRepository(Context context) {
        return ExtensionToBlueBadgeRepository.getInstance(
                AppDatabase.getInstance(context.getApplicationContext()).getExtensionToBlueBadgeDao());

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


    public static HiddenDisabilityListViewModelFactory provideHiddenDisabilityListViewModelFactory (Context context) {
        return new HiddenDisabilityListViewModelFactory (getHiddenDisabilityRepository (context));
    }

    public static DisabilityDetailViewModelFactory providerDisabilityDetailViewModelFactory(Context context, String disabilityId) {
        return new DisabilityDetailViewModelFactory(getDisabilityRepository(context), getHiddenDisabilityRepository(context), disabilityId);
    }



    public static CopingStrategyDetailViewModelFactory providerCopingStrategyViewModelFactory(Context context,String copingstrategyId) {
        return new CopingStrategyDetailViewModelFactory (getCopingStrategyRepository ( context ), getHiddenDisabilityRepository (context), copingstrategyId);

    }

    public static CriteriasDetailViewModelFactory providerCriteriaOneViewModelFactory(Context context, String criteriaoneId) {
        return new CriteriasDetailViewModelFactory (getCriteriaOneRepository ( context ), getHiddenDisabilityRepository (context), criteriaoneId);

    }



    public static ExtensionToBlueBadgeListViewModelFactory providerExtensionToBlueBadgeViewModelFactory(Context context, String extensiontobluebadgeId) {
        return new ExtensionToBlueBadgeListViewModelFactory (getExtensionToBlueBadgeRepository ( context ), getHiddenDisabilityRepository (context), extensiontobluebadgeId);

    }

    public static PractitionerListViewModelFactory providerPractitionerViewModelFactory(Context context, String practitionerId) {
        return new PractitionerListViewModelFactory (getPractitionerRepository ( context ), getHiddenDisabilityRepository (context), practitionerId);

    }

    public static SupportingEvidenceListViewModelFactory providerSupportingEvidenceViewModelFactory(Context context, String supportingevidenceId) {
        return new SupportingEvidenceListViewModelFactory (getSupportingEvidenceRepository ( context ), getHiddenDisabilityRepository (context), supportingevidenceId);

    }




}
