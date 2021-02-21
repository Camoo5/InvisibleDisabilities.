package com.tenacity.invisibledisabilities.ui.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.CriteriaTwo;
import com.tenacity.invisibledisabilities.data.CriteriaTwoRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

/**
 * The ViewModel used in [CriteriaTwo Fragment].
 */
public class CriteriaTwoViewModel extends ViewModel {
    private CriteriaTwoRepository criteriaTwoRepository;

    private String criteriatwoId;

    private  LiveData<Boolean> isDisabled;
    public LiveData <CriteriaTwo> criteriaTwo;

    CriteriaTwoViewModel(CriteriaTwoRepository criteriaTwoRepository, String criteriatwoId) {
        super();
        this.criteriaTwoRepository = criteriaTwoRepository;
        this.criteriatwoId = criteriatwoId;

        /* The getCriteriaTwo method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData <CriteriaTwo> criteriaOne= criteriaTwoRepository.getCriteriaTwo (criteriatwoId);
        this.isDisabled = Transformations.map(criteriaOne, it -> it != null);
        this.criteriaTwo = criteriaTwoRepository.getCriteriaTwo (criteriatwoId);
    }


    public void addDisabilityToHiddenDisabilities() {
        AppExecutors.getInstance().diskIO().execute(() -> criteriaTwoRepository.getCriteriaTwo (criteriatwoId));
    }

    public LiveData<Boolean> getIsDisabled() {
        return isDisabled;
    }
}
