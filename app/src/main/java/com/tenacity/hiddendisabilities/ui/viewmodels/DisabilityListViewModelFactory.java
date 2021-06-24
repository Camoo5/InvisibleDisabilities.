package com.tenacity.hiddendisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.hiddendisabilities.data.DisabilityRepository;


public class DisabilityListViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final DisabilityRepository repository;

    public DisabilityListViewModelFactory(@NonNull DisabilityRepository repository) {
        super();
        this.repository = repository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new DisabilityListViewModel(repository);
    }
}