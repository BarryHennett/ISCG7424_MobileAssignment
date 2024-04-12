package com.example.iscg7424_mobileapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
@Dao
public interface DealsDAO {

    @Insert
    public void addDeals(Deals deals);
    @Update
    public void updateDeals(Deals deals);
    @Delete
    public void deleteDeals(Deals deals);
    @Query("select * from deals")
    public List<Deals> getAllDeals();
    @Query("select * from deals where deals_id==:deals_id")
    public Deals getDeals(int deals_id);
    @Query("select * from Deals")
    public List<Deals>getDeals();
}
