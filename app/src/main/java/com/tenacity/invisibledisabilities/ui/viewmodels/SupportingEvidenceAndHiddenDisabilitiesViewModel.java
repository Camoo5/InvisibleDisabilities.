package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.SupportingEvidenceRepository;


public class SupportingEvidenceAndHiddenDisabilitiesViewModel extends ViewModelProvider.NewInstanceFactory {
    private String supportingevidenceId;
    private SupportingEvidenceRepository supportingEvidenceRepository;

    public SupportingEvidenceAndHiddenDisabilitiesViewModel(@NonNull SupportingEvidenceRepository supportingEvidenceRepository) {
        super();
        this.supportingEvidenceRepository = supportingEvidenceRepository;
        this.supportingevidenceId= supportingevidenceId;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SupportingEvidenceViewModel(supportingEvidenceRepository, supportingevidenceId );
    }
}