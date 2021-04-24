package com.tenacity.invisibledisabilities.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;


public class CriteriasAndHiddenDisabilities {

    @Embedded
    private Criterias criteriaOne;

    @Relation(parentColumn = "id", entityColumn = "criteriaone_id")
    private List<HiddenDisability> hiddenDisabilities;

    public CriteriasAndHiddenDisabilities(CriteriasAndHiddenDisabilities hiddenDisabilities) {
        this.hiddenDisabilities = new ArrayList<>();
    }



    public Criterias getCriteriaOne() {
        return criteriaOne;
    }

    public void setCriteriaOne(Criterias criteriaOne) {
        this.criteriaOne= criteriaOne;
    }

    public List<HiddenDisability> getHiddenDisabilities() {
        return hiddenDisabilities;
    }

    public void setHiddenDisabilities(List<HiddenDisability> hiddenDisabilities) {
        this.hiddenDisabilities = hiddenDisabilities;
    }
}
