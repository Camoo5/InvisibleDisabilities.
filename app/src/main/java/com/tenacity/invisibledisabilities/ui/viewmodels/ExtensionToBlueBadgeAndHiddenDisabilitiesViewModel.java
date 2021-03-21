package com.tenacity.invisibledisabilities.ui.viewmodels;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.ExtensionToBlueBadgeRepository;


public class ExtensionToBlueBadgeAndHiddenDisabilitiesViewModel extends ViewModelProvider.NewInstanceFactory {
    private String extensiontobluebadgeId;
    private final ExtensionToBlueBadgeRepository extensionToBlueBadgeRepository;

    public ExtensionToBlueBadgeAndHiddenDisabilitiesViewModel(@NonNull ExtensionToBlueBadgeRepository extensionToBlueBadgeRepository) {
        super();
        this.extensionToBlueBadgeRepository = extensionToBlueBadgeRepository;
        this.extensiontobluebadgeId = extensiontobluebadgeId;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ExtensionToBlueBadgeViewModel(extensionToBlueBadgeRepository, extensiontobluebadgeId );
    }
}