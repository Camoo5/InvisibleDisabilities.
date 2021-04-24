package com.tenacity.invisibledisabilities.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


@Entity(tableName = "criterias")
public final class Criterias {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final String criteriasId;

    @NonNull
    private final String name;

    @NonNull
    private final String description;

    @NonNull
    private final String imageUrl;


    public Criterias(@NonNull String criteriasId, @NonNull String name, @NonNull String description, @NonNull String imageUrl) {
        this.criteriasId = criteriasId;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    @NonNull
    public String getCriteriasId() {
        return criteriasId;
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
        return obj instanceof Criterias
                && this.criteriasId.equals ( ( (Criterias) obj ).criteriasId );
    }


    @Override
    public int hashCode() {
        return Objects.hash(criteriasId);
    }


    @NotNull
    @Contract(value = " -> new", pure = true)
    @Override
    protected Object clone() {
        return new Criterias (criteriasId, name, description, imageUrl);
    }
}