package com.tenacity.invisibledisabilities.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity(
        tableName = "hidden_disabilities",
        foreignKeys = {@ForeignKey(entity = Disability.class, parentColumns = {"id"}, childColumns = {"disability_id"})},
        indices = {@Index("disability_id")}
)

public  class HiddenDisability {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long hiddenDisabilityId = 0;

    @ColumnInfo(name = "disability_id")
    public String disabilityId;


    @ColumnInfo(name = "disability_date")
    public Calendar disabilityDate = Calendar.getInstance();
    /**
     * Indicates when the [Disability] was created. Used for showing notification when
     * viewing the condition.
     */


    public HiddenDisability(String disabilityId) {
        this.disabilityId = disabilityId;


    }


    }

