package com.tenacity.invisibledisabilities.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity(tableName = "copingStrategies")
public final class CopingStrategy {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final String copingstrategyId;

    public CopingStrategy(@NonNull String copingstrategyId) {
        this.copingstrategyId = copingstrategyId;

    }

    @NonNull
    public String getCopingstrategyId() {
        return copingstrategyId;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof CopingStrategy
                && this.copingstrategyId.equals(((CopingStrategy) obj).copingstrategyId);
    }


    @Override
    public int hashCode() {
        return Objects.hash(copingstrategyId);
    }


    @Override
    protected Object clone() {
        return new CopingStrategy (copingstrategyId);
    }
}