package com.example.iscg7424_mobileapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Deals")
public class Deals {

    @ColumnInfo(name="deals_id")
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name="name")
    String name;
    @ColumnInfo(name="location")
    String location;
    @ColumnInfo(name="category")
    String category;
    @ColumnInfo(name="date")
    String date;
    @ColumnInfo(name="price")
    String price;
    @ColumnInfo(name="description")
    String desciption;


    @Ignore
    public Deals(String name) {
        this.name = name;
    }

    public Deals(String name, String location, String category, String date, String price, String desciption) {
        this.name = name;
        this.location = location;
        this.category = category;
        this.date = date;
        this.price = price;
        this.desciption = desciption;
        this.id = 0;
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
}
