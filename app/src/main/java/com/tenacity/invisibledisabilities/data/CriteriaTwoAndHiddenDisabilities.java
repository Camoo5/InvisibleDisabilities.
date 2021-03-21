package com.tenacity.invisibledisabilities.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;


public class CriteriaTwoAndHiddenDisabilities {

    @Embedded
    private CriteriaTwo criteriaTwo;

    @Relation(parentColumn = "id", entityColumn = "criteriatwo_id")
    private List<HiddenDisability> hiddenDisabilities;

    public  CriteriaTwoAndHiddenDisabilities(CriteriaTwoAndHiddenDisabilities hiddenDisabilities) {
        this.hiddenDisabilities = new ArrayList<>();
    }



    public CriteriaTwo getCriteriaTwo() {
        return criteriaTwo;
    }

    public void setCriteriaTwo(CriteriaTwo criteriaTwo) {
        this.criteriaTwo= criteriaTwo;
    }

    public List<HiddenDisability> getHiddenDisabilities() {
        return hiddenDisabilities;
    }

    public void setHiddenDisabilities(List<HiddenDisability> hiddenDisabilities) {
        this.hiddenDisabilities = hiddenDisabilities;
    }
}
