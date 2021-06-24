package com.tenacity.hiddendisabilities.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
    private final String practitioners;

    @NonNull
    private final String supportingevidence;

    @NonNull
    private final String copingstrategy;

    private final int criteriaType;

    @NonNull
    private final String imageUrl;

    public Disability(@NonNull String disabilityId, @NonNull String name, @NonNull String description, @NonNull String subconsiderations,
                      @NonNull String practitioners,  @NonNull String supportingevidence, @NonNull String copingstrategy,  int criteriaType,  @NonNull String imageUrl) {

        this.disabilityId = disabilityId;
        this.name = name;
        this.description = description;
        this.subconsiderations = subconsiderations;
        this.practitioners = practitioners;
        this.supportingevidence = supportingevidence;
        this.copingstrategy = copingstrategy;
        this.criteriaType = criteriaType;
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


    public int getCriteriaType() {
        return criteriaType;
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
    @Override
    public Object clone() {
        try {
            super.clone ();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace ();
        }
        return new Disability(disabilityId, name, description, subconsiderations,  practitioners, supportingevidence, copingstrategy, criteriaType, imageUrl);
    }
}