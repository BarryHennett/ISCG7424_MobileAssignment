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

import com.example.iscg7424_mobileapplication.dbhelpers.SupDBHelper;

public class SupplierRegister extends AppCompatActivity {

    EditText fname, lname, compname, email, password;
    Button register, login;
    SupDBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_supplier_register);

        fname = (EditText) findViewById(R.id.supplierfnameinput);
        lname = (EditText) findViewById(R.id.supplierlnameinput);
        compname = (EditText) findViewById(R.id.companynameinput);
        email = (EditText) findViewById(R.id.supplieremailinput);
        password = (EditText) findViewById(R.id.supplierpwordinput);
        register = (Button) findViewById(R.id.registersupplierbtn);
        login = (Button) findViewById(R.id.LoginInsteadBtn);


        DB = new SupDBHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firname = fname.getText().toString();
                String lasname = lname.getText().toString();
                String supnme = compname.getText().toString();
                String user = email.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")||firname.equals("")||lasname.equals("")||supnme.equals(""))
                    Toast.makeText(SupplierRegister.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkemail = DB.checkemail(user);
                    if (checkemail==false){
                        Boolean insert = DB.insertData(user,firname,lasname,supnme,pass);
                        if (insert==true){
                            Toast.makeText(SupplierRegister.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),SupplierLogin.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(SupplierRegister.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(SupplierRegister.this, "User Already Exists, please sign in ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SupplierLogin.class);
                startActivity(intent);
            }
        });
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

    public void gohomepge(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}