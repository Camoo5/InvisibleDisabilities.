package com.tenacity.hiddendisabilities.ui.viewmodels;



import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.hiddendisabilities.data.HiddenDisabilityRepository;

/**
 * Factory for creating a [HiddenDisabilityListViewModel] with a constructor that takes a
 * [HiddenDisabilityRepository].
 */
public class HiddenDisabilityListViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final HiddenDisabilityRepository repository;

    public HiddenDisabilityListViewModelFactory(@NonNull HiddenDisabilityRepository repository) {
        super();
        this.repository = repository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HiddenDisabilityListViewModel (repository);
    }
}