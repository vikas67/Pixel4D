package com.apptech.pixel4d.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apptech.pixel4d.databinding.RowProductImgBinding;
import com.apptech.pixel4d.model.home.Wallpaper;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductImageAdapter extends RecyclerView.Adapter<ProductImageAdapter.ViewBinding> {

    List<Wallpaper> wallpapers;
    RowProductImgBinding binding;

    public ProductImageAdapter(List<Wallpaper> wallpapers) {
        this.wallpapers = wallpapers;
    }

    @NonNull
    @NotNull
    @Override
    public ViewBinding onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        binding = RowProductImgBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewBinding(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewBinding holder, int position) {
        Wallpaper list = wallpapers.get(position);
        binding.setWallpaperlist(list);
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return wallpapers.size();
    }



    public class ViewBinding extends RecyclerView.ViewHolder {
        public ViewBinding(@NonNull @NotNull RowProductImgBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
