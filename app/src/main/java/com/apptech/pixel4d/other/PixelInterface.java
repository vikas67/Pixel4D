package com.apptech.pixel4d.other;

import com.apptech.pixel4d.model.home.MainList;
import com.apptech.pixel4d.model.home.Wallpaper;
import com.apptech.pixel4d.model.wallpaper.Searchwallpaper;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PixelInterface {

    @GET("wallpapers_parallex")
    Call<MainList> getNavigation();

    @GET("wallpapers_parallex")
    Call<MainList> categorySearch(@Query("cat_name") String cat_name);

    @POST("search_wallpaper")
    @FormUrlEncoded
    Call<Wallpaper> searchwallpaper(@Field("search") String search);

}
