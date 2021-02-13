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

    public CriteriaOne(@NonNull String criteriaoneId) {
        this.criteriaoneId = criteriaoneId;

    }

    @NonNull
    public String getCriteriaoneId() {
        return criteriaoneId;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof CriteriaOne
                && this.criteriaoneId.equals(((CriteriaOne) obj).criteriaoneId);
    }


    @Override
    public int hashCode() {
        return Objects.hash(criteriaoneId);
    }


    @Override
    protected Object clone() {
        return new CriteriaOne (criteriaoneId);
    }
}