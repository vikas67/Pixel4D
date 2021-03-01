package com.apptech.pixel4d.ui.productimage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.apptech.pixel4d.adapter.ProductImageAdapter;
import com.apptech.pixel4d.databinding.FragmentProductImageBinding;

import org.jetbrains.annotations.NotNull;


public class ProductImageFragment extends Fragment {

    FragmentProductImageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentProductImageBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ImageRecyclerView.setAdapter(new ProductImageAdapter());
    }
}