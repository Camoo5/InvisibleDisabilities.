package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.PractitionerRepository;


public class PractitionerViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private String practitionerId;
    private PractitionerRepository practitionerRepository;

    public PractitionerViewModelFactory(@NonNull PractitionerRepository practitionerRepository) {
        super();
        this.practitionerRepository = practitionerRepository;
        this.practitionerId = practitionerId;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PractitionerViewModel(practitionerRepository, practitionerId );
    }
}