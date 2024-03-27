package com.example.iscg7424_mobileapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BrowseDeals extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browse_deals);

        String[] data = {"Test"};
        int[] images = {R.drawable.ic_launcher_foreground};

        recyclerView = findViewById(R.id.r_view);
        RVAdapter adapter = new RVAdapter(this, data, images);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}