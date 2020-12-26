package com.tenacity.invisibledisabilities.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class viewmodels extends ViewModel {

    private MutableLiveData <String> mText;

    public viewmodels() {
        mText = new MutableLiveData <> ();
        mText.setValue ( "This is gallery fragment" );
    }

    public LiveData <String> getText() {
        return mText;
    }
}