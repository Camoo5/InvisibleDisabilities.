package com.tenacity.invisibledisabilities.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity(tableName = "criteriaTwo")
public final class CriteriaTwo {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final String criteriatwoId;

    @NonNull
    private final String name;

    @NonNull
    private final String description;

    @NonNull
    private final String imageUrl;


    public  CriteriaTwo(@NonNull String criteriatwoId, @NonNull String name, @NonNull String description, @NonNull String imageUrl) {
        this.criteriatwoId = criteriatwoId;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    @NonNull
    public String getCriteriatwoId() {
        return criteriatwoId;
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
    public String getImageUrl() {
        return imageUrl;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }




    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof CriteriaTwo
                && this.criteriatwoId.equals ( ( (CriteriaTwo) obj ).criteriatwoId );
    }


    @Override
    public int hashCode() {
        return Objects.hash(criteriatwoId);
    }


    @Override
    protected Object clone() {
        return new CriteriaTwo (criteriatwoId, name, description, imageUrl);
    }
}
