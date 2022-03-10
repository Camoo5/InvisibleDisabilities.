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
    private int NO_INVISIBLE_CONDITION = -1;
    private MutableLiveData<Integer> invisibleConditionNumber = new MutableLiveData<>();
    private MediatorLiveData<List<Disability>> disabilityList = new MediatorLiveData<>();

    DisabilityListViewModel(DisabilityRepository disabilityRepository) {
        this.disabilityRepository = disabilityRepository;
        invisibleConditionNumber.setValue(NO_INVISIBLE_CONDITION);

        LiveData<List<Disability>> liveDisabilityList = Transformations.switchMap(invisibleConditionNumber, (ic_no) -> {
            if (ic_no == NO_INVISIBLE_CONDITION) {
                return disabilityRepository.getDisabilities();
            } else {
                return disabilityRepository.getDisabilitiesByInvisibleConditionNumber(ic_no);
            }
        });

        disabilityList.addSource(liveDisabilityList, disabilities -> disabilityList.setValue(disabilities));
    }


    public MediatorLiveData<List<Disability>> getDisabilities() {
        return disabilityList;
    }

    public void setInvisibleConditionNumber(int no) {
        invisibleConditionNumber.setValue(no);
    }

    public void clearInvisibleConditionNumber() {
        invisibleConditionNumber.setValue(NO_INVISIBLE_CONDITION);
    }

    public boolean isFiltered() {
        return invisibleConditionNumber.getValue() != NO_INVISIBLE_CONDITION;
    }
}