package com.apptech.pixel4d.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apptech.pixel4d.R;

import org.jetbrains.annotations.NotNull;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.ViewBinding> {

    Context context;

    @NonNull
    @NotNull
    @Override
    public ViewBinding onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewBinding(LayoutInflater.from(context).inflate(R.layout.row_feature, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewBinding holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewBinding extends RecyclerView.ViewHolder {
        public ViewBinding(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
