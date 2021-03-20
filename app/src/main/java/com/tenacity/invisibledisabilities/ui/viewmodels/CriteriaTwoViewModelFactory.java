package com.tenacity.invisibledisabilities.ui.viewmodels;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import com.tenacity.invisibledisabilities.data.CriteriaTwoRepository;


public class CriteriaTwoViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private String criteriatwoId;
    private final CriteriaTwoRepository criteriatworepository;

    public CriteriaTwoViewModelFactory(@NonNull CriteriaTwoRepository criteriaTworepository) {
        super();
        this.criteriatworepository = criteriaTworepository;
        this.criteriatwoId = criteriatwoId;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CriteriaTwoViewModel(criteriatworepository, criteriatwoId );
    }
}