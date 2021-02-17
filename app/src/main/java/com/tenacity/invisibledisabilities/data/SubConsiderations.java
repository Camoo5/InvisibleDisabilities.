
package com.tenacity.invisibledisabilities.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity(tableName = "subconsiderations")
public final class SubConsiderations {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final String subconsiderationsId;

    public SubConsiderations(@NonNull String subconsiderationsId) {
        this.subconsiderationsId= subconsiderationsId;

    }

    @NonNull
    public String getSubConsiderationsId () {
        return subconsiderationsId;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof SubConsiderations
                && this.subconsiderationsId.equals(((SubConsiderations) obj).subconsiderationsId);
    }


    @Override
    public int hashCode() {
        return Objects.hash(subconsiderationsId);
    }


    @Override
    protected Object clone() {
        return new SubConsiderations (subconsiderationsId);
    }
}