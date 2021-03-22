package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.CriteriaOneRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;


public class CriteriaOneViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final String criteriaoneId;
    private final CriteriaOneRepository criteriaOneRepository;
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    public CriteriaOneViewModelFactory(CriteriaOneRepository criteriaOneRepository, HiddenDisabilityRepository hiddenDisabilityRepository,
                                        String criteriaoneId) {

        this.criteriaoneId= criteriaoneId;
        this.criteriaOneRepository = criteriaOneRepository;
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CriteriaOneViewModel(criteriaOneRepository, hiddenDisabilityRepository, criteriaoneId);
    }
}
