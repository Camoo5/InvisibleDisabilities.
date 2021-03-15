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

    @NonNull
    private final String name;

    @NonNull
    private final String description;


    public CopingStrategy(@NonNull String copingstrategyId, @NonNull String name, @NonNull String description) {
        this.copingstrategyId = copingstrategyId;
        this.name = name;
        this.description = description;

    }


    @NonNull
    public String getCopingstrategyId() {
        return copingstrategyId;
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
        return obj instanceof CopingStrategy
                && this.copingstrategyId.equals ( ( (CopingStrategy) obj ).copingstrategyId );
    }


    @Override
    public int hashCode() {
        return Objects.hash(copingstrategyId);
    }


    @Override
    protected Object clone() {
        return new CopingStrategy (copingstrategyId, name, description);
    }
}