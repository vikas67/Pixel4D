
package com.apptech.pixel4d.model.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wallpaper {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cat_name")
    @Expose
    private String catName;
    @SerializedName("color_code")
    @Expose
    private String colorCode;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("effect_img")
    @Expose
    private Object effectImg;
    @SerializedName("time")
    @Expose
    private String time;
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

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
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

}
