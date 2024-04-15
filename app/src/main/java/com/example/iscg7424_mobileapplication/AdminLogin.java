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

public class AdminLogin extends AppCompatActivity {

    EditText adminkey, email, password;
    Button login, register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_login);

        adminkey = (EditText) findViewById(R.id.admkeylgn);
        email = (EditText) findViewById(R.id.adminemaillgn);
        password = (EditText) findViewById(R.id.admpwordlgn);
        login = (Button) findViewById(R.id.adminlogbtn);



    }




    public static class AccountManager {
        private Map<String, String> accounts;
        private String adminKey;

        public AccountManager() {
            // Initialize the accounts map with username-password pairs
            accounts = new HashMap<>();
            accounts.put("user1@example.com", "password1");
            accounts.put("user2@example.com", "password2");
            // Add more accounts as needed

            // Set the admin key
            adminKey = "admin123";
        }

        public boolean isValidAccount(String username, String password) {
            // Check if the provided username and password match any of the accounts
            String storedPassword = accounts.get(username);
            return storedPassword != null && storedPassword.equals(password);
        }

        public boolean isAdminKeyValid(String key) {
            // Check if the provided key matches the admin key
            return key.equals(adminKey);
        }
    }

    public void login() {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String key = adminkey.getText().toString().trim();

        AccountManager accountManager = new AccountManager();

        if (accountManager.isAdminKeyValid(key)) {

            Toast.makeText(this, "Admin key is valid!", Toast.LENGTH_LONG).show();
        } else if (accountManager.isValidAccount(user, pass)) {
            Intent intent = new Intent(getApplicationContext(), AdminProfile.class);
            startActivity(intent);

            Toast.makeText(this, "Username and password matched!", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_LONG).show();
        }
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