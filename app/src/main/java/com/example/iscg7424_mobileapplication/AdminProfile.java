package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iscg7424_mobileapplication.dbhelpers.AdmDBHelper;

public class AdminProfile extends AppCompatActivity {
    RecyclerView recyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_profile);

        String [] fname = {"Harry","Christopher"};
        String [] lname = {"Bennett","Dronjak"};
        String [] email = {"harry@gmail.com","christopher@gmail.com"};


        recyclerView2 = findViewById(R.id.r_admin_view);
        RVAdapter2 adapter = new RVAdapter2(this, fname, lname, email);
        recyclerView2.setLayoutManager( new LinearLayoutManager(this));
        recyclerView2.setAdapter(adapter);

    }

    public void customerdtls(View view) {
    }
}