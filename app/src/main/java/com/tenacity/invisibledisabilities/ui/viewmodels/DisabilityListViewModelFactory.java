package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.DisabilityRepository;


public class DisabilityListViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final DisabilityRepository disabilityRepository;

    public DisabilityListViewModelFactory(DisabilityRepository disabilityrepository) {
        this.disabilityRepository = disabilityrepository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
      DisabilityListViewModel disabilityListViewModel = new DisabilityListViewModel ( disabilityRepository );
        return (T) disabilityListViewModel;
    }
}