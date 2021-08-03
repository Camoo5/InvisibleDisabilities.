package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.data.DisabilityRepository;
import com.tenacity.invisibledisabilities.data.HiddenDisability;
import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

import java.util.Objects;

/**
 * The ViewModel used in [DisabilityDetailFragment].
 */
public class DisabilityDetailViewModel extends ViewModel {
    private final HiddenDisabilityRepository hiddenDisabilityRepository;

    private final String disabilityId;

    private final LiveData<Boolean> isDisabled;
    public LiveData<Disability> disability;

    @RequiresApi(api = Build.VERSION_CODES.N)
    DisabilityDetailViewModel(DisabilityRepository disabilityRepository, HiddenDisabilityRepository hiddenDisabilityRepository, String disabilityId) {
        super();
        this.hiddenDisabilityRepository = hiddenDisabilityRepository;
        this.disabilityId= disabilityId;

        /* The getHiddenDisabilitiesForDisability method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData<HiddenDisability> getHiddenDisabilitiesForDisability = hiddenDisabilityRepository.getHiddenDisabilityForDisability ( disabilityId );
        this.isDisabled = Transformations.map(getHiddenDisabilitiesForDisability, Objects::nonNull );
        this.disability = disabilityRepository.getDisability(disabilityId);
    }

    public void addDisabilityToHiddenDisability() {
        AppExecutors.getInstance().diskIO().execute(() -> hiddenDisabilityRepository.createHiddenDisability(disabilityId));
    }

    public LiveData<Boolean> getIsDisabled() {
        return isDisabled;
    }
}