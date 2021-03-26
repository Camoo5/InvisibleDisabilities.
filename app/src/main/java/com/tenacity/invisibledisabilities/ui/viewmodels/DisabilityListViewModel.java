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
    private static final int NO_CRITERIA_TYPE = -1;

    private final DisabilityRepository disabilityRepository;

    private final MutableLiveData<Integer> criteriaTypeNumber;

    public LiveData<List<Disability>> disabilities;

    DisabilityListViewModel(@NonNull DisabilityRepository disabilityRepository) {
        super();
        this.disabilityRepository = disabilityRepository;
        this.criteriaTypeNumber = new MutableLiveData<>(-1);
        this.disabilities = Transformations.switchMap(criteriaTypeNumber, it -> {
            if (it == NO_CRITERIA_TYPE) {
                return this.disabilityRepository.getDisabilities();
            } else {
                return this.disabilityRepository.getDisabilitiesWithCriteriaTypeNumber (it);
            }
        });
    }

    public void setCriteriaTypeNumber(int num) {
        this.criteriaTypeNumber.setValue(num);
    }

    public void cleanCriteriaTypeNumber() {
        this.criteriaTypeNumber.setValue(NO_CRITERIA_TYPE);
    }

    public boolean isFiltered() {
        return this.criteriaTypeNumber.getValue() != NO_CRITERIA_TYPE;
    }
}