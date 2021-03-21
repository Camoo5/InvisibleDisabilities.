package com.tenacity.invisibledisabilities.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;


public class ExtensionToBlueBadgeAndHiddenDisabilities {

    @Embedded
    private ExtensionToBlueBadge extensionToBlueBadge;

    @Relation(parentColumn = "id", entityColumn = "extensiontobluebadge_id")
    private List<HiddenDisability> hiddenDisabilities;

    public  ExtensionToBlueBadgeAndHiddenDisabilities(ExtensionToBlueBadgeAndHiddenDisabilities hiddenDisabilities) {
        this.hiddenDisabilities = new ArrayList<>();
    }



    public ExtensionToBlueBadge getExtensionToBlueBadge() {
        return extensionToBlueBadge;
    }

    public void setExtensionToBlueBadge(ExtensionToBlueBadge extensionToBlueBadge) {
        this.extensionToBlueBadge = extensionToBlueBadge;
    }

    public List<HiddenDisability> getHiddenDisabilities() {
        return hiddenDisabilities;
    }

    public void setHiddenDisabilities(List<HiddenDisability> hiddenDisabilities) {
        this.hiddenDisabilities = hiddenDisabilities;
    }
}