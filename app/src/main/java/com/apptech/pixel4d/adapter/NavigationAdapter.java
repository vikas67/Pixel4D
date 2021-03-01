package com.apptech.pixel4d.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apptech.pixel4d.R;
import com.apptech.pixel4d.model.NavigationList;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NavigationAdapter  extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {
    Context context;
    List<NavigationList> list;

    public NavigationAdapter(Context context, List<NavigationList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_navigation_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
