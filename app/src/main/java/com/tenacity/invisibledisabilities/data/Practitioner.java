
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

    public Practitioner(@NonNull String practitionersId) {
        this.practitionersId = practitionersId;

    }

    @NonNull
    public String getPractitionersId () {
        return practitionersId;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof Practitioner
                && this.practitionersId.equals(((Practitioner) obj).practitionersId);
    }


    @Override
    public int hashCode() {
        return Objects.hash(practitionersId);
    }


    @Override
    protected Object clone() {
        return new Practitioner (practitionersId);
    }
}