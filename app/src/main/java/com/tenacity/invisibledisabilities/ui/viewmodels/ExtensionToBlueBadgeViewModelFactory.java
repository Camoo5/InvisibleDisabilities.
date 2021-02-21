package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.ExtensionToBlueBadgeRepository;


public class ExtensionToBlueBadgeViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private String extensiontobluebadgeId;
    private ExtensionToBlueBadgeRepository extensionToBlueBadgeRepository;

    public ExtensionToBlueBadgeViewModelFactory(@NonNull ExtensionToBlueBadgeRepository extensionToBlueBadgeRepository) {
        super();
        this.extensionToBlueBadgeRepository = extensionToBlueBadgeRepository;
        this.extensiontobluebadgeId = extensiontobluebadgeId;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ExtensionToBlueBadgeViewModel(extensionToBlueBadgeRepository, extensiontobluebadgeId );
    }
}