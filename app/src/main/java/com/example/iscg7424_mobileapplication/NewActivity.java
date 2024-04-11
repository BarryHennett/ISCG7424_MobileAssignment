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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class NewActivity extends AppCompatActivity {

    EditText activityName;
    AutoCompleteTextView activityLocation;
    AutoCompleteTextView activityCategory;
    DatePicker activityDate;
    EditText activityPricing;
    EditText activityDescription;
    Button submitButton;

    DealsDatabase dealsDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);

        activityName = findViewById(R.id.activityNameEditText);
        activityLocation  = findViewById(R.id.LCTDrpDwnAN);
        activityCategory = findViewById(R.id.CtgDrpDwnAN);
        activityDate = findViewById(R.id.datePicker);
        activityPricing = findViewById(R.id.activityPricingEditText);
        activityDescription = findViewById(R.id.activityDescriptionEditText);

        submitButton = findViewById(R.id.submitButtonnewactivity);

        RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        dealsDB = Room.databaseBuilder(getApplicationContext(),DealsDatabase.class,
                "DealsDB").addCallback(myCallBack).build();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = activityName.getText().toString();
                String location = activityLocation.getText().toString();
                String category = activityCategory.getText().toString();
                String date = String.valueOf(activityDate.getMaxDate());
                String pricing = activityPricing.getText().toString();
                String description = activityDescription.getText().toString();

                Deals d1 = new Deals(name, location, category, date, pricing, description);

                dealsDB.getDealsDAO().addDeals(d1);


            }
        });
    }

//finished video at 17min

    public void gohomepge(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}