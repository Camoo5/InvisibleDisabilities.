package com.tenacity.invisibledisabilities.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;


public class DisabilityAndHiddenDisabilities {

    @Embedded
    private Disability disability;

    @Relation(parentColumn = "id", entityColumn = "disability_id")
    private List<HiddenDisability> hiddenDisabilities;

    public  DisabilityAndHiddenDisabilities() {
        this.hiddenDisabilities = new ArrayList<>();
    }



    public Disability getDisability() {
        return disability;
    }

    public void setDisability(Disability disability) {
        this.disability = disability;
    }

    public List<HiddenDisability> getHiddenDisabilities() {
        return hiddenDisabilities;
    }

    public void setHiddenDisabilities(List<HiddenDisability> hiddenDisabilities) {
        this.hiddenDisabilities = hiddenDisabilities;
    }
}