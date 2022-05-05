package com.example.finalprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.finalprototype.ui.notifications.NotificationsFragment;

public class Goals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        Button save = findViewById(R.id.save);
        EditText goals = findViewById(R.id.weekly_goal);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int i = Integer.parseInt(goals.getText().toString());
                    data_helper.getData().goal = i;
                } catch (Exception e) {
                    data_helper.getData().goal = 7;
                }
                goStatScreen();
            }
        });

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goStatScreen();
            }
        });
    }

    public void goStatScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stats", true);
        startActivity(intent);
    }
}