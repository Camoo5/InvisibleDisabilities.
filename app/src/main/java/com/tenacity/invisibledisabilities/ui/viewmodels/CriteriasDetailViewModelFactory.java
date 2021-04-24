package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.CriteriasRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;


public class CriteriasDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final String criteriaoneId;
    private final CriteriasRepository criteriaOneRepository;
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    public CriteriasDetailViewModelFactory(CriteriasRepository criteriaOneRepository, HiddenDisabilityRepository hiddenDisabilityRepository,
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
        return (T) new CriteriasListViewModel (criteriaOneRepository, hiddenDisabilityRepository, criteriaoneId);
    }
}
