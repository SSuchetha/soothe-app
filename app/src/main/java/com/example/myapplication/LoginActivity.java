package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
        EditText txtLoginUsername;
        EditText txtLoginPassword;
        Button btnLogin;
        dbHelper db;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);
                txtLoginUsername=(EditText) findViewById(R.id.txt_login_username);
                txtLoginPassword=(EditText) findViewById(R.id.txt_login_password);
                btnLogin=(Button)findViewById(R.id.btn_login_signin);
                btnLogin.setOnClickListener(this);
                db=new dbHelper(this);
        }
        public void onClick(View v)
        {
                String username=txtLoginUsername.getText().toString();
                String password=txtLoginPassword.getText().toString();

                if(username.equals("") || password.equals(""))
                        Toast.makeText(LoginActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                else
                {
                        Boolean check=db.checkUsernamePassword(username, password);
                        if(check)
                        {
                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                        }
                        else
                                Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
        }
}