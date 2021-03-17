package com.tenacity.invisibledisabilities.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity(tableName = "extensiontobluebadge")
public final class ExtensionToBlueBadge {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final String extensiontobluebadgeId;

    @NonNull
    private final String name;

    @NonNull
    private final String description;


    public ExtensionToBlueBadge(@NonNull String extensiontobluebadgeId, @NonNull String name, @NonNull String description) {
        this.extensiontobluebadgeId = extensiontobluebadgeId;
        this.name = name;
        this.description = description;

    }


    @NonNull
    public String getExtensiontobluebadgeId() {
        return extensiontobluebadgeId;
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
        return obj instanceof CriteriaOne
                && this.extensiontobluebadgeId.equals ( ( (ExtensionToBlueBadge) obj ).extensiontobluebadgeId );
    }


    @Override
    public int hashCode() {
        return Objects.hash(extensiontobluebadgeId);
    }


    @Override
    protected Object clone() {
        return new ExtensionToBlueBadge (extensiontobluebadgeId, name, description);
    }
}