package com.example.iscg7424_mobileapplication.db;

import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Deals implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String location;
    String category;
    String date;
    String price;
    String desciption;


    public Deals(String name, String location, String category, String date, String price, String desciption) {
        this.name = name;
        this.location = location;
        this.category = category;
        this.date = date;
        this.price = price;
        this.desciption = desciption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public String toString() {
        return "Deals{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", price='" + price + '\'' +
                ", desciption='" + desciption + '\'' +
                '}';
    }
}
