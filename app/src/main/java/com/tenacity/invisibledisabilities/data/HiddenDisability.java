 package com.tenacity.invisibledisabilities.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Objects;

/**
 * [HiddenDisability] represents when a user adds a [Disability] to their condition, with useful metadata.

 * Declaring the column info allows for the renaming of variables without implementing a
 * database migration, as the column name would not change.
 */
@Entity(tableName = "hidden_disabilities",
        foreignKeys = {@ForeignKey(entity = com.tenacity.invisibledisabilities.data.Disability.class, parentColumns = {"id"}, childColumns = {"disability_id"})},
        indices = {@Index("disability_id")})
public final class HiddenDisability {
    @ColumnInfo(name = "disability_id") private final String disabilityId;

    /**
     * Indicates when the [Disability] was added.
     */
    @ColumnInfo(name = "disability_date") private final Calendar disabilityDate;


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long hiddenDisabilityId = 0L;

    public HiddenDisability(String disabilityId) {
        this.disabilityId = disabilityId;
        this.disabilityDate = disabilityDate == null ? Calendar.getInstance() : disabilityDate;

    }

    public String getDisabilityId() {
        return disabilityId;
    }

    public Calendar getDisabilityDate() {
        return disabilityDate;
    }



    public long getHiddenDisabilityId() {
        return hiddenDisabilityId;
    }

    public void setHiddenDisabilityId(long hiddenDisabilityId) {
        this.hiddenDisabilityId= hiddenDisabilityId;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("HiddenDisability(disabilityId=%s, disabilityDate=%s)",
               disabilityId, disabilityDate.toString());
    }

    /**
     * As [Disability.kt] is declared as [Data class], {@link Object#equals(Object)} implicit implemented.
     * So we explicit implemented {@link Object#equals(Object)} in [Plant.java]
     * see: https://kotlinlang.org/docs/reference/data-classes.html
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        assert obj != null;
        if (this.getClass () != obj.getClass ()) {
            return false;
        }
       HiddenDisability target = (HiddenDisability) obj;

        return this.disabilityId.equals(target.disabilityId);

    }

    /**
     * As [Disability.kt] is declared as [Data class], {@link Object#hashCode()} implicit implemented.
     * So we explicit implemented {@link Object#hashCode()} in [Plant.java]
     * see: https://kotlinlang.org/docs/reference/data-classes.html
     */
    @Override
    public int hashCode() {
        return Objects.hash(hiddenDisabilityId);
    }

    /**
     * As [Disability.kt] is declared as [Data class], {copy()} implicit implemented.
     * So we explicit implemented {@link Object#clone()} in [Plant.java]
     * see: https://kotlinlang.org/docs/reference/data-classes.html
     */
    @Override
    protected Object clone() {
        try {
            super.clone ();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace ();
        }


        return new HiddenDisability (disabilityId );
    }
}