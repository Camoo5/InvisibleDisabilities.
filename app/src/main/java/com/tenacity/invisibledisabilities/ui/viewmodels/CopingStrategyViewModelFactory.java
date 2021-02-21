package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.CopingStrategyRepository;



public class CopingStrategyViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private CopingStrategyRepository copingStrategyRepository;
    private String copingstrategyId;

    public CopingStrategyViewModelFactory(@NonNull CopingStrategyRepository copingStrategyRepository, String copingstrategyId) {
        super();
        this.copingStrategyRepository= copingStrategyRepository;
        this.copingstrategyId = copingstrategyId;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CopingStrategyViewModel(copingStrategyRepository, copingstrategyId);
    }
}