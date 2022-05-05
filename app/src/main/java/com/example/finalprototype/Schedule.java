package com.example.finalprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.finalprototype.ui.dashboard.DashboardFragment;

public class Schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.getSupportActionBar()!=null)
        {
            this.getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_schedule);


        Button schedule = findViewById(R.id.schedule);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goCalendar();
            }
        });

        ImageView exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goCalendar();
            }
        });
    }

    public void goCalendar() {
        Intent intent = new Intent(this, MainActivity.class);
        // assume only demoing "Add meditation for Apr 27 12:00 - 12:30"
        intent.putExtra("5", true);
        intent.putExtra("calendar", true);
        startActivity(intent);
    }
}