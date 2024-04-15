package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.iscg7424_mobileapplication.dbhelpers.AdmDBHelper;

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

    public void login() {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (user.equals("techsupportnep") & pass.equals("techsupportnep")) {
            Toast.makeText(this, "username and password matched!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "username and password do not matched!", Toast.LENGTH_LONG).show();
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