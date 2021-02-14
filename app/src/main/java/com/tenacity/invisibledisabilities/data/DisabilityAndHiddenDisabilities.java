package com.tenacity.invisibledisabilities.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;


public class DisabilityAndHiddenDisabilities {

    @Embedded
    private com.tenacity.invisibledisabilities.data.Disability disability;

    @Relation(parentColumn = "id", entityColumn = "disability_id")
    private List<com.tenacity.invisibledisabilities.data.HiddenDisability> hiddenDisabilities;

    public  DisabilityAndHiddenDisabilities() {
        this.hiddenDisabilities = new ArrayList<>();
    }

    public com.tenacity.invisibledisabilities.data.Disability getDisability() {
        return disability;
    }

    public void setDisability(com.tenacity.invisibledisabilities.data.Disability disability) {
        this.disability = disability;
    }

    public List<com.tenacity.invisibledisabilities.data.HiddenDisability> getHiddenDisabilities() {
        return hiddenDisabilities;
    }

    public void setHiddenDisabilities(List<com.tenacity.invisibledisabilities.data.HiddenDisability> hiddenDisabilities) {
        this.hiddenDisabilities = hiddenDisabilities;
    }
}