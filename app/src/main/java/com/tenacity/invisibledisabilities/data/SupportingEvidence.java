
package com.tenacity.invisibledisabilities.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity(tableName = "supportingevidence")
public final class SupportingEvidence {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final String supportingevidenceId;

    public SupportingEvidence(@NonNull String  supportingevidenceId) {
        this. supportingevidenceId=  supportingevidenceId;

    }

    @NonNull
    public String getSupportingEvidenceId () {
        return supportingevidenceId;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof SupportingEvidence
                && this.supportingevidenceId.equals(((SupportingEvidence) obj).supportingevidenceId);
    }


    @Override
    public int hashCode() {
        return Objects.hash(supportingevidenceId);
    }


    @Override
    protected Object clone() {
        return new SupportingEvidence (supportingevidenceId);
    }
}