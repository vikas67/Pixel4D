package com.apptech.pixel4d.ui.home;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.apptech.pixel4d.R;
import com.apptech.pixel4d.activity.WallpaperDetailsActivity;
import com.apptech.pixel4d.adapter.FeaturedAdapter;
import com.apptech.pixel4d.adapter.ProductImageAdapter;
import com.apptech.pixel4d.adapter.TagAdapter;
import com.apptech.pixel4d.databinding.FragmentHomeBinding;
import com.apptech.pixel4d.model.home.Tag;
import com.apptech.pixel4d.model.home.Wallpaper;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeFragment extends Fragment implements TagAdapter.TagInterface , ProductImageAdapter.ProductImageClickInterface {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private static final String TAG = "HomeFragment";
    List<Wallpaper> wallpaperlists;
    ProductImageAdapter productImageAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        homeViewModel = ViewModelProviders.of(requireActivity()).get(HomeViewModel.class);
        homeViewModel.mainListMutableLiveData.observe(requireActivity(), mainList -> {
            wallpaperlists = mainList.getWallpapers();

            productImageAdapter = new ProductImageAdapter(mainList.getWallpapers() , this);

            binding.TagRecyclerView.setAdapter(new TagAdapter(mainList.getTags(), this));
            binding.ImageRecyclerView.setAdapter(productImageAdapter);
            binding.FeaturedRecyclerView.setAdapter(new FeaturedAdapter(mainList.getWallpaperFeatured()));
        });

        homeViewModel.getNavigationCategory().observe(requireActivity(), s -> {
            List<Wallpaper> setshortcategory = new ArrayList<>();
            for (int i = 0; i < wallpaperlists.size(); i++) {
                if (s.toLowerCase().trim().equals(wallpaperlists.get(i).getCatName().toLowerCase().trim())) {
                    setshortcategory.add(wallpaperlists.get(i));
                }
            }

            binding.ImageRecyclerView.setAdapter(new ProductImageAdapter(setshortcategory, this));
            productImageAdapter.notifyDataSetChanged();

        });

        homeViewModel.getText().observe(requireActivity(), s -> {
            productImageAdapter.getFilter().filter(s);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.e("dsfn", String.valueOf(item.getItemId()));
        switch(item.getGroupId()){
            case 3:
                Applyfilter(String.valueOf(item.getTitle()),item.getGroupId());
                break;
            case 2:
                Datefilter(String.valueOf(item.getTitle()),item.getGroupId());
                break;
            case 1:
                PriceFilter(String.valueOf(item.getTitle()),item.getGroupId());
                break;

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }



    @Override
    public void onItemClick(Tag taglist) {

    }

    private void Applyfilter(String title,int groupid) {
        if (!title.equals("Color") && groupid==3) {
            List<Wallpaper> filtered = new ArrayList<>();
            homeViewModel.mainListMutableLiveData.observe(requireActivity(), mainList -> {
                for (int i = 0; i < mainList.getWallpapers().size(); i++) {
                    if (mainList.getWallpapers().get(i).getColorCode().equals(title)) {
                        filtered.add(mainList.getWallpapers().get(i));
                    }
                }
                productImageAdapter = new ProductImageAdapter(filtered,this);
                binding.ImageRecyclerView.setAdapter(productImageAdapter);
            });

        }
    }

    private void PriceFilter(String title,int groupid) {
        if (!title.equals("Price") && groupid==1 ) {
            List<Wallpaper> filtered = new ArrayList<>();
            homeViewModel.mainListMutableLiveData.observe(requireActivity(), mainList -> {
                for (int i = 0; i < mainList.getWallpapers().size(); i++) {
                    if (mainList.getWallpapers().get(i).getPaid().toLowerCase().trim().equals(title.toLowerCase().trim())) {
                        filtered.add(mainList.getWallpapers().get(i));
                    }
                }

            });
            productImageAdapter = new ProductImageAdapter(filtered,this);
            binding.ImageRecyclerView.setAdapter(productImageAdapter);
        }
    }
    private void Datefilter(String title,int groupid){
        if (!title.equals("Date Time") && groupid==0 ) {
            List<Wallpaper> filtered = new ArrayList<>();
            homeViewModel.mainListMutableLiveData.observe(requireActivity(), mainList -> {
//                Collections.sort(mainList.getWallpapers(), new Comparator<Notification>() {
//                    DateFormat f = new SimpleDateFormat("dd/MM/yyyy '@'hh:mm a");
//                    @Override
//                    public int compare(Notification lhs, Notification rhs) {
//                        try {
//                            return f.parse(lhs.getDate()).compareTo(f.parse(rhs.getDate()));
//                        } catch (ParseException e) {
//                            throw new IllegalArgumentException(e);
//                        }
//                    }
//                });

            });
        }

    }


    @Override
    public void onItemclick(Wallpaper list) {
        startActivity(new Intent(requireContext(), WallpaperDetailsActivity.class).putExtra("id", String.valueOf(list.getId())));
    }


}


































