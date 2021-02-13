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

    public CriteriaTwo(@NonNull String criteriatwoId) {
        this.criteriatwoId = criteriatwoId;

    }

    @NonNull
    public String getCriteriatwoId () {
        return criteriatwoId;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof CriteriaTwo
                && this.criteriatwoId.equals(((CriteriaTwo) obj).criteriatwoId);
    }


    @Override
    public int hashCode() {
        return Objects.hash(criteriatwoId);
    }


    @Override
    protected Object clone() {
        return new CriteriaTwo (criteriatwoId);
    }
}