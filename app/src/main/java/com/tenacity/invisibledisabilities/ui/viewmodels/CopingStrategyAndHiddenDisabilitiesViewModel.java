package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.CopingStrategy;
import com.tenacity.invisibledisabilities.data.CopingStrategyAndHiddenDisabilities;
import com.tenacity.invisibledisabilities.data.HiddenDisability;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;



public class CopingStrategyAndHiddenDisabilitiesViewModel extends ViewModel {

    public ObservableField<String> imageUrl;
    public ObservableField<String> copingstrategy;
    public ObservableField<String> copingstrategyDateString;

    public CopingStrategyAndHiddenDisabilitiesViewModel(@NonNull CopingStrategyAndHiddenDisabilities disabilities) {
        final CopingStrategy copingStrategy= (disabilities.getCopingStrategy ());
        final HiddenDisability hiddenDisability = disabilities.getHiddenDisabilities().get(0);
        final DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.UK);

        this.imageUrl = new ObservableField<>(copingStrategy.getImageUrl());
        this.copingstrategy = new ObservableField<>(copingStrategy.getName());
        this.copingstrategyDateString = new ObservableField<>(dateFormat.format( hiddenDisability.getDisabilityDate().getTime()));
    }
}