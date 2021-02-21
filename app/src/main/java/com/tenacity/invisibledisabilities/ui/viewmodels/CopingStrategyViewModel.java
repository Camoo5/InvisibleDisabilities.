package com.tenacity.invisibledisabilities.ui.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.CopingStrategy;
import com.tenacity.invisibledisabilities.data.CopingStrategyRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

/**
 * The ViewModel used in [CopingStrategyFragment].
 */
public class CopingStrategyViewModel extends ViewModel {
    private CopingStrategyRepository copingStrategyRepository;

    private String copingstrategyId;

    private  LiveData<Boolean> isDisabled;
    public LiveData <CopingStrategy> copingStrategy;

  CopingStrategyViewModel(CopingStrategyRepository copingStrategyRepository, String copingstrategyId) {
        super();
        this.copingStrategyRepository = copingStrategyRepository;
        this.copingstrategyId = copingstrategyId;

        /* The getCopingStrategy method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData <CopingStrategy> copingStrategy = copingStrategyRepository.getCopingStrategy (copingstrategyId);
        this.isDisabled = Transformations.map(copingStrategy, it -> it != null);
        this.copingStrategy = copingStrategyRepository.getCopingStrategy (copingstrategyId);
    }



    public void addDisabilityToHiddenDisabilities() {
        AppExecutors.getInstance().diskIO().execute(() -> copingStrategyRepository.getCopingStrategy (copingstrategyId));
    }

    public LiveData<Boolean> getIsDisabled() {
        return isDisabled;
    }
}

