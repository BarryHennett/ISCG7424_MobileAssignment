package com.example.iscg7424_mobileapplication.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Deals.class}, version = 1, exportSchema = false)
public abstract class DealsDatabase extends RoomDatabase {

    private static DealsDatabase dealsDatabase = null;
    public abstract DealsDAO dealsDAO();

    public static DealsDatabase getInstance(Context context){
        if(dealsDatabase==null){
            dealsDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    DealsDatabase.class, "DealsDatabase").allowMainThreadQueries().build();
        }
        return dealsDatabase;
    }

}