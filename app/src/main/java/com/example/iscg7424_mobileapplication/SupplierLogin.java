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

public class SupplierLogin extends AppCompatActivity {
    EditText email, compname, password;
    Button login, register;
    SupDBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_supplier_login);

        compname = (EditText) findViewById(R.id.supcompanyname);
        email = (EditText) findViewById(R.id.supplieremaillgn);
        password = (EditText) findViewById(R.id.suppwordlgn);
        login = (Button) findViewById(R.id.supplierlogbtn);
        DB = new SupDBHelper(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comname = compname.getText().toString();
                String user = email.getText().toString();
                String pass = password.getText().toString();

                if(comname.equals("")||user.equals("")||pass.equals(""))
                    Toast.makeText(SupplierLogin.this, "Please Enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkkeyuserpass = DB.checkemailnrest(user, comname, pass);{
                        if (checkkeyuserpass==true){
                            Toast.makeText(SupplierLogin.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomePage.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SupplierLogin.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        register = (Button) findViewById(R.id.supregisterInsteadBtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SupplierRegister.class);
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