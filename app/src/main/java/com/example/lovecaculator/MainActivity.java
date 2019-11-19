package com.example.lovecaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity {

    Button changescreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changescreen = findViewById(R.id.setDate);
        changescreen.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openSecondscreen();
            }
        });
    }
    private void  openSecondscreen(){
        Intent intent = new Intent(MainActivity.this, Enter_activity.class);
        startActivity(intent);
    }
}
