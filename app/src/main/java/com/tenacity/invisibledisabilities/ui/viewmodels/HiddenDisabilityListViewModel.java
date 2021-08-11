package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.DisabilityAndHiddenDisabilities;
import com.tenacity.invisibledisabilities.data.HiddenDisability;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;

import java.util.ArrayList;
import java.util.List;

public class HiddenDisabilityListViewModel extends ViewModel {

    public LiveData <List <DisabilityAndHiddenDisabilities>> disabilityAndHiddenDisabilities;
    public LiveData<List<HiddenDisability>> hiddenDisabilities;

    public HiddenDisabilityListViewModel(HiddenDisabilityRepository hiddenDisabilityRepository) {
        hiddenDisabilities = hiddenDisabilityRepository.getHiddenDisabilities ();
        disabilityAndHiddenDisabilities =
                Transformations.map(hiddenDisabilityRepository.getDisabilityAndHiddenDisabilities (), disabilities -> {
                    List<DisabilityAndHiddenDisabilities> disabilitiesListNew = new ArrayList <> ();
                    for (int i = 0; i < disabilities.size(); i++) {
                        if (disabilities.get(i).getHiddenDisabilities () != null && !disabilities.get(i).getHiddenDisabilities ().isEmpty()) {
                            disabilitiesListNew.add(disabilities.get(i));
                        }
                    }
                    return disabilitiesListNew;
                });
    }


}
