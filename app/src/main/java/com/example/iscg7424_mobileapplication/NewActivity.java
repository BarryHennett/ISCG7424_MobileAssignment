package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


import com.example.iscg7424_mobileapplication.db.Deals;
import com.example.iscg7424_mobileapplication.db.DealsDAO;
import com.example.iscg7424_mobileapplication.db.DealsDatabase;

public class NewActivity extends AppCompatActivity {


    DealsDAO dealsDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);
        setupAutoCompleteTextView();

        dealsDAO = DealsDatabase.getInstance(this).dealsDAO();
    }

    public void addDeal(View view){
        EditText nameEditText = findViewById(R.id.activityNameEditText);
        AutoCompleteTextView locationDropDown = findViewById(R.id.LCTDrpDwn);
        AutoCompleteTextView categoryDropDown = findViewById(R.id.CtgDrpDwn);
        EditText dateEditText = findViewById(R.id.dateEditText);
        EditText priceEditText = findViewById(R.id.activityPricingEditText);
        EditText descriptionEditText = findViewById(R.id.activityDescriptionEditText);

        String name = nameEditText.getText().toString();
        String location = locationDropDown.getText().toString();
        String category = categoryDropDown.getText().toString();
        String date = dateEditText.getText().toString();
        String price = priceEditText.getText().toString();
        String description = descriptionEditText.getText().toString();

        Deals d = new Deals(name,location,category,date,price,description);
        dealsDAO.insertDeal(d);

    }



    public void displayAll(View view) {
        List<Deals> deals = dealsDAO.getAllDeals();

        // Assuming you have a TextView with the id "dealsTextView" in your layout
        TextView dealsTextView = findViewById(R.id.dealsTextView);


        // Concatenate deals strings to display them in the TextView
        StringBuilder dealsString = new StringBuilder();
        for (Deals deal : deals) {
            dealsString.append(deal.toString()).append("\n");
        }


        // Set the text of the TextView to the deals string
        dealsTextView.setText(dealsString.toString());







        //List<Deals> deals = dealsDAO.getAllDeals();
        //Toast.makeText(this, deals.toString(),Toast.LENGTH_LONG).show();
    }

    public void deleteAll(View view) {
        dealsDAO.deleteAllDeals();
        Toast.makeText(this,"All Deals Deleted",Toast.LENGTH_LONG).show();
    }

    public void gohomepge(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void setupAutoCompleteTextView() {
        // Get reference to AutoCompleteTextView
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.LCTDrpDwn);
        AutoCompleteTextView autoCompleteTextView2 = findViewById(R.id.CtgDrpDwn);

        // Define data source
        String[] location = {"location 1", "location 2", "location 3", "location 4", "location 5"};

        String[] categories = {"Category 1", "Category 2", "Category 3", "Category 4", "Category 5"};

        // Create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, location);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, categories);


        // Set adapter to AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView2.setAdapter(adapter2);

    }
}