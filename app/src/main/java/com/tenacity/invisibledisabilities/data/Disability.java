package com.tenacity.invisibledisabilities.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


@Entity(tableName = "disabilities")
public final class Disability {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final String disabilityId;

    @NonNull
    private final String name;

    @NonNull
    private final String description;

    private final int criteriaTypeNumber;



    @NonNull
    private final String imageUrl;

    public Disability(@NonNull String disabilityId, @NonNull String name, @NonNull String description,
                 int criteriaTypeNumber,  @NonNull String imageUrl) {
        this.disabilityId = disabilityId;
        this.name = name;
        this.description = description;
        this.criteriaTypeNumber = criteriaTypeNumber;
        this.imageUrl = imageUrl;
    }



    @NonNull
    public String getDisabilityId() {
        return disabilityId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public int getCriteriaTypeNumber() {
        return criteriaTypeNumber;
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

    /**
     * As [Disability.kt] is declared as [Data class], {@link Object#equals(Object)} implicit implemented.
     * So we explicit implemented {@link Object#equals(Object)} in [Plant.java]
     * see: https://kotlinlang.org/docs/reference/data-classes.html
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof Disability
                && this.disabilityId.equals(((Disability) obj).disabilityId);
    }

    /**
     * As [Plant.kt] is declared as [Data class], {@link Object#hashCode()} implicit implemented.
     * So we explicit implemented {@link Object#hashCode()} in [Disability.java]
     * see: https://kotlinlang.org/docs/reference/data-classes.html
     */
    @Override
    public int hashCode() {
        return Objects.hash(disabilityId);
    }

    /**
     * As [Disability.kt] is declared as [Data class], {copy()} implicit implemented.
     * So we explicit implemented {@link Object#clone()} in [Plant.java]
     * see: https://kotlinlang.org/docs/reference/data-classes.html
     */
    @NotNull
    @Contract(value = " -> new", pure = true)
    @Override
    protected Object clone() {
        return new Disability(disabilityId, name, description, criteriaTypeNumber, imageUrl);
    }
}