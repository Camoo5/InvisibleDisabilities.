package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.CopingStrategyRepository;
import com.tenacity.invisibledisabilities.data.CriteriaOne;
import com.tenacity.invisibledisabilities.data.CriteriaOneRepository;


public class CriteriaOneAndHiddenDisabilitiesViewModel extends ViewModelProvider.NewInstanceFactory {
    private final CriteriaOneRepository criteriaOneRepository;
    private String criteriaoneId;




    public CriteriaOneAndHiddenDisabilitiesViewModel(@NonNull CriteriaOneRepository criteriaOneRepository) {
        super();
        this.criteriaOneRepository= criteriaOneRepository;
        this.criteriaoneId = criteriaoneId;
    }


    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CriteriaOneviewModel(criteriaOneRepository, criteriaoneId);
    }
}