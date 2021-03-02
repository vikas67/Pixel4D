package com.apptech.pixel4d.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apptech.pixel4d.databinding.RowTagBinding;
import com.apptech.pixel4d.model.home.Tag;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewBinding> {

    List<Tag> tagslist;
    TagInterface tagInterface;
    RowTagBinding binding;

    public TagAdapter(List<Tag> tags, TagInterface tagInterface) {
        this.tagslist = tags;
        this.tagInterface = tagInterface;
    }

    @NonNull
    @NotNull
    @Override
    public ViewBinding onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        binding = RowTagBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        binding.setTagclick(tagInterface);
        return new ViewBinding(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewBinding holder, int position) {
        Tag list = tagslist.get(position);
        binding.setTaglist(list);
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return tagslist.size();
    }

    public class ViewBinding extends RecyclerView.ViewHolder {
        public ViewBinding(@NonNull @NotNull RowTagBinding itemView) {
            super(itemView.getRoot());
        }
    }

    public interface TagInterface {
        void onItemClick(Tag taglist);
    }


}

























