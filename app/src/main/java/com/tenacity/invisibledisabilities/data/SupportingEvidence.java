
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

    @NonNull
    private final String name;

    @NonNull
    private final String description;

    @NonNull
    private final String imageUrl;


    public SupportingEvidence (@NonNull String supportingevidenceId, @NonNull String name, @NonNull String description, @NonNull String imageUrl) {
        this.supportingevidenceId = supportingevidenceId;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    @NonNull
    public String getSupportingevidenceId() {
        return supportingevidenceId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }


    @NonNull
    @Override
    public String toString() {
        return name;
    }

    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof SupportingEvidence
                && this.supportingevidenceId.equals ( ( (SupportingEvidence) obj ).supportingevidenceId );
    }


    @Override
    public int hashCode() {
        return Objects.hash(supportingevidenceId);
    }


    @Override
    protected Object clone() {
        return new SupportingEvidence (supportingevidenceId, name, description, imageUrl);
    }
}