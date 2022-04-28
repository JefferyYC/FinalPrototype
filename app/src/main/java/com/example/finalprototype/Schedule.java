package com.example.finalprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.getSupportActionBar()!=null)
        {
            this.getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_schedule);
    }
}