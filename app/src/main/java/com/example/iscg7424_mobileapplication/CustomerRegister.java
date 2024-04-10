package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerRegister extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_register);

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
