package com.example.lovecaculator;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.example.lovecaculator.R.id.name_nam;

public class Enter_activity extends AppCompatActivity {
    CalendarView calendar;
    TextView myDate, ten_nam, ten_nu, old_date;
    Button to_Result;
    static final String str_nam = "Tên Nam";
    static final String str_nu = "Tên Nữ";
    static final String str_old_date = "Bắt Đầu";
    static final String str_date = "Tên Date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_activity);

        calendar = (CalendarView) findViewById(R.id.calendar);
        ten_nam = (TextView) findViewById(R.id.name_nam);
        ten_nu = (TextView) findViewById(R.id.name_nu);
        old_date = (TextView) findViewById(R.id.old_date);


        myDate = (TextView) findViewById(R.id.getDate);

        to_Result = findViewById(R.id.submit);
        to_Result.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                change_Result();
            }
        });

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                String date = (month + 1) + "/" + day + "/" + year;
                myDate.setText(date);
            }
        });
    }

    public void change_Result() {
        Intent intent = new Intent(Enter_activity.this, Result_activity.class);
        String nam = ten_nam.getText().toString();
        String nu = ten_nu.getText().toString();
        String old = old_date.getText().toString();
        String date = myDate.getText().toString();
        Extra(nam, nu, old, date);


    }

    public void Extra(String nam, String nu, String old, String date) {
        Intent intent = new Intent(Enter_activity.this, Result_activity.class);
        intent.putExtra(str_nam, nam);
        intent.putExtra(str_nu, nu);
        intent.putExtra(str_old_date, old);
        intent.putExtra(str_date, date);
        startActivity(intent);


    }




}