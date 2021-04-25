package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.ExtensionToBlueBadgeRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;


public class ExtensionToBlueBadgeListViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final String extensiontobluebadgeId;
    private final ExtensionToBlueBadgeRepository extensionToBlueBadgeRepository;
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    public ExtensionToBlueBadgeListViewModelFactory(ExtensionToBlueBadgeRepository extensionToBlueBadgeRepository, HiddenDisabilityRepository hiddenDisabilityRepository,
                                                    String extensiontobluebadgeId) {

        this.extensiontobluebadgeId= extensiontobluebadgeId;
        this.extensionToBlueBadgeRepository = extensionToBlueBadgeRepository;
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ExtensionToBlueBadgeListViewModel (extensionToBlueBadgeRepository, hiddenDisabilityRepository, extensiontobluebadgeId);
    }
}