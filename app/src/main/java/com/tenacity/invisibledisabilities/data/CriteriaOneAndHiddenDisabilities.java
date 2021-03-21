package com.tenacity.invisibledisabilities.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;


public class CriteriaOneAndHiddenDisabilities {

    @Embedded
    private CriteriaOne criteriaOne;

    @Relation(parentColumn = "id", entityColumn = "criteriaone_id")
    private List<HiddenDisability> hiddenDisabilities;

    public  CriteriaOneAndHiddenDisabilities(CriteriaOneAndHiddenDisabilities hiddenDisabilities) {
        this.hiddenDisabilities = new ArrayList<>();
    }



    public CriteriaOne getCriteriaOne() {
        return criteriaOne;
    }

    public void setCriteriaOne(CriteriaOne criteriaOne) {
        this.criteriaOne= criteriaOne;
    }

    public List<HiddenDisability> getHiddenDisabilities() {
        return hiddenDisabilities;
    }

    public void setHiddenDisabilities(List<HiddenDisability> hiddenDisabilities) {
        this.hiddenDisabilities = hiddenDisabilities;
    }
}
