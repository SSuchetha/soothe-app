package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.HashSet;

public class BookAppointment extends AppCompatActivity implements View.OnClickListener
{
    EditText name,phno;
    Button btnBook;
    appHelper apphelper;
    CalendarView cal;
    String slot;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String selectedDate;
    HashSet<String> set;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        name=(EditText) findViewById(R.id.name);
        phno=(EditText) findViewById(R.id.Phone);
        btnBook=(Button)findViewById(R.id.btnBookApp);
        btnBook.setOnClickListener(this);
        radioGroup=findViewById(R.id.groupradio);
        set=new HashSet<>();
        apphelper=new appHelper(this);
        cal=(CalendarView) findViewById(R.id.cal);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate=Integer.toString(year)+"/"+Integer.toString(month+1)+"/"+Integer.toString(dayOfMonth);
            }
        });
    }

    public void onRadioButtonClicked(View v)
    {
        int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radioId);
        slot=radioButton.getText().toString();
    }

    public void onClick(View v)
    {
        String txtname=name.getText().toString();
        String txtphno=phno.getText().toString();
        String check=slot+" "+selectedDate;
        if(set.add(check))
            Toast.makeText(this, "Appointment booked successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Please choose another date/slot", Toast.LENGTH_SHORT).show();
        /*Boolean check=apphelper.checkSlotDate(slot,selectedDate);
        if(txtname.equals("") || txtphno.equals("") || slot.equals("")||selectedDate.equals(""))
            Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show();
        else if(!check)
        {
            Boolean res = apphelper.insertData(txtname, txtphno, slot, selectedDate);
            if (res == true)
                Toast.makeText(this, "Appointment Booked Successfully", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this,"Please choose another date or slot",Toast.LENGTH_SHORT).show();*/
    }
}