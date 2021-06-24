package com.tenacity.hiddendisabilities.ui.viewmodels;


import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.hiddendisabilities.data.Disability;
import com.tenacity.hiddendisabilities.data.DisabilityRepository;

import java.util.List;


public class DisabilityListViewModel extends ViewModel {
    private static final int NO_CRITERIA_TYPE = -1;

    private final DisabilityRepository disabilityRepository;

    private final MutableLiveData<Integer> criteriaType;

    public LiveData<List<Disability>> disabilities;

    DisabilityListViewModel(@NonNull DisabilityRepository disabilityRepository) {
        super();
        this.disabilityRepository = disabilityRepository;
        this.criteriaType = new MutableLiveData<>(-1);
        this.disabilities = Transformations.switchMap(criteriaType, it -> {
            if (it == NO_CRITERIA_TYPE) {
                return this.disabilityRepository.getDisabilities();
            } else {
                return this.disabilityRepository.getDisabilitiesWithCriteriaType(it);
            }
        });
    }

    public void setCriteriaType(int num) {
        this.criteriaType.setValue(num);
    }

    public void cleanCriteriaType() {
        this.criteriaType.setValue(NO_CRITERIA_TYPE);
    }

    public boolean isFiltered() {
        return this.criteriaType.getValue() != NO_CRITERIA_TYPE;
    }
}