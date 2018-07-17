package com.example.abdulrahman.mytsakapi.base.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdulrahman on 7/12/2018.
 */

public class Category implements Parcelable {

    public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    @SerializedName("TitleAR")
    private String titleAR;
    @SerializedName("HaveModel")
    private String haveModel;
    @SerializedName("TitleEN")
    private String titleEN;
    @SerializedName("Id")
    private String id;
    @SerializedName("SubCategories")
    private List<Category> subCategories;
    @SerializedName("Photo")
    private String photo;
    @SerializedName("ProductCount")
    private String productCount;


    public Category() {
    }

    protected Category(Parcel in) {
        this.titleAR = in.readString();
        this.haveModel = in.readString();
        this.titleEN = in.readString();
        this.id = in.readString();
        this.subCategories = new ArrayList<Category>();
        in.readList(this.subCategories, Category.class.getClassLoader());
        this.photo = in.readString();
        this.productCount = in.readString();
    }

    public String getTitleAR() {
        return titleAR;
    }

    public void setTitleAR(String TitleAR) {
        this.titleAR = TitleAR;
    }

    public String getHaveModel() {
        return haveModel;
    }

    public void setHaveModel(String HaveModel) {
        this.haveModel = HaveModel;
    }

    public String getTitleEN() {
        return titleEN;
    }

    public void setTitleEN(String TitleEN) {
        this.titleEN = TitleEN;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> SubCategories) {
        this.subCategories = SubCategories;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String Photo) {
        this.photo = Photo;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String ProductCount) {
        this.productCount = ProductCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titleAR);
        dest.writeString(this.haveModel);
        dest.writeString(this.titleEN);
        dest.writeString(this.id);
        dest.writeList(this.subCategories);
        dest.writeString(this.photo);
        dest.writeString(this.productCount);
    }
}
