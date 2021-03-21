package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.CriteriaTwo;
import com.tenacity.invisibledisabilities.data.CriteriaTwoAndHiddenDisabilities;
import com.tenacity.invisibledisabilities.data.HiddenDisability;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;



public class CriteriaTwoAndHiddenDisabilitiesViewModel extends ViewModel {

    public ObservableField<String> imageUrl;
    public ObservableField<String> criteriatwo;
    public ObservableField<String> criteriatwoDateString;

    public CriteriaTwoAndHiddenDisabilitiesViewModel(@NonNull CriteriaTwoAndHiddenDisabilities disabilities) {
        final CriteriaTwo criteriaTwo= (disabilities.getCriteriaTwo ());
        final HiddenDisability hiddenDisability = disabilities.getHiddenDisabilities().get(0);
        final DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.UK);

        this.imageUrl = new ObservableField<>(criteriaTwo.getImageUrl());
        this.criteriatwo = new ObservableField<>(criteriaTwo.getName());
        this.criteriatwoDateString = new ObservableField<>(dateFormat.format( hiddenDisability.getDisabilityDate().getTime()));
    }
}