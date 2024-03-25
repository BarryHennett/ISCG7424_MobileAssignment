package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);
        setupAutoCompleteTextView();

    }

    public void GoCusLogin(View view) {
        Intent intent = new Intent(this, CustomerLogin.class);
        startActivity(intent);
    }


    public void GoAklCtg(View view) {
    }

    public void GoWelCtg(View view) {
    }

    public void GoQueCtg(View view) {
    }


    public void setupAutoCompleteTextView() {
        // Get reference to AutoCompleteTextView
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.CtgDrpDwnHP);

        // Define data source
        String[] categories = {"Category 1", "Category 2", "Category 3", "Category 4", "Category 5"};

        // Create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, categories);

        // Set adapter to AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter);
    }

    public void goamzdls(View view) {

    }
}



