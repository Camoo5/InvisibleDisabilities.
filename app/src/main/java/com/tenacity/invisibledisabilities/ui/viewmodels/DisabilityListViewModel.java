package com.tenacity.invisibledisabilities.ui.viewmodels;


import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.data.DisabilityRepository;

import java.util.List;


public class DisabilityListViewModel extends ViewModel {

    public  LiveData<List<Disability>> disabilities;
    private DisabilityRepository disabilityRepository;

    DisabilityListViewModel(@NonNull DisabilityRepository disabilityRepository) {
        super();
        this.disabilityRepository = disabilityRepository;
        this.disabilities = disabilityRepository.getDisabilities(disabilityRepository);

        disabilityRepository.getDisabilities(disabilityRepository);




    }


}