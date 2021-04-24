package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.data.SubConsiderationsRepository;


public class SubConsiderationsListViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final String subConsiderationsId;
    private final SubConsiderationsRepository subConsiderationsRepository;
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    public SubConsiderationsListViewModelFactory(SubConsiderationsRepository subConsiderationsRepository, HiddenDisabilityRepository hiddenDisabilityRepository,
                                                 String subconsiderationsId) {

        this.subConsiderationsId= subconsiderationsId;
        this.subConsiderationsRepository = subConsiderationsRepository;
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SubConsiderationsListViewModel (subConsiderationsRepository, hiddenDisabilityRepository, subConsiderationsId);
    }
}