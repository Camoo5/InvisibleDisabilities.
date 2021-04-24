package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.Criterias;
import com.tenacity.invisibledisabilities.data.CriteriasAndHiddenDisabilities;
import com.tenacity.invisibledisabilities.data.HiddenDisability;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;



public class CriteriasAndHiddenDisabilitiesViewModel extends ViewModel {

    public ObservableField<String> imageUrl;
    public ObservableField<String> criteriaone;
    public ObservableField<String> criteriaoneDateString;

    public CriteriasAndHiddenDisabilitiesViewModel(@NonNull CriteriasAndHiddenDisabilities disabilities) {
        final Criterias criteriaOne= (disabilities.getCriteriaOne ());
        final HiddenDisability hiddenDisability = disabilities.getHiddenDisabilities().get(0);
        final DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.UK);

        this.imageUrl = new ObservableField<>(criteriaOne.getImageUrl());
        this.criteriaone = new ObservableField<>(criteriaOne.getName());
        this.criteriaoneDateString = new ObservableField<>(dateFormat.format( hiddenDisability.getDisabilityDate().getTime()));
    }
}