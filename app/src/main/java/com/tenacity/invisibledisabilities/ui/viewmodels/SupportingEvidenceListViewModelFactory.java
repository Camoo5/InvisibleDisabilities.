package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.data.SupportingEvidenceRepository;


public class SupportingEvidenceListViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final String supportingevidenceId;
    private final SupportingEvidenceRepository supportingEvidenceRepository;
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    public SupportingEvidenceListViewModelFactory(SupportingEvidenceRepository supportingEvidenceRepository, HiddenDisabilityRepository hiddenDisabilityRepository,
                                                  String supportingevidenceId) {

        this.supportingevidenceId= supportingevidenceId;
        this.supportingEvidenceRepository = supportingEvidenceRepository;
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SupportingEvidenceListViewModel (supportingEvidenceRepository, hiddenDisabilityRepository, supportingevidenceId);
    }
}