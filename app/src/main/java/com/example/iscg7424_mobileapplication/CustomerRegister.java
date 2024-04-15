package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.iscg7424_mobileapplication.dbhelpers.CusDBHelper;

public class CustomerRegister extends AppCompatActivity {
    EditText fname, lname, email, password;
    Button register, login;
    CusDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_register);

        fname = (EditText) findViewById(R.id.cusfnameinput);
        lname = (EditText) findViewById(R.id.cuslnameinput);
        email = (EditText) findViewById(R.id.cusemailinput);
        password = (EditText) findViewById(R.id.cuspasswordinput);
        register = (Button) findViewById(R.id.registercusbtn);
        login = (Button) findViewById(R.id.LoginInsteadBtn);
        DB = new CusDBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firname = fname.getText().toString();
                String lasname = lname.getText().toString();
                String user = email.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")||firname.equals("")||lasname.equals(""))
                    Toast.makeText(CustomerRegister.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkemail = DB.checkemail(user);
                    if (checkemail==false){
                        Boolean insert = DB.insertData(user,firname,lasname,pass);
                        if (insert==true){
                            Toast.makeText(CustomerRegister.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),CustomerLogin.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(CustomerRegister.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(CustomerRegister.this, "User Already Exists, please sign in ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), CustomerLogin.class);
                startActivity(intent);
            }
        });
    }

    public void GoCusReg(View view) {
        Intent intent = new Intent(this, CustomerRegister.class);
        startActivity(intent);
    }

}
