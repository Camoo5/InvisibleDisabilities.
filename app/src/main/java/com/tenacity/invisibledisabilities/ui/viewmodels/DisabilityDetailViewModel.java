package com.tenacity.invisibledisabilities.ui.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.data.DisabilityRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisability;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;

/**
 * The ViewModel used in [DisabilityDetailFragment].
 */
public class DisabilityDetailViewModel extends ViewModel {
    private final LiveData <HiddenDisability> hiddenDisabilityForDisability;
    HiddenDisabilityRepository hiddenDisabilityRepository;
    LiveData<Boolean> isDisabled;
    public LiveData<Disability> disability;
    String disabilityId;

    public DisabilityDetailViewModel(DisabilityRepository disabilityRepository,
                                HiddenDisabilityRepository hiddenDisabilityRepository, String disabilityId){
        this.disabilityId = disabilityId;
        this.disability = disabilityRepository.getDisability ( disabilityId );
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
        hiddenDisabilityForDisability = hiddenDisabilityRepository.getHiddenDisabilityForDisability (disabilityId);
    }

    public void addDisabilityToHiddenDisability() {
        hiddenDisabilityRepository.createHiddenDisability (disabilityId);
    }

    public LiveData<Disability> getDisability(){
        return disability;
    }

//    @Override
//    protected void onCleared() {
//        super.onCleared();
//        viewModelScope.cancel();
//    }
}