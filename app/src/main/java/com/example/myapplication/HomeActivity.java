package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener
{
    Button book, msg;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        book=(Button)findViewById(R.id.book);
        book.setOnClickListener(this);
        msg=(Button) findViewById(R.id.msg);
        msg.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        if(v.equals(book))
        {
            Intent it = new Intent(getApplicationContext(), BookAppointment.class);
            startActivity(it);
        }
        if(v.equals(msg))
        {
            String [] arr={"You are loved just for being who you are, just for existing.",
                    "There is hope, even when your brain tells you there isn’t.",
                    "Recovery is not one and done. It is a lifelong journey that takes place one day, one step at a time.",
                    "Am I good enough? YES I AM!!",
                    "Your perspective is unique. It's important and it COUNTS.",
                    "You, yourself, as much as anybody in the entire universe, deserve your love and affection.",
                    "My dark days made me strong. Or maybe I already was strong, and they made me prove it.",
                    "Sometimes you climb out of bed in the morning and you think, I’m not going to make it, but you laugh inside — remembering all the times you’ve felt that way.",
                    "Just when the caterpillar thought the world was ending, he turned into a butterfly",
                    "YOU DON'T HAVE TO STRUGGLE IN SILENCE"};
            Random random=new Random();
            int num= random.nextInt((11-1))+1;
            String list=arr[num];
            Toast.makeText(HomeActivity.this, list, Toast.LENGTH_SHORT).show();
        }
    }
}