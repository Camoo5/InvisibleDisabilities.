package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.HiddenDisability;
import com.tenacity.invisibledisabilities.data.Practitioner;
import com.tenacity.invisibledisabilities.data.PractitionerAndHiddenDisabilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;



public class PractitionerAndHiddenDisabilitiesViewModel extends ViewModel {

    public ObservableField<String> imageUrl;
    public ObservableField<String> practitioner;
    public ObservableField<String> practitionerDateString;

    public PractitionerAndHiddenDisabilitiesViewModel(@NonNull PractitionerAndHiddenDisabilities disabilities) {
        final Practitioner practitioner = (disabilities.getPractitioner());
        final HiddenDisability hiddenDisability = disabilities.getHiddenDisabilities().get(0);
        final DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.UK);

        this.imageUrl = new ObservableField<>(practitioner.getImageUrl());
        this.practitioner = new ObservableField<>(practitioner.getName());
        this.practitionerDateString = new ObservableField<>(dateFormat.format( hiddenDisability.getDisabilityDate().getTime()));
    }
}