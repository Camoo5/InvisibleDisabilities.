package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.CriteriaOneRepository;


public class CriteriaOneViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private String criteriaoneId;
    private CriteriaOneRepository criteriaOneRepository;

    public CriteriaOneViewModelFactory(CriteriaOneRepository criteriaOneRepository) {
        super();
        this.criteriaOneRepository = criteriaOneRepository;
        this.criteriaoneId = criteriaoneId;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CriteriaOneViewModel(criteriaOneRepository, criteriaoneId );
    }
}

