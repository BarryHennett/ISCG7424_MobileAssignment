package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerLogin extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        emailEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                emailEditText.setText("");
                emailEditText.setOnTouchListener(null);
                return false;
            }
        });

        passwordEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                passwordEditText.setText("");
                passwordEditText.setOnTouchListener(null);
                return false;
            }
        });
    }

    public void login(View view) {
        // Get input values
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Retrieve customer data from SharedPreferences
        Customer savedCustomer = CustomerManager.getCustomer(getApplicationContext());

        // Check if customer data exists and matches the input
        if (savedCustomer != null && savedCustomer.getEmail().equals(email) && savedCustomer.getPword().equals(password)) {
            // Login successful, navigate to homepage
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
            finish(); // Finish current activity to prevent going back to login page
        } else {
            // Login failed, display error message
            Toast.makeText(this, "Invalid email or password. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }


    public void gohomepge(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void GoCusLogin(View view) {
        Intent intent = new Intent(this, CustomerLogin.class);
        startActivity(intent);
    }

    public void GoSupLogin(View view) {
        Intent intent = new Intent(this, SupplierLogin.class);
        startActivity(intent);
    }

    public void GoAdminLogin(View view) {
        Intent intent = new Intent(this, AdminLogin.class);
        startActivity(intent);
    }


    public void gocrg(View view) {
        Intent intent = new Intent(this, CustomerRegister.class);
        startActivity(intent);
    }
}