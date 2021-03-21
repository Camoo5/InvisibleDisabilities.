package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.HiddenDisability;
import com.tenacity.invisibledisabilities.data.SubConsiderations;
import com.tenacity.invisibledisabilities.data.SubConsiderationsAndHiddenDisabilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;



public class SubConsiderationsAndHiddenDisabilitiesViewModel extends ViewModel {

    public ObservableField<String> imageUrl;
    public ObservableField<String> subConsiderations;
    public ObservableField<String> subConsiderationsDateString;

    public SubConsiderationsAndHiddenDisabilitiesViewModel(@NonNull SubConsiderationsAndHiddenDisabilities disabilities) {
        final SubConsiderations subConsiderations= (disabilities.getSubConsiderations ());
        final HiddenDisability hiddenDisability = disabilities.getHiddenDisabilities().get(0);
        final DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.UK);

        this.imageUrl = new ObservableField<>(subConsiderations.getImageUrl());
        this.subConsiderations = new ObservableField<>(subConsiderations.getName());
        this.subConsiderationsDateString= new ObservableField<>(dateFormat.format( hiddenDisability.getDisabilityDate().getTime()));
    }
}