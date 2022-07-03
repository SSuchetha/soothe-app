package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class BookAppointment extends AppCompatActivity implements View.OnClickListener
{
    EditText name,phno;
    Button btnBook;
    appHelper apphelper;
    CalendarView cal;
    String slot;
    private String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        name=(EditText) findViewById(R.id.name);
        phno=(EditText) findViewById(R.id.Phone);
        btnBook=(Button)findViewById(R.id.btnBookApp);
        btnBook.setOnClickListener(this);
        apphelper=new appHelper(this);
        cal=(CalendarView) findViewById(R.id.cal);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate=Integer.toString(year)+Integer.toString(month)+Integer.toString(dayOfMonth);
            }
        });
    }

    public void onRadioButtonClicked(View v)
    {
        boolean checked=((RadioButton) v).isChecked();
        switch(v.getId())
        {
            case R.id.b1:
                if(checked)
                    slot="6:00 pm - 7:30 pm";
                break;
            case R.id.b2:
                if(checked)
                    slot="7:30 pm - 9:00 pm";
                break;
        }
    }

    public void onClick(View v)
    {
        String txtname=name.getText().toString();
        String txtphno=phno.getText().toString();
        if(apphelper.insertData(txtname,txtphno,slot,selectedDate))
            Toast.makeText(BookAppointment.this, "Appointment Booked Successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(BookAppointment.this, "Please choose another date/slot", Toast.LENGTH_SHORT).show();
    }
}