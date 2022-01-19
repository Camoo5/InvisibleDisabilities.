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

@Entity(
        tableName = "hidden_disabilities",
        foreignKeys = {@ForeignKey(entity = Disability.class, parentColumns = {"id"}, childColumns = {"disability_id"})},
        indices = {@Index("disability_id")}
)

public final class HiddenDisability {
    @ColumnInfo(name = "disability_id") private final String disabilityId;


    @ColumnInfo(name = "disability_date") private final Calendar disabilityDate;
    /**
     * Indicates when the [Disability] was created. Used for showing notification when
     * viewing the condition.
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long hiddenDisabilityId = 0L;

    public HiddenDisability(String disabilityId, Calendar disabilityDate) {
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
        this.hiddenDisabilityId = hiddenDisabilityId;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("HiddenDisability(disabilityId=%s, disabilityDate=%s)",
                disabilityId, disabilityDate.toString());
    }

    /**
     * As [Plant.kt] is declared as [Data class], {@link Object#equals(Object)} implicit implemented.
     * So we explicit implemented {@link Object#equals(Object)} in [Plant.java]
     * see: https://kotlinlang.org/docs/reference/data-classes.html
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
       HiddenDisability target = (HiddenDisability) obj;

        return this.disabilityId.equals(target.disabilityId)
                && this.disabilityDate.equals(this.disabilityDate);
    }

    /**
     * As [Plant.kt] is declared as [Data class], {@link Object#hashCode()} implicit implemented.
     * So we explicit implemented {@link Object#hashCode()} in [Plant.java]
     * see: https://kotlinlang.org/docs/reference/data-classes.html
     */
    @Override
    public int hashCode() {
        return Objects.hash(hiddenDisabilityId);
    }

    /**
     * As [Plant.kt] is declared as [Data class], {copy()} implicit implemented.
     * So we explicit implemented {@link Object#clone()} in [Plant.java]
     * see: https://kotlinlang.org/docs/reference/data-classes.html
     */
    @Override
    protected Object clone() {
        return new HiddenDisability(disabilityId, disabilityDate);
    }
}
