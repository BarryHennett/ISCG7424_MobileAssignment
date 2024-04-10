package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminLogin extends AppCompatActivity {

    EditText adminkey, email, password;
    Button login, register;
    AdmDBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_login);

        adminkey = (EditText) findViewById(R.id.admkeylgn);
        email = (EditText) findViewById(R.id.adminemaillgn);
        password = (EditText) findViewById(R.id.admpwordlgn);
        login = (Button) findViewById(R.id.adminlogbtn);
        DB = new AdmDBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = adminkey.getText().toString();
                String user = email.getText().toString();
                String pass = password.getText().toString();

                if(key.equals("")||user.equals("")||pass.equals(""))
                    Toast.makeText(AdminLogin.this, "Please Enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkkeyuserpass = DB.checkemailnrest(user, key, pass);{
                        if (checkkeyuserpass==true){
                            Toast.makeText(AdminLogin.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomePage.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(AdminLogin.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        register = (Button) findViewById(R.id.admregisterInsteadBtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AdminRegister.class);
                startActivity(intent);
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