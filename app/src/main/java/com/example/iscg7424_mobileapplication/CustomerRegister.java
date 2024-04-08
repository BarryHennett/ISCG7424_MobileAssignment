package com.example.iscg7424_mobileapplication;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;
import java.util.List;

import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;


public class CustomerRegister extends AppCompatActivity {
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_register);


        firstNameEditText = findViewById(R.id.FNameCt);
        lastNameEditText = findViewById(R.id.LNameCt);
        emailEditText = findViewById(R.id.EmailInputCt);
        passwordEditText = findViewById(R.id.PasswordInputCt);
        registerButton = findViewById(R.id.RegisterButtonCt);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve input values
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Create a new customer object
                Customer customer = new Customer();
                customer.setFNameCt(firstName);
                customer.setLNameCt(lastName);
                customer.setEmail(email);
                customer.setPword(password);

                displayCustomerInfoToast(firstName, lastName, email, password);
            }
        });
    }



    private void displayCustomerInfoToast(String firstName, String lastName, String email, String password) {
        String customerInfo = "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Password: " + password;

        Toast.makeText(CustomerRegister.this, customerInfo, Toast.LENGTH_LONG).show();
    }
}