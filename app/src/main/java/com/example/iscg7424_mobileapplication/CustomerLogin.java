package com.example.iscg7424_mobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerLogin extends AppCompatActivity {
    EditText email, password;
    Button login, register;
    CusDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        email = (EditText) findViewById(R.id.customeremaillgn);
        password = (EditText) findViewById(R.id.customerpwordlgn);
        login = (Button) findViewById(R.id.customerloginbtn);
        DB = new CusDBHelper(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = email.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(CustomerLogin.this, "Please Enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkemailpass(user,pass);{
                        if (checkuserpass==true){
                            Toast.makeText(CustomerLogin.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomePage.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(CustomerLogin.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        register = (Button) findViewById(R.id.cusregisterInsteadBtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), CustomerRegister.class);
                startActivity(intent);
            }
        });
    }



    public void gohomepge(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void gocrg(View view) {
        Intent intent = new Intent(this, CustomerRegister.class);
        startActivity(intent);
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