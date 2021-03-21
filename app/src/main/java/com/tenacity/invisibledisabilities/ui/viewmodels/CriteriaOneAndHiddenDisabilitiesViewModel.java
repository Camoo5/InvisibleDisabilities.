package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.CriteriaOne;
import com.tenacity.invisibledisabilities.data.CriteriaOneAndHiddenDisabilities;
import com.tenacity.invisibledisabilities.data.HiddenDisability;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;



public class CriteriaOneAndHiddenDisabilitiesViewModel extends ViewModel {

    public ObservableField<String> imageUrl;
    public ObservableField<String> criteriaone;
    public ObservableField<String> criteriaoneDateString;

    public CriteriaOneAndHiddenDisabilitiesViewModel(@NonNull CriteriaOneAndHiddenDisabilities disabilities) {
        final CriteriaOne criteriaOne= (disabilities.getCriteriaOne ());
        final HiddenDisability hiddenDisability = disabilities.getHiddenDisabilities().get(0);
        final DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.UK);

        this.imageUrl = new ObservableField<>(criteriaOne.getImageUrl());
        this.criteriaone = new ObservableField<>(criteriaOne.getName());
        this.criteriaoneDateString = new ObservableField<>(dateFormat.format( hiddenDisability.getDisabilityDate().getTime()));
    }
}