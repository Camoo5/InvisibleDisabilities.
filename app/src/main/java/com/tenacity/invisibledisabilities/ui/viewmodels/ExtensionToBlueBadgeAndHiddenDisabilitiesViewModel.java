package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.ExtensionToBlueBadge;
import com.tenacity.invisibledisabilities.data.ExtensionToBlueBadgeAndHiddenDisabilities;
import com.tenacity.invisibledisabilities.data.HiddenDisability;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;



public class ExtensionToBlueBadgeAndHiddenDisabilitiesViewModel extends ViewModel {

    public ObservableField<String> imageUrl;
    public ObservableField<String> extensiontobluebadge;
    public ObservableField<String> extensiontobluebadgeDateString;

    public ExtensionToBlueBadgeAndHiddenDisabilitiesViewModel(@NonNull ExtensionToBlueBadgeAndHiddenDisabilities disabilities) {
        final ExtensionToBlueBadge extensionToBlueBadge= (disabilities.getExtensionToBlueBadge());
        final HiddenDisability hiddenDisability = disabilities.getHiddenDisabilities().get(0);
        final DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.UK);

        this.imageUrl = new ObservableField<>(extensionToBlueBadge.getImageUrl());
        this.extensiontobluebadge = new ObservableField<>(extensionToBlueBadge.getName());
        this.extensiontobluebadgeDateString = new ObservableField<>(dateFormat.format( hiddenDisability.getDisabilityDate().getTime()));
    }
}