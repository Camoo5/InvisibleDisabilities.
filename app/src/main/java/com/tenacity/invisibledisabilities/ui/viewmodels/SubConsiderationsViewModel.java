package com.tenacity.invisibledisabilities.ui.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.SubConsiderations;
import com.tenacity.invisibledisabilities.data.SubConsiderationsRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

/**
 * The ViewModel used in [SubConsiderations Fragment].
 */
public class SubConsiderationsViewModel extends ViewModel {
    private final SubConsiderationsRepository subConsiderationsRepository;

    private final String subconsiderationsId;

    private final LiveData<Boolean> isDisabled;
    public LiveData<SubConsiderations> subConsiderationsLiveData;

    public SubConsiderationsViewModel(SubConsiderationsRepository subConsiderationsRepository, String subconsiderationsId) {
        super();
        this.subConsiderationsRepository = subConsiderationsRepository;
        this.subconsiderationsId= subconsiderationsId;

        /* The getSubConsiderations method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData<SubConsiderations> subConsiderationsLiveData= subConsiderationsRepository.getSubConsiderations (subconsiderationsId);
        this.isDisabled = Transformations.map(subConsiderationsLiveData, it -> it != null);
        this.subConsiderationsLiveData = subConsiderationsRepository.getSubConsiderations (subconsiderationsId);
    }
    public void addDisabilityToHiddenDisabilities() {
        AppExecutors.getInstance().diskIO().execute(() -> subConsiderationsRepository.getSubConsiderations (subconsiderationsId));
    }

    public LiveData<Boolean> getIsDisabled() {
        return isDisabled;
    }
}

