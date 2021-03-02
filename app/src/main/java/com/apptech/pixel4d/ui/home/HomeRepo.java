package com.apptech.pixel4d.ui.home;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.apptech.pixel4d.model.home.MainList;
import com.apptech.pixel4d.model.home.Wallpaper;
import com.apptech.pixel4d.other.ApiClient;
import com.apptech.pixel4d.other.PixelInterface;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepo {

    private static final String TAG = "HomeRepo";
    PixelInterface anInterface;
    Context context;
    MutableLiveData<MainList> mainListMutableLiveData = new MutableLiveData<>();
    MutableLiveData<MainList> categorysearch = new MutableLiveData<>();


    public static HomeRepo ourInstance;

    public static HomeRepo getInstance() {
        return ourInstance = new HomeRepo();
    }


    public HomeRepo() {
        anInterface = ApiClient.getClient().create(PixelInterface.class);
    }


    public MutableLiveData getFeatured() {

        anInterface.getNavigation().enqueue(new Callback<MainList>() {
            @Override
            public void onResponse(Call<MainList> call, Response<MainList> response) {
                Log.e(TAG, "onResponse: " + new Gson().toJson(response.body()));
                if (response.isSuccessful()) {
                    mainListMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MainList> call, Throwable t) {

            }
        });

        return mainListMutableLiveData;
    }


    public void Category_search_cat_name(String name) {


        anInterface.categorySearch(name).enqueue(new Callback<MainList>() {
            @Override
            public void onResponse(Call<MainList> call, Response<MainList> response) {
                Log.e(TAG, "onResponse: " + new Gson().toJson(response.body()));
                if (response.isSuccessful()) {
                    categorysearch.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MainList> call, Throwable t) {

            }
        });

    }


    public MutableLiveData returnSearchCategoru() {
        return categorysearch;
    }



}



























