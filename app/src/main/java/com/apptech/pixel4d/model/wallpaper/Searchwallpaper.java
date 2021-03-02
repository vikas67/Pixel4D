
package com.apptech.pixel4d.model.wallpaper;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Searchwallpaper {

    @SerializedName("wallpapers")
    @Expose
    private List<Wallpaper> wallpapers = null;

    public List<Wallpaper> getWallpapers() {
        return wallpapers;
    }

    public void setWallpapers(List<Wallpaper> wallpapers) {
        this.wallpapers = wallpapers;
    }

}
