package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.CriteriaOne;
import com.tenacity.invisibledisabilities.data.CriteriaOneRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisability;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

import java.util.Objects;

/**
 * The ViewModel used in [CriteriaOneFragment].
 */
public class CriteriaOneViewModel extends ViewModel {
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    private final String criteriaoneId;

    private final LiveData<Boolean> isDisabled;
    public LiveData<CriteriaOne> criteriaOne;

    @RequiresApi(api = Build.VERSION_CODES.N)
    CriteriaOneViewModel(CriteriaOneRepository criteriaOneRepository, HiddenDisabilityRepository hiddenDisabilityRepository, String criteriaoneId) {
        super();
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
        this.criteriaoneId= criteriaoneId;

        /* The getHiddenDisabilitiesForCriteriaOne method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData<HiddenDisability> hiddenDisabilityForCriteriaOne= hiddenDisabilityRepository.getHiddenDisabilityForCriteriaOne(criteriaoneId);
        this.isDisabled= Transformations.map(hiddenDisabilityForCriteriaOne, Objects::nonNull );
        this.criteriaOne = criteriaOneRepository.getCriteriaOne (criteriaoneId);
    }

    public void addCriteriaOneToHiddenDisability() {
        AppExecutors.getInstance().diskIO().execute(() -> hiddenDisabilityRepository.createHiddenDisability(criteriaoneId));
    }

    public LiveData<Boolean> getIsDisabled() {
        return isDisabled;
    }
}

