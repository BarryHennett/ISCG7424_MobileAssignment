package com.example.iscg7424_mobileapplication;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerRegister extends AppCompatActivity {
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_register);

        firstNameEditText = findViewById(R.id.FNameCt);
        lastNameEditText = findViewById(R.id.LNameCt);
        emailEditText = findViewById(R.id.EmailInputCt);
        passwordEditText = findViewById(R.id.PasswordInputCt);
        registerButton = findViewById(R.id.RegisterButtonCt);

        firstNameEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                firstNameEditText.setText("");
                firstNameEditText.setOnTouchListener(null);
                return false;
            }
        });

        lastNameEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                lastNameEditText.setText("");
                lastNameEditText.setOnTouchListener(null);
                return false;
            }
        });

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

                // Save the customer data
                CustomerManager.saveCustomer(getApplicationContext(), customer);

                // Display a toast confirming registration
                displayRegistrationToast(firstName, lastName, email);
            }
        });
    }

    private void displayRegistrationToast(String firstName, String lastName, String email) {
        String registrationInfo =
                "Registration successful!\n" +
                        "First Name: " + firstName + "\n" +
                        "Last Name: " + lastName + "\n" +
                        "Email: " + email;

        Toast.makeText(CustomerRegister.this, registrationInfo, Toast.LENGTH_LONG).show();
    }
}
