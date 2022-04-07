package com.tenacity.invisibledisabilities.ui.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.data.DisabilityRepository;

import java.util.List;


public class DisabilityListViewModel extends ViewModel {
    private DisabilityRepository disabilityRepository;
    private int NO_CRITERIA_TYPE = -1;
    private MutableLiveData<Integer> criteriaTypeNumber = new MutableLiveData<>();
    private MediatorLiveData<List<Disability>> disabilityList = new MediatorLiveData<>();

    DisabilityListViewModel(DisabilityRepository disabilityRepository) {
        this.disabilityRepository = disabilityRepository;
        criteriaTypeNumber.setValue(NO_CRITERIA_TYPE);

        LiveData<List<Disability>> liveDisabilityList = Transformations.switchMap(criteriaTypeNumber, (ct_no) -> {
            if (ct_no == NO_CRITERIA_TYPE) {
                return disabilityRepository.getDisabilities();
            } else {
                return disabilityRepository.getDisabilitiesByCriteriaTypeNumber(ct_no);
            }
        });

        disabilityList.addSource(liveDisabilityList, disabilities -> disabilityList.setValue(disabilities));
    }


    public MediatorLiveData<List<Disability>> getDisabilities() {
        return disabilityList;
    }

    public void setCriteriaTypeNumber(int no) {
        criteriaTypeNumber.setValue(no);
    }

    public void clearCriteriaTypeNumber() {
        criteriaTypeNumber.setValue(NO_CRITERIA_TYPE);
    }

    public boolean isFiltered() {
        return criteriaTypeNumber.getValue() != NO_CRITERIA_TYPE;
    }
}