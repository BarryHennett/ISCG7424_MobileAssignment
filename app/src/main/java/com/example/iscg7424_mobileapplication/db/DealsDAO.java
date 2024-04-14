package com.example.iscg7424_mobileapplication.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface DealsDAO {

    @Insert
    void insertDeal(Deals d);
    @Delete
    void deleteDeal(Deals d);
    @Query("SELECT * FROM Deals")
    List<Deals> getAllDeals();
    @Query("DELETE FROM Deals")
    void deleteAllDeals();


}
