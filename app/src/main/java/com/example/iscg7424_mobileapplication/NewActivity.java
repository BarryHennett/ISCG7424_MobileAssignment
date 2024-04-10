package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class NewActivity extends AppCompatActivity {

    private EditText activityNameEditText;
    private AutoCompleteTextView locationAutoCompleteTextView;
    private AutoCompleteTextView categoryAutoCompleteTextView;
    private EditText activityPricingEditText;
    private EditText activityDescriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);

        // Initialize views
        activityNameEditText = findViewById(R.id.activityNameEditText);
        locationAutoCompleteTextView = findViewById(R.id.LCTDrpDwnAN);
        categoryAutoCompleteTextView = findViewById(R.id.CtgDrpDwnAN);
        activityPricingEditText = findViewById(R.id.activityPricingEditText);
        activityDescriptionEditText = findViewById(R.id.activityDescriptionEditText);

        // Populate AutoCompleteTextViews with data
        String[] categories = {"Category 1", "Category 2", "Category 3", "Category 4"};
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, categories);
        categoryAutoCompleteTextView.setAdapter(categoryAdapter);

        String[] locations = {"Location 1", "Location 2", "Location 3", "Location 4"};
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, locations);
        locationAutoCompleteTextView.setAdapter(locationAdapter);

        // Setup submit button click listener
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve information from views
                String activityName = activityNameEditText.getText().toString();
                String location = locationAutoCompleteTextView.getText().toString();
                String category = categoryAutoCompleteTextView.getText().toString();
                String pricing = activityPricingEditText.getText().toString();
                String description = activityDescriptionEditText.getText().toString();

                // Create an instance of ActivityDetails
                Activity activity = new Activity(activityName, location, category, "", pricing, description);

                // Store the instance for later retrieval
                MyApplication.setActivity(activity);

                // Display a message or navigate to another activity if needed
                Toast.makeText(NewActivity.this, "Activity details saved", Toast.LENGTH_SHORT).show();

                // Navigate to DealDetails activity
                Intent intent = new Intent(NewActivity.this, DealDetails.class);
                startActivity(intent);
            }
        });
    }

    // Method to handle Home button click
    public void gohomepge(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}