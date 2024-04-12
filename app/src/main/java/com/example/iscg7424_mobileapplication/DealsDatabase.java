package com.example.iscg7424_mobileapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Deals.class}, version = 1)
public abstract class DealsDatabase extends RoomDatabase {

    public abstract DealsDAO getDealsDAO();
}