package com.tenacity.invisibledisabilities.ui.viewmodels;


import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.tenacity.invisibledisabilities.data.ExtensionToBlueBadge;
import com.tenacity.invisibledisabilities.data.ExtensionToBlueBadgeRepository;
import com.tenacity.invisibledisabilities.utilities.AppExecutors;

import java.util.Objects;

/**
 * The ViewModel used in [ExtensionToBlueBadgeFragment].
 */
public class ExtensionToBlueBadgeViewModel extends ViewModel {
    private final ExtensionToBlueBadgeRepository extensionToBlueBadgeRepository;

    private final String extensiontobluebadgeId;

    private final LiveData<Boolean> isDisabled;
    public LiveData<ExtensionToBlueBadge> extensionToBlueBadge;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ExtensionToBlueBadgeViewModel(ExtensionToBlueBadgeRepository extensionToBlueBadgeRepository, String extensiontobluebadgeId) {
        super();


        this. extensionToBlueBadgeRepository = extensionToBlueBadgeRepository;
        this.extensiontobluebadgeId = extensiontobluebadgeId;

        /* The getExtensionToBlueBadge method returns a LiveData from querying the database. The
         * method can return null in two cases: when the database query is running and if no records
         * are found. In these cases isDisabled is false. If a record is found then isDisabled is
         * true. */
        LiveData<ExtensionToBlueBadge> extensionToBlueBadge= extensionToBlueBadgeRepository.getExtensionToBlueBadge (extensiontobluebadgeId);
        this.isDisabled = Transformations.map(extensionToBlueBadge, Objects::nonNull );
        this.extensionToBlueBadge = extensionToBlueBadgeRepository.getExtensionToBlueBadge (extensiontobluebadgeId);
    }
    public void addExtensionToBlueBadgeToHiddenDisability() {
        AppExecutors.getInstance().diskIO().execute(() -> extensionToBlueBadgeRepository.getExtensionToBlueBadge (extensiontobluebadgeId));
    }

    public LiveData<Boolean> getIsDisabled() {
        return isDisabled;
    }
}

