package com.apptech.pixel4d.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.apptech.pixel4d.MainActivity;
import com.apptech.pixel4d.R;

import static java.lang.Thread.sleep;


public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        startActivity(new Intent(SplashActivity.this, MainActivity.class));

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // close splash activity
        finish();


    }
}