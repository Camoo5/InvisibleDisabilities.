package com.tenacity.invisibledisabilities.data;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;


@Entity(tableName = "disabilities")
public  class Disability {


    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private  String disabilityId;
    private  String name;
    private String description;
    private  String subconsiderations;
    private  String practitioners;
    private String supportingevidence;
    private String copingstrategy;
    private  int criteriaType;
    private  String imageUrl  ="";


    public String getDisabilityId() {
        return disabilityId;
    }

    @BindingAdapter("imageFromUrl")
    public static void imageFromUrl(ImageView view, String imageUrl) {
        if (imageUrl !=  null && !imageUrl.isEmpty())
            Glide.with(view.getContext()).load(imageUrl).into(view);
    }
    public String getName() {
        return name;
    }

    public void setDisabilityId(String disabilityId) {

        this.disabilityId = disabilityId;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {

        this.name = name;
    }
    public String getSubconsiderations() {
        return subconsiderations;
    }

    public void setDescription(String description) {
   this.description = description;

        }


    public String getPractitioners() {
        return practitioners;
    }

    public void setSubconsiderations(String subconsiderations){

        this.subconsiderations = subconsiderations;
    }

    public String getSupportingevidence() {
        return supportingevidence;
    }

    public void setPractitioners(String practitioners){

        this.practitioners = practitioners;
    }

    public String getCopingstrategy() {
        return copingstrategy;
    }

    public void setSupportingevidence(String supportingevidence){

        this.supportingevidence = supportingevidence;
    }

    public int getCriteriaType() {
        return criteriaType;
    }

    public void setCopingstrategy(String copingstrategy){

        this.copingstrategy = copingstrategy;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setCriteriaType(int  criteriaType){

        this.criteriaType = criteriaType;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
}