package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class SupplierLogin extends AppCompatActivity {
    EditText email, compname, password;
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_supplier_login);

        compname = (EditText) findViewById(R.id.supcompanyname);
        email = (EditText) findViewById(R.id.supplieremaillgn);
        password = (EditText) findViewById(R.id.suppwordlgn);
        login = (Button) findViewById(R.id.supplierlogbtn);

    }

    public static class SupAccountManager {
        private Map<String, String> accounts;
        private String compname;

        public SupAccountManager() {
            // Initialize the accounts map with username-password pairs
            accounts = new HashMap<>();
            accounts.put("user1@example.com", "password1");
            accounts.put("user2@example.com", "password2");
            // Add more accounts as needed

            // Set the admin key
            compname = "admin123";
        }

        public boolean isValidSupAccount(String username, String password) {
            // Check if the provided username and password match any of the accounts
            String storedPassword = accounts.get(username);
            return storedPassword != null && storedPassword.equals(password);
        }

        public boolean isSupCompValid(String key) {
            // Check if the provided key matches the admin key
            return key.equals(compname);
        }
    }

    public void login() {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String key = compname.getText().toString().trim();

        SupAccountManager supAccountManager = new SupAccountManager();

        if (supAccountManager.isSupCompValid(key)) {

            Toast.makeText(this, "Supplier company is valid!", Toast.LENGTH_LONG).show();
        } else if (supAccountManager.isValidSupAccount(user, pass)) {

            Toast.makeText(this, "Username and password matched!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), SupplierProfile.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_LONG).show();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }
        });
    }


    public void GoCusLogin(View view) {
        Intent intent = new Intent(this, CustomerLogin.class);
        startActivity(intent);
    }
    public void GoSupLoginbtn(View view) {
        Intent intent = new Intent(this, SupplierLogin.class);
        startActivity(intent);
    }
    public void GoAdminLogin(View view) {
        Intent intent = new Intent(this, AdminLogin.class);
        startActivity(intent);
    }

}