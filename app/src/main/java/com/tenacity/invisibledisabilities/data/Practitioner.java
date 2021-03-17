
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
    private final String practitionersId;

    @NonNull
    private final String name;

    @NonNull
    private final String description;


    public Practitioner(@NonNull String practitionersId, @NonNull String name, @NonNull String description) {
        this.practitionersId = practitionersId;
        this.name = name;
        this.description = description;

    }


    @NonNull
    public String getPractitionersId() {
        return practitionersId;
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


    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof Practitioner
                && this.practitionersId.equals ( ( (Practitioner) obj ).practitionersId );
    }


    @Override
    public int hashCode() {
        return Objects.hash(practitionersId);
    }


    @Override
    protected Object clone() {
        return new Practitioner (practitionersId, name, description);
    }
}