package com.apptech.pixel4d.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.apptech.pixel4d.R;

public class WallpaperDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_details);

        Toast.makeText(this, ""+getIntent().getStringExtra("id"), Toast.LENGTH_SHORT).show();

    }
}