package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.iscg7424_mobileapplication.dbhelpers.AdmDBHelper;

public class AdminProfile extends AppCompatActivity {
    EditText adminkey, email, password;
    Button login, register;
    AdmDBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_supplier_profile);

        adminkey = (EditText) findViewById(R.id.admkeylgn);
        email = (EditText) findViewById(R.id.adminemaillgn);
        password = (EditText) findViewById(R.id.admpwordlgn);
        login = (Button) findViewById(R.id.adminlogbtn);
        DB = new AdmDBHelper(this);

    }

    public void customerdtls(View view) {
    }
}