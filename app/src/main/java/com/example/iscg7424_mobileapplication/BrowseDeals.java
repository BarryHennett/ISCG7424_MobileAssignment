package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import java.util.List;



public class BrowseDeals extends AppCompatActivity {


    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;

     RVAdapter rvAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browse_deals);


        recyclerView = findViewById(R.id.r_view);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(rvAdapter);

    }


    public void goprf(View view) {
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }

    public void gohomepge(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void godldtls(View view) {
        Intent intent = new Intent(this, DealDetails.class);
        startActivity(intent);
    }
}