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


     RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browse_deals);

        String[] activityName = {"Test"};
        String[] activityLocation = {"Test"};
        String[] activityCategory = {"Test"};
        String[] activityDate = {"Test"};
        String[] activityPricing = {"Test"};
        String[] activityDescription = {"Test"};
        int[] images = {R.drawable.ic_launcher_foreground};

        recyclerView = findViewById(R.id.r_view);
        RVAdapter adapter = new RVAdapter(this, activityName, activityLocation,
                activityCategory, activityDate, activityPricing, activityDescription, images);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

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