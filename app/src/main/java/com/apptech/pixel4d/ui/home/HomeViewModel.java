package com.apptech.pixel4d.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.apptech.pixel4d.model.home.MainList;

import org.jetbrains.annotations.NotNull;

public class HomeViewModel extends AndroidViewModel {


    public MutableLiveData<MainList> mainListMutableLiveData;
    public MutableLiveData<MainList> categorysearch;
    HomeRepo homeRepo;
    private static final String TAG = "HomeViewModel";
    private MutableLiveData<String> mText = new MutableLiveData<>();


    public HomeViewModel(@NonNull @NotNull Application application) {
        super(application);
        homeRepo = new HomeRepo();
        mainListMutableLiveData = homeRepo.getFeatured();
        categorysearch = homeRepo.returnSearchCategoru();


    }

    public void getSearchString(String text) {
        mText.setValue(text);
    }



    public void WallpaperCategoryId(String cat_name) {
        homeRepo.Category_search_cat_name(cat_name);
    }

    public LiveData<String> getText() {
        return mText;
    }



}