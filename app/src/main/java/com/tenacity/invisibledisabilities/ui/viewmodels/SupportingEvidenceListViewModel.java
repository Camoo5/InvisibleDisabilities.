package com.tenacity.invisibledisabilities.ui.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.HiddenDisabilityRepository;
import com.tenacity.invisibledisabilities.data.SupportingEvidence;
import com.tenacity.invisibledisabilities.data.SupportingEvidenceRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

/**
 * The ViewModel used in [SupportingEvidence Fragment].
 */
public class SupportingEvidenceListViewModel extends ViewModel {
    private final SupportingEvidenceRepository supportingEvidenceRepository;

    private final String supportingevidenceId;

    private final LiveData <Boolean> isDisabled;
    public LiveData <SupportingEvidence> supportingEvidence;

    public SupportingEvidenceListViewModel(SupportingEvidenceRepository supportingEvidenceRepository, HiddenDisabilityRepository hiddenDisabilityRepository, String supportingevidenceId) {
        super ();
        this.supportingEvidenceRepository = supportingEvidenceRepository;
        this.supportingevidenceId = supportingevidenceId;

        /* The getSupportingEvidence method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData <SupportingEvidence> supportingEvidence = supportingEvidenceRepository.getSupportingEvidence ( supportingevidenceId );
        this.isDisabled = Transformations.map ( supportingEvidence, it -> it != null );
        this.supportingEvidence = supportingEvidenceRepository.getSupportingEvidence ( supportingevidenceId );
    }

    public void addSupportingEvidenceToHiddenDisability() {
        AppExecutors.getInstance ().diskIO ().execute ( () -> supportingEvidenceRepository.getSupportingEvidence ( supportingevidenceId ) );
    }

    public LiveData <Boolean> getIsDisabled() {
        return isDisabled;
    }
}


