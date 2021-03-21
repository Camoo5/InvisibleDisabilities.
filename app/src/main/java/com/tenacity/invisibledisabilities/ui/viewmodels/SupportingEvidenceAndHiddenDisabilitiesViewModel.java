package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.HiddenDisability;
import com.tenacity.invisibledisabilities.data.SupportingEvidence;
import com.tenacity.invisibledisabilities.data.SupportingEvidenceAndHiddenDisabilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;



public class SupportingEvidenceAndHiddenDisabilitiesViewModel extends ViewModel {

    public ObservableField<String> imageUrl;
    public ObservableField<String> supportingevidence;
    public ObservableField<String> supportingevidenceDateString;

    public SupportingEvidenceAndHiddenDisabilitiesViewModel(@NonNull SupportingEvidenceAndHiddenDisabilities disabilities) {
        final SupportingEvidence supportingEvidence= (disabilities.getSupportingEvidence ());
        final HiddenDisability hiddenDisability = disabilities.getHiddenDisabilities().get(0);
        final DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.UK);

        this.imageUrl = new ObservableField<>(supportingEvidence.getImageUrl());
        this.supportingevidence = new ObservableField<>(supportingEvidence.getName());
        this.supportingevidenceDateString= new ObservableField<>(dateFormat.format( hiddenDisability.getDisabilityDate().getTime()));
    }
}