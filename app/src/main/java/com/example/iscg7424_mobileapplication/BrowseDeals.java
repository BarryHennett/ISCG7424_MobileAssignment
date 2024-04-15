package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;



public class BrowseDeals extends AppCompatActivity {
     RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browse_deals);

        String [] name = {"Extreme Rafts","Rock Climbing","SnowBoarding"};
        String [] location = {"Auckland, NZ","Wellington, NZ","Queenstown, NZ"};
        String [] category = {"Water","Adventure","Snow"};
        String [] pricing = {"$139.99","$199.99","$299.99"};
        int [] images = {R.drawable.rafting2, R.drawable.rockclimbing2, R.drawable.snowboarding2};

        recyclerView = findViewById(R.id.r_view);
        RVAdapter adapter = new RVAdapter(this, name, location, category, pricing,images);
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