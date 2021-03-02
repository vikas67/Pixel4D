package com.apptech.pixel4d.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apptech.pixel4d.databinding.RowProductImgBinding;
import com.apptech.pixel4d.model.home.Wallpaper;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductImageAdapter extends RecyclerView.Adapter<ProductImageAdapter.ViewBinding> implements Filterable {

    List<Wallpaper> wallpapers;
    List<Wallpaper> filterwallpapersall;
    RowProductImgBinding binding;
    private static final String TAG = "ProductImageAdapter";

    public ProductImageAdapter(List<Wallpaper> wallpapers) {
        this.wallpapers = wallpapers;
        this.filterwallpapersall = new ArrayList<>(wallpapers);
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

    @Override
    public Filter getFilter() {
        return metafilter;
    }

    private Filter metafilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Wallpaper> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(filterwallpapersall);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();



                for (Wallpaper item : filterwallpapersall) {

                    Log.e(TAG, "performFiltering: " +filterPattern );
                    Log.e(TAG, "performFiltering: " +item.getMetaTitle());

                    if (item.getMetaTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            wallpapers.clear();
            wallpapers.addAll((Collection<? extends Wallpaper>) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewBinding extends RecyclerView.ViewHolder {
        public ViewBinding(@NonNull @NotNull RowProductImgBinding itemView) {
            super(itemView.getRoot());
        }
    }


}
