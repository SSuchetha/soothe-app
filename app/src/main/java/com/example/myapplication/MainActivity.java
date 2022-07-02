package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        EditText txtUsername;
        EditText txtPassword;
        Button btnSignup;
        Button btnLogin;
        dbHelper db;
        String regularExpression="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                txtUsername=(EditText)findViewById(R.id.txt_username);
                txtPassword=(EditText)findViewById(R.id.txt_password);
                btnSignup=(Button)findViewById(R.id.btn_signup);
                btnSignup.setOnClickListener(this);
                btnLogin=(Button)findViewById(R.id.login);
                btnLogin.setOnClickListener(this);
                db=new dbHelper(this);
        }
        public void onClick(View v)
        {
                if(v.equals(btnLogin))
                {
                        Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                }
                if(v.equals(btnSignup))
                {
                        String username=txtUsername.getText().toString();
                        String password=txtPassword.getText().toString();

                        if(username.equals("") || password.equals(""))
                                Toast.makeText(MainActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                        else if(!validatePassword(password))
                                Toast.makeText(MainActivity.this, "Please enter a valid password", Toast.LENGTH_SHORT).show();
                        else
                        {
                                Boolean checkUser=db.checkUsername(username);
                                if(!checkUser)
                                {
                                        Boolean insert=db.insertData(username, password);
                                        if(insert)
                                        {
                                                Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                                Intent intent=new Intent(getApplicationContext(), HomeActivity.class);
                                                startActivity(intent);
                                        }
                                        else
                                                Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                }
                                else
                                        Toast.makeText(MainActivity.this, "Username already exists", Toast.LENGTH_SHORT).show();
                        }
                }
        }
        public boolean validatePassword(String password)
        {
                Pattern pattern= Pattern.compile(regularExpression);
                Matcher matcher=pattern.matcher(password);
                return matcher.matches();
        }
}