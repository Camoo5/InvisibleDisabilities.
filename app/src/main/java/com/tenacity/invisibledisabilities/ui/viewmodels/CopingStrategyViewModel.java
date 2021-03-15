package com.tenacity.invisibledisabilities.ui.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.CopingStrategy;
import com.tenacity.invisibledisabilities.data.CopingStrategyRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisability;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

/**
 * The ViewModel used in [CopingStrategyFragment].
 */
public class CopingStrategyViewModel extends ViewModel {
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    private final String copingstrategyId;

    private final LiveData<Boolean> isDisabled;
    public LiveData<CopingStrategy> copingStrategy;

    CopingStrategyViewModel(CopingStrategyRepository copingStrategyRepository, HiddenDisabilityRepository hiddenDisabilityRepository, String copingstrategyId) {
        super();
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
        this.copingstrategyId= copingstrategyId;

        /* The getHiddenDisabilitiesForCopingStrategy method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData<HiddenDisability> hiddenDisabilityForCopingStrategy = hiddenDisabilityRepository.getHiddenDisabilityForCopingStrategy(copingstrategyId);
        this.isDisabled= Transformations.map(hiddenDisabilityForCopingStrategy, it -> it != null);
        this.copingStrategy = copingStrategyRepository.getCopingStrategy (copingstrategyId);
    }

    public void addCopingStrategyToHiddenDisability() {
        AppExecutors.getInstance().diskIO().execute(() -> hiddenDisabilityRepository.createHiddenDisability(copingstrategyId));
    }

    public LiveData<Boolean> getIsDisabled() {
        return isDisabled;
    }
}
