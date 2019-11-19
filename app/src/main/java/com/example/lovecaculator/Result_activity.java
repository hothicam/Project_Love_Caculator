package com.example.lovecaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Result_activity extends AppCompatActivity {
 TextView result_nam,result_nu, result_old_date, result_date, tvDiffDate;
 Button quay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);
        result_nam = (TextView) findViewById(R.id.name_nam);
        result_nu = (TextView) findViewById(R.id.name_nu);
        result_date = (TextView) findViewById(R.id.show_Date);
        result_old_date= (TextView) findViewById(R.id.old_date);
        tvDiffDate= (TextView) findViewById(R.id.text_diff_date);
        quay = (Button) findViewById(R.id.quay_lai);
        quay.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                returnscreen();
            }
        });
        Setdata();
    }

    public void returnscreen(){
        Intent intent = new Intent(Result_activity.this, Enter_activity.class);
        startActivity(intent);
    }

    public  void  Setdata(){
        Intent intent = getIntent();
        String nam = intent.getStringExtra(Enter_activity.str_nam);
        String nu = intent.getStringExtra(Enter_activity.str_nu);
        String date = intent.getStringExtra(Enter_activity.str_date);
        String old_date = intent.getStringExtra(Enter_activity.str_old_date);

        result_nam.setText(nam);
        result_nu.setText(nu);
        result_old_date.setText(old_date);
        result_date.setText(date);

        caculator(old_date, date);
    }

    public void caculator(String oldDate, String newDate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        try {
            Date oldD = dateFormat.parse(oldDate);
            Date today = dateFormat.parse(newDate);

            long diff = today.getTime() - oldD.getTime();
            int days = (int) (diff / (1000 * 60 * 60 * 24));
            tvDiffDate.setText(""+days);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
