package com.tenacity.invisibledisabilities.ui.viewmodels;

import android.content.Context;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.data.DisabilityAndHiddenDisabilities;
import com.tenacity.invisibledisabilities.data.HiddenDisability;

import java.text.SimpleDateFormat;
import java.util.Locale;



public class DisabilityAndHiddenDisabilitiesViewModel extends ViewModel {
    private final ObservableField<String> imageUrl;
    private final ObservableField<String> disabilityDate;
    private Disability disability;
    private HiddenDisability hiddenDisability;

    public DisabilityAndHiddenDisabilitiesViewModel(Context context, DisabilityAndHiddenDisabilities disabilities) {

        this.disability = disabilities.getDisability();
        this.hiddenDisability = disabilities.getHiddenDisabilities().get(0);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.UK);

        imageUrl = new ObservableField<>(disability.getImageUrl());
        disabilityDate = new ObservableField<>(dateFormat.format(hiddenDisability.getDisabilityDate().getTime()));
    }

    public ObservableField<String> getImageUrl() {
        return imageUrl;

    }
}

