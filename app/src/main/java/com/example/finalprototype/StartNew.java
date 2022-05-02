package com.example.finalprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class StartNew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.getSupportActionBar()!=null)
        {
            this.getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_start_new);


        Button start = findViewById(R.id.start);
        EditText dur = findViewById(R.id.dur);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    data_helper.getData().duration = Integer.parseInt(dur.getText().toString());
                } catch (Exception e) {
                    data_helper.getData().duration = 5;
                }
                goExerciseScreen();
            }
        });

        ImageView exit = findViewById(R.id.exitbutton);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goHomeScreen();
            }
        });
    }

    public void goHomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goExerciseScreen() {
        Intent intent = new Intent(this, Exercise.class);
        startActivity(intent);
    }
}