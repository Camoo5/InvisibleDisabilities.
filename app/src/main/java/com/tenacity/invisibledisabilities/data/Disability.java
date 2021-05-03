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

    @NonNull
    private final String subconsiderations;

    @NonNull
    private final String criteria;

    @NonNull
    private final String practitioners;

    @NonNull
    private final String supportingevidence;

    @NonNull
    private final String copingstrategy;

    private final int criteriaTypeNumber;



    @NonNull
    private final String imageUrl;

    public Disability(@NonNull String disabilityId, @NonNull String name, @NonNull String description, @NonNull String subconsiderations,
                      @NonNull String criteria, @NonNull String practitioners,  @NonNull String supportingevidence, @NonNull String copingstrategy,    int criteriaTypeNumber,  @NonNull String imageUrl) {

        this.disabilityId = disabilityId;
        this.name = name;
        this.description = description;
        this.subconsiderations = subconsiderations;
        this.criteria = criteria;
        this.practitioners = practitioners;
        this.supportingevidence = supportingevidence;
        this.copingstrategy = copingstrategy;
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

    @NonNull
    public String getSubconsiderations() {
        return subconsiderations;
    }

    @NonNull
    public String getCriteria() {
        return criteria;
    }

    @NonNull
    public String getPractitioners() {
        return practitioners;
    }

    @NonNull
    public String getSupportingevidence() {
        return supportingevidence;
    }

    @NonNull
    public String getCopingstrategy() {
        return copingstrategy;
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
        return new Disability(disabilityId, name, description, subconsiderations, criteria, practitioners, supportingevidence, copingstrategy, criteriaTypeNumber, imageUrl);
    }
}