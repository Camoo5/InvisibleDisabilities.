package com.tenacity.invisibledisabilities.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;


public class DisabilityAndHiddenDisabilities {

    @Embedded
    com.tenacity.invisibledisabilities.data.Disability disability;

    @Relation(parentColumn = "id", entityColumn = "disability_id")
  List<HiddenDisability> hiddenDisabilities = new ArrayList <> ();

    public com.tenacity.invisibledisabilities.data.Disability getDisability () {
    return disability;
    }

    public List<HiddenDisability> getHiddenDisabilities(){
        return  hiddenDisabilities;
    }
}