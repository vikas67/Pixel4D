
package com.apptech.pixel4d.model.home;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.apptech.pixel4d.other.ApiClient;
import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("time")
    @Expose
    private Object time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }


    @BindingAdapter("android:productImage")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView)
                .load(ApiClient.IMAGE_BASE_URL + imageUrl)
                .fitCenter()
                .into(imageView);
    }


}
