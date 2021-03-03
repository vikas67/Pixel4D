package com.apptech.pixel4d.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.apptech.pixel4d.R;
import com.apptech.pixel4d.model.home.Wallpaper;
import com.apptech.pixel4d.ui.home.HomeViewModel;

import java.util.List;

public class WallpaperDetailsActivity extends AppCompatActivity {

    private HomeViewModel homeViewModel;
    List<Wallpaper> wallpaperlists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_details);

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

    }
}