
package com.apptech.pixel4d.model.home;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.apptech.pixel4d.other.ApiClient;
import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WallpaperFeatured {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("meta_title")
    @Expose
    private String metaTitle;
    @SerializedName("cat_id")
    @Expose
    private Object catId;
    @SerializedName("cat_name")
    @Expose
    private String catName;
    @SerializedName("color_id")
    @Expose
    private Object colorId;
    @SerializedName("color_code")
    @Expose
    private String colorCode;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("obj1")
    @Expose
    private Object obj1;
    @SerializedName("obj2")
    @Expose
    private Object obj2;
    @SerializedName("obj3")
    @Expose
    private Object obj3;
    @SerializedName("img1")
    @Expose
    private Object img1;
    @SerializedName("img2")
    @Expose
    private Object img2;
    @SerializedName("img3")
    @Expose
    private Object img3;
    @SerializedName("effect_img")
    @Expose
    private Object effectImg;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("featured")
    @Expose
    private String featured;
    @SerializedName("paid")
    @Expose
    private String paid;
    @SerializedName("ttl_downld")
    @Expose
    private Object ttlDownld;
    @SerializedName("hide")
    @Expose
    private String hide;
    @SerializedName("opacity")
    @Expose
    private String opacity;

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

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public Object getCatId() {
        return catId;
    }

    public void setCatId(Object catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Object getColorId() {
        return colorId;
    }

    public void setColorId(Object colorId) {
        this.colorId = colorId;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Object getObj1() {
        return obj1;
    }

    public void setObj1(Object obj1) {
        this.obj1 = obj1;
    }

    public Object getObj2() {
        return obj2;
    }

    public void setObj2(Object obj2) {
        this.obj2 = obj2;
    }

    public Object getObj3() {
        return obj3;
    }

    public void setObj3(Object obj3) {
        this.obj3 = obj3;
    }

    public Object getImg1() {
        return img1;
    }

    public void setImg1(Object img1) {
        this.img1 = img1;
    }

    public Object getImg2() {
        return img2;
    }

    public void setImg2(Object img2) {
        this.img2 = img2;
    }

    public Object getImg3() {
        return img3;
    }

    public void setImg3(Object img3) {
        this.img3 = img3;
    }

    public Object getEffectImg() {
        return effectImg;
    }

    public void setEffectImg(Object effectImg) {
        this.effectImg = effectImg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public Object getTtlDownld() {
        return ttlDownld;
    }

    public void setTtlDownld(Object ttlDownld) {
        this.ttlDownld = ttlDownld;
    }

    public String getHide() {
        return hide;
    }

    public void setHide(String hide) {
        this.hide = hide;
    }

    public String getOpacity() {
        return opacity;
    }

    public void setOpacity(String opacity) {
        this.opacity = opacity;
    }



    @BindingAdapter("android:productImage")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView)
                .load(ApiClient.IMAGE_BASE_URL + imageUrl)
                .fitCenter()
                .into(imageView);
    }


}
