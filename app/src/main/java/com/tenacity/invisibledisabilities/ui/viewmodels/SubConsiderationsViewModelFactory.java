package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.data.SubConsiderationsRepository;


public class SubConsiderationsViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private String subconsiderationsId;
    private SubConsiderationsRepository subConsiderationsRepository;

    public  SubConsiderationsViewModelFactory(@NonNull SubConsiderationsRepository subConsiderationsRepository, String subconsiderationsId) {
        super();
        this.subConsiderationsRepository = subConsiderationsRepository;
        this.subconsiderationsId= subconsiderationsId;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SubConsiderationsViewModel(subConsiderationsRepository, subconsiderationsId );
    }
}