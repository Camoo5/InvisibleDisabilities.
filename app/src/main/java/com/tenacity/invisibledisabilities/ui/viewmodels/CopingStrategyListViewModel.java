package com.tenacity.invisibledisabilities.ui.viewmodels;


import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.CopingStrategy;
import com.tenacity.invisibledisabilities.data.CopingStrategyRepository;
import com.tenacity.invisibledisabilities.data.DisabilityRepository;

import java.util.List;

public class   CopingStrategyListViewModel extends ViewModel {
    private static final int NO_CRITERIA_TYPE = -1;

    private final CopingStrategyRepository copingStrategyRepository;

    private final MutableLiveData <Integer> criteriaTypeNumber;

    public LiveData<List <CopingStrategy>> copingstrategies;

    CopingStrategyListViewModel(@NonNull CopingStrategyRepository copingStrategyRepository) {
        super();
        this.copingStrategyRepository = copingStrategyRepository;
        this.criteriaTypeNumber = new MutableLiveData<>(-1);
        this.copingstrategies = Transformations.switchMap(criteriaTypeNumber, it -> {
            if (it == NO_CRITERIA_TYPE) {
                return this.copingStrategyRepository.getCopingstrategies();
            } else {
                return this.copingStrategyRepository.getCopingstrategiesWithCriteriaTypeNumber (it);
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