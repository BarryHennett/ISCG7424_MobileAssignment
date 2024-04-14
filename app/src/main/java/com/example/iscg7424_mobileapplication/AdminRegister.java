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

public class AdminRegister extends AppCompatActivity {

    EditText fname, lname, adminkey, email, password;
    Button register, login;
    AdmDBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_register);

        fname = (EditText) findViewById(R.id.adminfnameinput);
        lname = (EditText) findViewById(R.id.adminlnameinput);
        adminkey = (EditText) findViewById(R.id.adminkeyinput);
        email = (EditText) findViewById(R.id.adminemailinput);
        password = (EditText) findViewById(R.id.adminpwordinput);
        register = (Button) findViewById(R.id.registeradminbtn);
        login = (Button) findViewById(R.id.LoginInsteadBtn);

        DB = new AdmDBHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firname = fname.getText().toString();
                String lasname = lname.getText().toString();
                String admkey = adminkey.getText().toString();
                String user = email.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")||firname.equals("")||lasname.equals("")||admkey.equals(""))
                    Toast.makeText(AdminRegister.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                        Boolean checkemail = DB.checkemail(user);
                        if (checkemail==false){
                            Boolean insert = DB.insertData(user,firname,lasname,admkey,pass);
                            if (insert==true){
                                Toast.makeText(AdminRegister.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),HomePage.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(AdminRegister.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(AdminRegister.this, "User Already Exists, please sign in ", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AdminLogin.class);
                startActivity(intent);
            }
        });
    }
}