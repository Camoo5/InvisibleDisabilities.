package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import com.tenacity.invisibledisabilities.data.CriteriaTwoRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;


public class CriteriaTwoViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final String criteriatwoId;
    private final CriteriaTwoRepository criteriaTwoRepository;
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    public CriteriaTwoViewModelFactory(CriteriaTwoRepository criteriaTwoRepository, HiddenDisabilityRepository hiddenDisabilityRepository,
                                       String criteriatwoId) {

        this.criteriatwoId= criteriatwoId;
        this.criteriaTwoRepository = criteriaTwoRepository;
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CriteriaTwoViewModel(criteriaTwoRepository, hiddenDisabilityRepository, criteriatwoId);
    }
}