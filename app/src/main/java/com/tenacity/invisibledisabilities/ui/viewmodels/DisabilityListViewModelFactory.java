package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.DisabilityRepository;


public class DisabilityListViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private DisabilityRepository disabilityRepository;

    public DisabilityListViewModelFactory(@NonNull  DisabilityRepository disabilityRepository) {
        super();
        this.disabilityRepository = disabilityRepository;
    }

    @NonNull
    @Override

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
       DisabilityListViewModel disabilityListViewModel = new DisabilityListViewModel(disabilityRepository);
        return (T)  disabilityListViewModel;
    }
}