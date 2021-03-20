package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.CriteriaTwo;
import com.tenacity.invisibledisabilities.data.CriteriaTwoRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisability;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

import java.util.Objects;

/**
 * The ViewModel used in [CriteriaTwoFragment].
 */
public class CriteriaTwoViewModel extends ViewModel {
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    private final String criteriatwoId;

    private final LiveData<Boolean> isDisabled;
    public LiveData<CriteriaTwo> criteriaTwo;

    @RequiresApi(api = Build.VERSION_CODES.N)
    CriteriaTwoViewModel(CriteriaTwoRepository criteriaTwoRepository, HiddenDisabilityRepository hiddenDisabilityRepository, String criteriatwoId) {
        super();
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
        this.criteriatwoId= criteriatwoId;

        /* The getHiddenDisabilitiesForCriteriaTwo method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData<HiddenDisability> hiddenDisabilityForCriteriaTwo = hiddenDisabilityRepository.getHiddenDisabilityForCriteriaTwo (criteriatwoId);
        this.isDisabled= Transformations.map(hiddenDisabilityForCriteriaTwo, Objects::nonNull );
        this.criteriaTwo = criteriaTwoRepository.getCriteriaTwo (criteriatwoId);
    }

    public void addCriteriaTwoToHiddenDisability() {
        AppExecutors.getInstance().diskIO().execute(() -> hiddenDisabilityRepository.createHiddenDisability(criteriatwoId));
    }

    public LiveData<Boolean> getIsDisabled() {
        return isDisabled;
    }
}
