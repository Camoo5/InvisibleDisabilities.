package com.tenacity.hiddendisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.tenacity.hiddendisabilities.data.Disability;
import com.tenacity.hiddendisabilities.data.DisabilityAndHiddenDisabilities;
import com.tenacity.hiddendisabilities.data.HiddenDisability;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;



public class DisabilityAndHiddenDisabilitiesViewModel extends ViewModel {

    public ObservableField<String> imageUrl;
    public ObservableField<String> disabilityName;
    public ObservableField<String> disabilityDateString;

    public DisabilityAndHiddenDisabilitiesViewModel(@NonNull DisabilityAndHiddenDisabilities disabilities) {
        final Disability disability = (disabilities.getDisability());
        final HiddenDisability hiddenDisability = disabilities.getHiddenDisabilities().get(0);
        final DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.UK);

        this.imageUrl = new ObservableField<>(disability.getImageUrl());
        this.disabilityName = new ObservableField<>(disability.getName());
        this.disabilityDateString = new ObservableField<>(dateFormat.format( hiddenDisability.getDisabilityDate().getTime()));
    }
}