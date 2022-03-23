package com.tenacity.invisibledisabilities.ui.viewmodels;

import android.content.Context;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.R;
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
        String disabilityDateStr = dateFormat.format(hiddenDisability.disabilityDate.getTime());

        imageUrl = new ObservableField<>(disability.getImageUrl());
        disabilityDate = new ObservableField<String>(
                context.getString(R.string.disabled_date, disability.getName(), disabilityDateStr));
    }

    public Disability getDisability() {
        return disability;
    }

    public void setDisability(Disability disability) {
        this.disability = disability;
    }

    public ObservableField<String> getImageUrl() {
        return imageUrl;

    }

    public ObservableField<String> getDisabilityDate() {
        return disabilityDate;

    }

    public HiddenDisability getHiddenDisability() {
        return hiddenDisability;
    }

    public void setHiddenDisability(HiddenDisability hiddenDisability ) {
        this.hiddenDisability = hiddenDisability;

    }
}

