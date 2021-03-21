package com.tenacity.invisibledisabilities.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;


public class SupportingEvidenceAndHiddenDisabilities {

    @Embedded
    private SupportingEvidence supportingEvidence;

    @Relation(parentColumn = "id", entityColumn = "supportingevidence_id")
    private List<HiddenDisability> hiddenDisabilities;

    public  SupportingEvidenceAndHiddenDisabilities(SupportingEvidenceAndHiddenDisabilities hiddenDisabilities) {
        this.hiddenDisabilities = new ArrayList<>();
    }



    public SupportingEvidence getSupportingEvidence() {
        return supportingEvidence;
    }

    public void setSupportingEvidence(SupportingEvidence supportingEvidence) {
        this.supportingEvidence= supportingEvidence;
    }

    public List<HiddenDisability> getHiddenDisabilities() {
        return hiddenDisabilities;
    }

    public void setHiddenDisabilities(List<HiddenDisability> hiddenDisabilities) {
        this.hiddenDisabilities = hiddenDisabilities;
    }
}