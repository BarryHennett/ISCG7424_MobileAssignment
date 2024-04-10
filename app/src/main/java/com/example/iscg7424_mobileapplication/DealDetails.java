package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class DealDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_deal_details);

        // Retrieve the stored activity details
        Activity activity = MyApplication.getActivity();

        // Display the details in your UI as needed
        if (activity != null) {
            // Example: Display activity name in a TextView
            TextView activityNameTextView = findViewById(R.id.activityNameTextView);
            activityNameTextView.setText(activity.getActivityName());

            // Similarly, display other details in your UI
        }
    }

    // Method to handle Home button click
    public void gohomepge(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}