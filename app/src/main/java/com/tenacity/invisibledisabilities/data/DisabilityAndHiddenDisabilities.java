package com.tenacity.invisibledisabilities.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;


public class DisabilityAndHiddenDisabilities {

    @Embedded
  Disability disability;

    @Relation(parentColumn = "id", entityColumn = "disability_id")
  List<HiddenDisability> hiddenDisabilities = new ArrayList <> ();

    public Disability getDisability () {
    return disability;
    }

    public List<HiddenDisability> getHiddenDisabilities(){
        return  hiddenDisabilities;
    }
}