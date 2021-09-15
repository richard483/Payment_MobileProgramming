package com.example.bootcampsatu;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    private String foodImage;
    private String foodName;
    private String foodAddress, sizes, sauces;
    private float foodPrice;

    public Food(String foodImage, String foodName, String foodAddress, float foodPrice, String sauces, String sizes) {
        this.foodImage = foodImage;
        this.foodName = foodName;
        this.foodAddress = foodAddress;
        this.foodPrice = foodPrice;
        this.sauces = sauces;
        this.sizes = sizes;
    }

    protected Food(Parcel in) {
        foodImage = in.readString();
        foodName = in.readString();
        foodAddress = in.readString();
        sizes = in.readString();
        sauces = in.readString();
        foodPrice = in.readFloat();
    }

    public Food(){}

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public String getFoodImage() {
        return foodImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodAddress() {
        return foodAddress;
    }

    public float getFoodPrice() {
        return foodPrice;
    }

    public String getSauces() {
        return sauces;
    }

    public String getSizes() {
        return sizes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(foodImage);
        parcel.writeString(foodName);
        parcel.writeString(foodAddress);
        parcel.writeString(sizes);
        parcel.writeString(sauces);
        parcel.writeFloat(foodPrice);
    }
}
