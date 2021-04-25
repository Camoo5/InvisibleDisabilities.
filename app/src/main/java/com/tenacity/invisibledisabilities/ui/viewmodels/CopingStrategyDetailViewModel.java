package com.tenacity.invisibledisabilities.ui.viewmodels;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.CopingStrategy;
import com.tenacity.invisibledisabilities.data.CopingStrategyRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisability;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

import java.util.Objects;

/**
 * The ViewModel used in [CopingStrategyFragment].
 */
public class CopingStrategyDetailViewModel extends ViewModel {
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    private final String copingstrategyId;

    private final LiveData <Boolean> isDisabled;
    public LiveData<CopingStrategy> copingStrategy;

    @RequiresApi(api = Build.VERSION_CODES.N)
    CopingStrategyDetailViewModel(CopingStrategyRepository copingStrategyRepository, HiddenDisabilityRepository hiddenDisabilityRepository, String copingstrategyId) {
        super();
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
        this.copingstrategyId= copingstrategyId;

        /* The getHiddenDisabilitiesForCopingStrategy method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData<HiddenDisability> getHiddenDisabilitiesForCopingStrategy = hiddenDisabilityRepository.getHiddenDisabilityForDisability ( copingstrategyId );
        this.isDisabled = Transformations.map(getHiddenDisabilitiesForCopingStrategy, Objects::nonNull );
        this.copingStrategy= copingStrategyRepository.getCopingStrategy (copingstrategyId);
    }

    public void addCopingStrategyToHiddenDisability() {
        AppExecutors.getInstance().diskIO().execute(() -> hiddenDisabilityRepository.createHiddenDisability(copingstrategyId));
    }

    public LiveData<Boolean> getIsDisabled() {
        return isDisabled;
    }
}