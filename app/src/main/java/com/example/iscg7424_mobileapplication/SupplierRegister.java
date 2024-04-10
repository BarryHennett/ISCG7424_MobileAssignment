package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SupplierRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_supplier_register);

    }


    public void GoCusReg(View view) {
        Intent intent = new Intent(this, CustomerRegister.class);
        startActivity(intent);
    }
    public void GoSupReg(View view) {
        Intent intent = new Intent(this, SupplierRegister.class);
        startActivity(intent);
    }
    public void GoAdminReg(View view) {
        Intent intent = new Intent(this, AdminRegister.class);
        startActivity(intent);
    }
}