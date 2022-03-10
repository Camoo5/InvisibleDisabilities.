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
    private final LiveData<HiddenDisability> hiddenDisabilityForDisability;
    HiddenDisabilityRepository hiddenDisabilityRepository;
    String disabilityId;
    public LiveData<Disability> disability;
    private LiveData<Boolean> isDisabled;

    public DisabilityDetailViewModel(DisabilityRepository disabilityRepository, HiddenDisabilityRepository hiddenDisabilityRepository, String disabilityId) {
        this.disabilityId = disabilityId;
        this.disability = disabilityRepository.getDisability(disabilityId);
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
        hiddenDisabilityForDisability = hiddenDisabilityRepository.getHiddenDisabilityForDisability(disabilityId);
    }

        /* The getHiddenDisabilityForDisability method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */

    public void addDisabilityToHiddenDisability() {
        hiddenDisabilityRepository.createHiddenDisability(disabilityId);
    }

    public LiveData<Disability> getDisability() {
        return disability;
    }
}

