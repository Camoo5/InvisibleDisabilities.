
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

    @NonNull
    private final String name;

    @NonNull
    private final String description;

    @NonNull final String imageUrl;


    public SubConsiderations(@NonNull String subconsiderationsId, @NonNull String name, @NonNull String description, @NonNull String imageUrl) {
        this.subconsiderationsId = subconsiderationsId;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    @NonNull
    public String getSubconsiderationsId() {
        return subconsiderationsId;
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
        return obj instanceof SubConsiderations
                && this.subconsiderationsId.equals ( ( (SubConsiderations) obj ).subconsiderationsId );
    }


    @Override
    public int hashCode() {
        return Objects.hash(subconsiderationsId);
    }


    @Override
    protected Object clone() {
        return new SubConsiderations (subconsiderationsId, name, description, imageUrl);
    }
}