package com.tenacity.invisibledisabilities.data;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;


@Entity(tableName = "disabilities")
public final class Disability {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private String disabilityId;
    private String name;
    private String description;
    private String criteria;
    private String practitioners;
    private String copingstrategy;
    private String imageUrl = "";

    public String getDisabilityId() {
        return disabilityId;
    }


    @BindingAdapter("imageFromUrl")
    public static void imageFromUrl(ImageView view, String imageUrl) {
        if (imageUrl != null && !imageUrl.isEmpty())
            Glide.with(view.getContext()).load(imageUrl).into(view);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDisabilityId(String disabilityId) {
        this.disabilityId = disabilityId;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getCopingstrategy() {
        return copingstrategy;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }


    public void setCopingstrategy(String copingstrategy) {
        this.copingstrategy = copingstrategy;
    }

    public String getPractitioners() {
        return practitioners;
    }


    public void setPractitioners(String practitioners) {
        this.practitioners = practitioners;
    }



    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}