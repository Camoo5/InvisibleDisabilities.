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

    public ExtensionToBlueBadge(@NonNull String extensiontobluebadgeId) {
        this.extensiontobluebadgeId = extensiontobluebadgeId;

    }

    @NonNull
    public String getExtensiontobluebadgeId() {
        return extensiontobluebadgeId;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof ExtensionToBlueBadge
                && this.extensiontobluebadgeId.equals(((ExtensionToBlueBadge) obj).extensiontobluebadgeId);
    }


    @Override
    public int hashCode() {
        return Objects.hash(extensiontobluebadgeId);
    }


    @Override
    protected Object clone() {
        return new ExtensionToBlueBadge (extensiontobluebadgeId);
    }
}