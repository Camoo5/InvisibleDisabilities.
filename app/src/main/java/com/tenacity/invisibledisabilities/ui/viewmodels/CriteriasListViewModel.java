package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.Criterias;
import com.tenacity.invisibledisabilities.data.CriteriasRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisability;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

import java.util.Objects;

/**
 * The ViewModel used in [CriteriasFragment].
 */
public class CriteriasListViewModel extends ViewModel {
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    private final String criteriasId;

    private final LiveData<Boolean> isDisabled;
    public LiveData<Criterias> criterias;

    @RequiresApi(api = Build.VERSION_CODES.N)
    CriteriasListViewModel(CriteriasRepository criteriasRepository, HiddenDisabilityRepository hiddenDisabilityRepository, String criteriasId) {
        super();
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
        this.criteriasId= criteriasId;

        /* The getHiddenDisabilitiesForCriteriaOne method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData<HiddenDisability> hiddenDisabilityForCriterias= hiddenDisabilityRepository.getHiddenDisabilityForCriterias(criteriasId);
        this.isDisabled= Transformations.map(hiddenDisabilityForCriterias, Objects::nonNull );
        this.criterias = criteriasRepository.getCriterias (criteriasId);
    }

    public void addCriteriasToHiddenDisability() {
        AppExecutors.getInstance().diskIO().execute(() -> hiddenDisabilityRepository.createHiddenDisability(criteriasId));
    }

    public LiveData<Boolean> getIsDisabled() {
        return isDisabled;
    }
}

