package com.tenacity.invisibledisabilities.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;


public class SubConsiderationsAndHiddenDisabilities {

    @Embedded
    private SubConsiderations subConsiderations;

    @Relation(parentColumn = "id", entityColumn = "subconsiderations_id")
    private List<HiddenDisability> hiddenDisabilities;

    public  SubConsiderationsAndHiddenDisabilities(SubConsiderationsAndHiddenDisabilities hiddenDisabilities) {
        this.hiddenDisabilities = new ArrayList<>();
    }



    public SubConsiderations getSubConsiderations() {
        return subConsiderations;
    }

    public void setSubConsiderations(SubConsiderations subConsiderations) {
        this.subConsiderations= subConsiderations;
    }

    public List<HiddenDisability> getHiddenDisabilities() {
        return hiddenDisabilities;
    }

    public void setHiddenDisabilities(List<HiddenDisability> hiddenDisabilities) {
        this.hiddenDisabilities = hiddenDisabilities;
    }
}