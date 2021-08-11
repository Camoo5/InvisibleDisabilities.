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
    private final int NO_CRITERIA_TYPE = -1;
    private final DisabilityRepository disabilityRepository;
    private final MutableLiveData<Integer> criteriaType = new MutableLiveData<>();
    private final MediatorLiveData<List<Disability>> disabilityList = new MediatorLiveData <> ();

    DisabilityListViewModel(DisabilityRepository disabilityRepository) {
        this.disabilityRepository = disabilityRepository;
        this.criteriaType.setValue ( NO_CRITERIA_TYPE );

        LiveData <List<Disability>> liveDisabilityList = Transformations.switchMap(criteriaType, (cr_ty) -> {
            if (cr_ty == NO_CRITERIA_TYPE) {
                return disabilityRepository.getDisabilities ();
            } else {
                return disabilityRepository.getDisabilitiesWithCriteriaType (cr_ty );
            }
        });

        disabilityList.addSource(liveDisabilityList, disabilities -> disabilityList.setValue(disabilities));
    }

    public MediatorLiveData<List<Disability>> getDisabilities() {
        return disabilityList;
    }

    public void setCriteriaType(int no) {
        criteriaType.setValue(no);
    }

    public void clearCriteriaType() {
        criteriaType.setValue(NO_CRITERIA_TYPE);
    }

    public boolean isFiltered() {
        return criteriaType.getValue() != NO_CRITERIA_TYPE;
    }

}