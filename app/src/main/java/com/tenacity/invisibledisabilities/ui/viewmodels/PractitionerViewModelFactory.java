package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.data.PractitionerRepository;


public class PractitionerViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final String practitionerId;
    private final PractitionerRepository practitionerRepository;
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    public PractitionerViewModelFactory(PractitionerRepository practitionerRepository, HiddenDisabilityRepository hiddenDisabilityRepository,
                                                String practitionerId) {

        this.practitionerId= practitionerId;
        this.practitionerRepository = practitionerRepository;
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PractitionerViewModel(practitionerRepository, hiddenDisabilityRepository, practitionerId);
    }
}