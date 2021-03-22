package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.data.Practitioner;
import com.tenacity.invisibledisabilities.data.PractitionerRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

import java.util.Objects;

/**
 * The ViewModel used in [PractitionerFragment].
 */
public class PractitionerViewModel extends ViewModel {
    private final PractitionerRepository practitionerRepository;

    private final String practitionerId;

    private final LiveData<Boolean> isDisabled;
    public LiveData<Practitioner> practitioner;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public PractitionerViewModel(PractitionerRepository practitionerRepository, HiddenDisabilityRepository hiddenDisabilityRepository, String practitionerId) {
        super();


        this. practitionerRepository = practitionerRepository;
        this.practitionerId = practitionerId;

        /* The getPractitioner method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData<Practitioner> practitioner= practitionerRepository.getPractitioner (practitionerId);
        this.isDisabled = Transformations.map(practitioner, Objects::nonNull );
        this.practitioner = practitionerRepository.getPractitioner (practitionerId);
    }
    public void addPractitionerToHiddenDisability() {
        AppExecutors.getInstance().diskIO().execute(() -> practitionerRepository.getPractitioner (practitionerId));
    }

    public LiveData<Boolean> getIsDisabled() {
        return isDisabled;
    }
}

