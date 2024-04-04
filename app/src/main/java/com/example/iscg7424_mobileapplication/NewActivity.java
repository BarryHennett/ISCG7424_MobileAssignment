package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;
public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);

        AutoCompleteTextView categoryAutoCompleteTextView = findViewById(R.id.CtgDrpDwnAN);

        String[] categories = {"Category 1", "Category 2", "Category 3", "Category 4"};

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, categories);

        categoryAutoCompleteTextView.setAdapter(categoryAdapter);

        AutoCompleteTextView locationAutoCompleteTextView = findViewById(R.id.LCTDrpDwnAN);

        String[] locations = {"Location 1", "Location 2", "Location 3", "Location 4"};

        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, locations);

        locationAutoCompleteTextView.setAdapter(locationAdapter);
    }

    public void gohomepge(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}
