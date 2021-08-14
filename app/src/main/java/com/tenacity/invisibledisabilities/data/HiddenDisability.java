 package com.tenacity.invisibledisabilities.data;

 import androidx.room.ColumnInfo;
 import androidx.room.Entity;
 import androidx.room.ForeignKey;
 import androidx.room.Index;
 import androidx.room.PrimaryKey;

 import java.util.Calendar;

 /**
 * [HiddenDisability] represents when a user adds a [Disability] to their condition, with useful metadata.

 * Declaring the column info allows for the renaming of variables without implementing a
 * database migration, as the column name would not change.
 */
@Entity(tableName = "hidden_disabilities",
        foreignKeys = {@ForeignKey(entity = com.tenacity.invisibledisabilities.data.Disability.class, parentColumns = {"id"}, childColumns = {"disability_id"})},
        indices = {@Index("disability_id")})

public class HiddenDisability {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long hiddendisabilityId = 0;

    @ColumnInfo(name = "disability_id")
    public String disabilityId;

    @ColumnInfo(name = "disability_date")
    public Calendar disabilityDate = Calendar.getInstance();



    public HiddenDisability(String disabilityId) {
        this.disabilityId = disabilityId;
    }
}
