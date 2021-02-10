package com.tenacity.invisibledisabilities.ui.viewmodels;


import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.data.DisabilityRepository;

import java.util.List;


public class DisabilityListViewModel extends ViewModel {
    private static final int NO_CRITERIA = -1;

    private final DisabilityRepository disabilityRepository;

    private final MutableLiveData<Integer> criteriaNumber;

    public LiveData<List<Disability>> disabilities;

    DisabilityListViewModel(@NonNull DisabilityRepository disabilityRepository) {
        super();
        this.disabilityRepository = disabilityRepository;
        this.criteriaNumber = new MutableLiveData<>(-1);
        this.disabilities = Transformations.switchMap(criteriaNumber, it -> {
            if (it == NO_CRITERIA) {
                return this.disabilityRepository.getDisabilities();
            } else {
                return this.disabilityRepository.getDisabilitiesWithCriteriaNumber (it);
            }
        });
    }

    public void setCriteriaNumber(int num) {
        this.criteriaNumber.setValue(num);
    }

    public void cleanCriteriaNumber() {
        this.criteriaNumber.setValue(NO_CRITERIA);
    }

    public boolean isFiltered() {
        return this.criteriaNumber.getValue() != NO_CRITERIA;
    }
}