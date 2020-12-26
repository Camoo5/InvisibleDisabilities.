package com.tenacity.invisibledisabilities.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Coping_StrategyViewModel extends ViewModel {

    private MutableLiveData <String> mText;

    public Coping_StrategyViewModel() {
        mText = new MutableLiveData <> ();
        mText.setValue ( "This is home fragment" );
    }

    public LiveData <String> getText() {
        return mText;
    }
}