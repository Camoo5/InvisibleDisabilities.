package com.tenacity.invisibledisabilities.ui.viewmodels;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.PractitionerRepository;


public class PractitionerAndHiddenDisabilitiesViewModel extends ViewModelProvider.NewInstanceFactory {
    private String practitionerId;
    private final PractitionerRepository practitionerRepository;

    public PractitionerAndHiddenDisabilitiesViewModel(@NonNull PractitionerRepository practitionerRepository) {
        super();
        this.practitionerRepository = practitionerRepository;
        this.practitionerId =practitionerId;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PractitionerViewModel(practitionerRepository, practitionerId );
    }
}