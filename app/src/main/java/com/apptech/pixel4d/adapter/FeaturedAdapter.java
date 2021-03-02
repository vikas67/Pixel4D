package com.apptech.pixel4d.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apptech.pixel4d.databinding.RowFeatureBinding;
import com.apptech.pixel4d.model.home.WallpaperFeatured;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.ViewBinding> {

    Context context;
    List<WallpaperFeatured> wallpaperFeatured;
    RowFeatureBinding binding;

    public FeaturedAdapter(List<WallpaperFeatured> wallpaperFeatured) {
        this.wallpaperFeatured = wallpaperFeatured;
    }

    @NonNull
    @NotNull
    @Override
    public ViewBinding onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        binding = RowFeatureBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewBinding(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewBinding holder, int position) {
        WallpaperFeatured list = wallpaperFeatured.get(position);
        binding.setFeaturelist(list);
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return wallpaperFeatured.size();
    }

    public class ViewBinding extends RecyclerView.ViewHolder {
        public ViewBinding(@NonNull @NotNull RowFeatureBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
