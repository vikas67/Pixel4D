package com.apptech.pixel4d;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.apptech.pixel4d.adapter.NavigationAdapter;
import com.apptech.pixel4d.databinding.ActivityMainBinding;
import com.apptech.pixel4d.model.NavigationList;
import com.apptech.pixel4d.model.home.Category;
import com.apptech.pixel4d.ui.home.HomeViewModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationAdapter.NavigationInterface {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    RecyclerView recyclerView;
    List<NavigationList> navigationLists = new ArrayList<>();
    Menu mMenu;
    private HomeViewModel homeViewModel;
    private static final String TAG = "MainActivity";
    DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);


        drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        binding.premium.setOnClickListener(v -> {
            navController.navigate(R.id.nav_premium);
        });


        binding.appBarMain.CancleBtn.setOnClickListener(v -> {
            mMenu.findItem(R.id.action_search).setVisible(true);
            binding.appBarMain.searchViewEditText.setVisibility(View.INVISIBLE);
            binding.appBarMain.CancleBtn.setVisibility(View.INVISIBLE);
            getSupportActionBar().setTitle("Home");
        });

        homeViewModel.mainListMutableLiveData.observe(this, mainList -> {
            binding.recycle.setAdapter(new NavigationAdapter(mainList.getCategory(), this));
        });

        homeViewModel.categorysearch.observe(this, mainList -> {
            NavigationAdapter navigationAdapter = new NavigationAdapter(mainList.getCategory(), this);
            binding.recycle.setAdapter(navigationAdapter);
            navigationAdapter.notifyDataSetChanged();
        });

        binding.appBarMain.searchViewEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                homeViewModel.getSearchString(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mMenu=menu;
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        final int EDIT = 1;
        final int FILE = 0;
        final int NEW_MENU_ITEM = Menu.FIRST;
        final int SAVE_MENU_ITEM = NEW_MENU_ITEM + 1;
        final int UNDO_MENU_ITEM = SAVE_MENU_ITEM + 1;
        final int REDO_MENU_ITEM = UNDO_MENU_ITEM + 1;
        SubMenu color = menu.addSubMenu("Color");
        SubMenu date_time = menu.addSubMenu("Date Time");
//
//        editMenu.add(EDIT, UNDO_MENU_ITEM, 0, "undo");
//        editMenu.add(EDIT, REDO_MENU_ITEM, 1, "redo");



        homeViewModel.mainListMutableLiveData.observe(this, mainList -> {
            for (int i=0;i<mainList.getColors().size();i++){
                color.add(FILE, NEW_MENU_ITEM, i, mainList.getColors().get(i).getName());
            }
        });

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.e("dsfn", String.valueOf(item.getItemId()));
        switch (item.getItemId()) {
            case 0:
//                PopupMenu popupMenu = new PopupMenu(MainActivity.this, binding.getRoot());
//                popupMenu.getMenuInflater().inflate(R.menu.filtermenu, item.getSubMenu());
//                popupMenu.show();
                break;
            case R.id.action_search:
                mMenu.findItem(0).setVisible(false);
                mMenu.findItem(R.id.action_search).setVisible(false);
                binding.appBarMain.searchViewEditText.setVisibility(View.VISIBLE);
                binding.appBarMain.CancleBtn.setVisibility(View.VISIBLE);
                getSupportActionBar().setTitle("");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void navigationItemClick(Category list) {
        homeViewModel.WallpaperCategoryId(list.getName());
        drawer.close();
    }


}



