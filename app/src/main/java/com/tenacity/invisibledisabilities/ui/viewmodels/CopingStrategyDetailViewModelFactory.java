package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.CopingStrategyRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;

public class CopingStrategyDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final String copingstrategyId;
    private final CopingStrategyRepository copingStrategyRepository;
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    public CopingStrategyDetailViewModelFactory (CopingStrategyRepository copingStrategyRepository, HiddenDisabilityRepository hiddenDisabilityRepository,
                                            String copingstrategyId) {

        this.copingstrategyId = copingstrategyId;
        this.copingStrategyRepository = copingStrategyRepository;
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CopingStrategyDetailViewModel(copingStrategyRepository, hiddenDisabilityRepository, copingstrategyId);
    }
}