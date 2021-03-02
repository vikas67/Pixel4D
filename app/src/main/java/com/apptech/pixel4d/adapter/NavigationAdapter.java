package com.apptech.pixel4d.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apptech.pixel4d.databinding.RowNavigationLayoutBinding;
import com.apptech.pixel4d.model.home.Category;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {
    Context context;
    List<Category> category;
    RowNavigationLayoutBinding binding;
    NavigationInterface navigationInterface;


    public NavigationAdapter(List<Category> category, NavigationInterface navigationInterface) {
        this.category = category;
        this.navigationInterface = navigationInterface;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        binding = RowNavigationLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        binding.setCategoryClick(navigationInterface);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Category list = category.get(position);
        binding.setCategorylist(list);
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull @NotNull RowNavigationLayoutBinding itemView) {
            super(itemView.getRoot());
        }
    }

    public interface NavigationInterface {
        void navigationItemClick(Category list);
    }


}




















