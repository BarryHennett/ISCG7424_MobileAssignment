package com.example.iscg7424_mobileapplication;

public class Activity {
    private String activityName;
    private String location;
    private String category;
    private String date;
    private String pricing;
    private String description;

    public Activity(String activityName, String location, String category, String date, String pricing, String description) {
        this.activityName = activityName;
        this.location = location;
        this.category = category;
        this.date = date;
        this.pricing = pricing;
        this.description = description;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getPricing() {
        return pricing;
    }

    public String getDescription() {
        return description;
    }
}
