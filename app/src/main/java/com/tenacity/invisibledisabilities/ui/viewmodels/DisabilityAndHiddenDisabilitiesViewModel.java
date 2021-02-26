package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.data.DisabilityAndHiddenDisabilities;
import com.tenacity.invisibledisabilities.data.HiddenDisability;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static androidx.core.util.Preconditions.checkNotNull;

public class DisabilityAndHiddenDisabilitiesViewModel extends ViewModel {

    public ObservableField<String> imageUrl;
    public ObservableField<String> disabilityName;
    public ObservableField<String> disabilityDateString;

    public DisabilityAndHiddenDisabilitiesViewModel(@NonNull DisabilityAndHiddenDisabilities disabilities) {
        final Disability disability = checkNotNull(disabilities.getDisability());
        final HiddenDisability hiddenDisability = disabilities.getHiddenDisabilities().get(0);
        final DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.UK);

        this.imageUrl = new ObservableField<>(disability.getImageUrl());
        this.disabilityName = new ObservableField<>(disability.getName());
        this.disabilityDateString = new ObservableField<>(dateFormat.format( hiddenDisability.getDisabilityDate().getTime()));
    }
}