package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewActivity extends AppCompatActivity {

    EditText activityName;
    AutoCompleteTextView activityLocation;
    AutoCompleteTextView activityCategory;
    DatePicker activityDate;
    EditText activityPricing;
    EditText activityDescription;
    Button submitButton, getdatabtn;

    DealsDatabase dealsDB;

    List<Deals> dealsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);
        setupAutoCompleteTextView();

        activityName = findViewById(R.id.activityNameEditText);
        activityLocation  = findViewById(R.id.LCTDrpDwn);
        activityCategory = findViewById(R.id.CtgDrpDwn);
        activityDate = findViewById(R.id.datePicker);
        activityPricing = findViewById(R.id.activityPricingEditText);
        activityDescription = findViewById(R.id.activityDescriptionEditText);

        submitButton = findViewById(R.id.submitButtonnewactivity);
        getdatabtn = findViewById(R.id.getdataButtonnewactivity);
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


                addDealsInBackground(d1);


            }
        });

        getdatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDealsListInBackground();

            }
        });
    }



    public void addDealsInBackground(Deals deals){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //background task

                dealsDB.getDealsDAO().addDeals(deals);
                //finishing task
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(NewActivity.this, "Added to Database", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }

    public void getDealsListInBackground(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //background task
                dealsList = dealsDB.getDealsDAO().getAllDeals();

                //finishing task
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        StringBuilder sb = new StringBuilder();
                        for (Deals d : dealsList){
                            sb.append(d.getName()+" : "+d.getLocation()+" : "+d.getCategory()+" : "+d.getDate()+" : "+d.getPrice()+" : "+d.getDesciption());
                            sb.append("\n");
                        }
                        String finalData = sb.toString();
                        Toast.makeText(NewActivity.this, ""+ finalData, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    public void setupAutoCompleteTextView() {
        // Get reference to AutoCompleteTextView
        AutoCompleteTextView autoCompleteTextViewloc = findViewById(R.id.LCTDrpDwn);
        AutoCompleteTextView autoCompleteTextViewcat = findViewById(R.id.CtgDrpDwn);

        // Define data source
        String[] categories = {"Category 1", "Category 2", "Category 3", "Category 4", "Category 5"};

        // Create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, categories);

        // Set adapter to AutoCompleteTextView
        autoCompleteTextViewloc.setAdapter(adapter);
        autoCompleteTextViewcat.setAdapter(adapter);

    }

    public void gohomepge(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}