package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.DisabilityRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;


public class DisabilityDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final String disabilityId;
    private final DisabilityRepository disabilityRepository;
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    public DisabilityDetailViewModelFactory(DisabilityRepository disabilityRepository, HiddenDisabilityRepository hiddenDisabilityRepository,
            String disabilityId) {

        this.disabilityId = disabilityId;
        this.disabilityRepository = disabilityRepository;
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
    }


    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new DisabilityDetailViewModel (disabilityRepository, hiddenDisabilityRepository, disabilityId);
    }
}