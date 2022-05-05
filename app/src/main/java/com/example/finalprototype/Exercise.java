package com.example.finalprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Exercise extends AppCompatActivity {

    public int count;
    TextView timer;
    Button button;
    boolean going;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.getSupportActionBar()!=null)
        {
            this.getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_exercise);

        ImageView exit = findViewById(R.id.exitExercise);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goHomeScreen();
            }
        });

        button = (Button) findViewById(R.id.button);
        timer = (TextView) findViewById(R.id.timer);
        timer.setText(countToTime(data_helper.getData().duration * 60));
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (!going) {
                    going = true;
                    button.setText("Exit");
                    button.setBackgroundResource(R.drawable.exit_button);
                    ImageView x = findViewById(R.id.imageView3);
                    x.setVisibility(View.INVISIBLE);
                    //5 minutes for testing purposes
                    count = data_helper.getData().duration * 60;
                    new CountDownTimer(count * 1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            findViewById(R.id.spinner).animate().rotationBy(90).start();
                            timer.setText(countToTime(count));
                            count--;
                        }

                        public void onFinish() {
                            timer.setText("Great Work!");
                            data_helper.getData().incrementCompleted();
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            goHomeScreen();
                        }
                    }.start();
                } else {
                    data_helper.getData().incrementIncomplete();
                    goHomeScreen();
                }
            }
        });
    }

    public String countToTime(int n) {
        String ret = "00:0";
        ret += Integer.toString(n/60) + ":";
        if (n % 60 < 10) {
            ret += "0";
        }
        ret += Integer.toString(n%60);
        return ret;
    }

    public void goHomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}