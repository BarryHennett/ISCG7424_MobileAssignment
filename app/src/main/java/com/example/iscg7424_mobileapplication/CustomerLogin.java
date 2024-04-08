package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.EditText;
import android.widget.Toast;

public class CustomerLogin extends AppCompatActivity {


    private String validEmail = "john@example.com";
    private String validPassword = "password";

    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
    }



    public void login(View view) {
        // Get input values
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Check if email and password are valid
        if (email.equals(validEmail) && password.equals(validPassword)) {
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