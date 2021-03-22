
package com.tenacity.invisibledisabilities.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity(tableName = "practitioner")
public final class Practitioner {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final String practitionerId;

    @NonNull
    private final String name;

    @NonNull
    private final String description;

    @NonNull
    private final String imageUrl;

    public Practitioner(@NonNull String practitionerId, @NonNull String name, @NonNull String description, @NonNull String imageUrl) {
        this.practitionerId = practitionerId;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    @NonNull
    public String getPractitionerId() {
        return practitionerId;
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
        return obj instanceof Practitioner
                && this.practitionerId.equals ( ( (Practitioner) obj ).practitionerId );
    }


    @Override
    public int hashCode() {
        return Objects.hash(practitionerId);
    }


    @Override
    protected Object clone() {
        return new Practitioner (practitionerId, name, description,imageUrl);
    }
}