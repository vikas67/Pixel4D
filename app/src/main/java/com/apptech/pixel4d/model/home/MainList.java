
package com.apptech.pixel4d.model.home;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainList {

    @SerializedName("colors")
    @Expose
    private List<Color> colors = null;
    @SerializedName("category")
    @Expose
    private List<Category> category = null;
    @SerializedName("wallpaper_featured")
    @Expose
    private List<WallpaperFeatured> wallpaperFeatured = null;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = null;
    @SerializedName("wallpapers")
    @Expose
    private List<Wallpaper> wallpapers = null;

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<WallpaperFeatured> getWallpaperFeatured() {
        return wallpaperFeatured;
    }

    public void setWallpaperFeatured(List<WallpaperFeatured> wallpaperFeatured) {
        this.wallpaperFeatured = wallpaperFeatured;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Wallpaper> getWallpapers() {
        return wallpapers;
    }

    public void setWallpapers(List<Wallpaper> wallpapers) {
        this.wallpapers = wallpapers;
    }

}
