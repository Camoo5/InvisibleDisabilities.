package com.tenacity.invisibledisabilities.ui.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.CriteriaOne;
import com.tenacity.invisibledisabilities.data.CriteriaOneRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

/**
 * The ViewModel used in [CriteriaOneFragment].
 */
public class CriteriaOneViewModel extends ViewModel {
    private final CriteriaOneRepository criteriaOneRepository;

    private final String criteriaoneId;

    private final LiveData<Boolean> isDisabled;
    public LiveData<CriteriaOne> criteriaOneLiveData;

    public CriteriaOneViewModel(CriteriaOneRepository criteriaOneRepository, String criteriaoneId) {
        super();
        this.criteriaOneRepository = criteriaOneRepository;
        this.criteriaoneId = criteriaoneId;

        /* The getCriteriaOne method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData<CriteriaOne> criteriaOneLiveData= criteriaOneRepository.getCriteriaOne (criteriaoneId);
        this.isDisabled = Transformations.map(criteriaOneLiveData, it -> it != null);
        this.criteriaOneLiveData = criteriaOneRepository.getCriteriaOne (criteriaoneId);
    }
    public void addDisabilityToHiddenDisabilities() {
        AppExecutors.getInstance().diskIO().execute(() -> criteriaOneRepository.getCriteriaOne (criteriaoneId));
    }

    public LiveData<Boolean> getIsDisabled() {
        return isDisabled;
    }
}

