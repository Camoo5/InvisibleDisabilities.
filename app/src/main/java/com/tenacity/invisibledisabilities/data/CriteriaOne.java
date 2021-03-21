package com.tenacity.invisibledisabilities.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity(tableName = "criteriaOnes")
public final class CriteriaOne {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final String criteriaoneId;

    @NonNull
    private final String name;

    @NonNull
    private final String description;

    @NonNull
    private final String imageUrl;


    public CriteriaOne(@NonNull String criteriaoneId, @NonNull String name, @NonNull String description, @NonNull String imageUrl) {
        this.criteriaoneId = criteriaoneId;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    @NonNull
    public String getCriteriaoneId() {
        return criteriaoneId;
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
                && this.criteriaoneId.equals ( ( (CriteriaOne) obj ).criteriaoneId );
    }


    @Override
    public int hashCode() {
        return Objects.hash(criteriaoneId);
    }


    @Override
    protected Object clone() {
        return new CopingStrategy (criteriaoneId, name, description, imageUrl);
    }
}