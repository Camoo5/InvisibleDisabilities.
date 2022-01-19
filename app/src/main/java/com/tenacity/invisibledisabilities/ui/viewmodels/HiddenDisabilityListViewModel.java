package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.annotation.NonNull;
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

     HiddenDisabilityListViewModel(@NonNull HiddenDisabilityRepository repository) {
        this.hiddenDisabilities = repository.getHiddenDisabilities();
        this.disabilityAndHiddenDisabilities = Transformations.map(repository.getDisabilityAndHiddenDisabilities(), items -> {
        List<DisabilityAndHiddenDisabilities> removeItems = new ArrayList<>();
        for (DisabilityAndHiddenDisabilities item:items) {
            if (item.getHiddenDisabilities().isEmpty()) {
                removeItems.add(item);
            }
             }
            items.removeAll(removeItems);
            return items;
        });
     }
}