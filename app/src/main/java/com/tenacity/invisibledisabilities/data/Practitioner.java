
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

    public Practitioner(@NonNull String practitionerId) {
        this.practitionerId = practitionerId;

    }

    @NonNull
    public String getPractitionerId () {
        return practitionerId;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof Practitioner
                && this.practitionerId.equals(((Practitioner) obj).practitionerId);
    }


    @Override
    public int hashCode() {
        return Objects.hash(practitionerId);
    }


    @Override
    protected Object clone() {
        return new Practitioner (practitionerId);
    }
}