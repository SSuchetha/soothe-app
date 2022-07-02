package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener
{
    Button book;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        book=(Button)findViewById(R.id.book);
        book.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        Bundle bundle = new Bundle();
        Intent it = new Intent(this, BookAppointment.class);
        //it.putExtra("data", bundle);
        startActivity(it);
    }
}