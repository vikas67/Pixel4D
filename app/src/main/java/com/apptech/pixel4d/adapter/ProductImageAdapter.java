package com.apptech.pixel4d.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apptech.pixel4d.R;

import org.jetbrains.annotations.NotNull;

public class ProductImageAdapter extends RecyclerView.Adapter<ProductImageAdapter.ViewBinding> {
    @NonNull
    @NotNull
    @Override
    public ViewBinding onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewBinding(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product_img , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewBinding holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class ViewBinding extends RecyclerView.ViewHolder {
        public ViewBinding(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
