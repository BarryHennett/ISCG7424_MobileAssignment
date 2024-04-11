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

    EditText activityName;
    AutoCompleteTextView location;
    AutoCompleteTextView category;
    DatePicker datePicker;
    EditText activityPricing;
    EditText activityDescription;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);

        activityName = findViewById(R.id.activityNameEditText);
        location  = findViewById(R.id.LCTDrpDwnAN);
        category = findViewById(R.id.CtgDrpDwnAN);
        datePicker = findViewById(R.id.datePicker);
        activityPricing = findViewById(R.id.activityPricingEditText);
        activityDescription = findViewById(R.id.activityDescriptionEditText);

        submitButton = findViewById(R.id.submitButtonnewactivity);
    }



    public void gohomepge(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}