package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UserProfile extends AppCompatActivity {

    RecyclerView recyclerView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_profile);

        String [] name = {"Extreme Rafts","Rock Climbing","SnowBoarding"};
        String [] location = {"Auckland, NZ","Wellington, NZ","Queenstown, NZ"};
        String [] category = {"Water","Adventure","Snow"};
        String [] pricing = {"$139.99","$199.99","$299.99"};
        int [] images = {R.drawable.rafting2, R.drawable.rockclimbing2, R.drawable.snowboarding2};

        recyclerView3 = findViewById(R.id.r_userprofile_view);
        RVAdapter3 adapter = new RVAdapter3(this, name, location, category, pricing,images);
        recyclerView3.setLayoutManager( new LinearLayoutManager(this));
        recyclerView3.setAdapter(adapter);
    }

    public void gohomepge(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}