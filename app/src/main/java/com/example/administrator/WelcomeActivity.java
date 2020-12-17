package com.example.administrator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        };
        timer.schedule(task, 3000);

    }
}
