package com.apptech.pixel4d.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.apptech.pixel4d.adapter.FeaturedAdapter;
import com.apptech.pixel4d.adapter.ProductImageAdapter;
import com.apptech.pixel4d.adapter.TagAdapter;
import com.apptech.pixel4d.databinding.FragmentHomeBinding;
import com.apptech.pixel4d.model.home.Tag;
import com.apptech.pixel4d.model.home.Wallpaper;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomeFragment extends Fragment implements TagAdapter.TagInterface {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private static final String TAG = "HomeFragment";
    List<Wallpaper> wallpaperlists;
    Set set = new HashSet();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeViewModel = ViewModelProviders.of(requireActivity()).get(HomeViewModel.class);
        homeViewModel.mainListMutableLiveData.observe(requireActivity(), mainList -> {
            wallpaperlists = mainList.getWallpapers();
            binding.TagRecyclerView.setAdapter(new TagAdapter(mainList.getTags(), this));
            binding.ImageRecyclerView.setAdapter(new ProductImageAdapter(mainList.getWallpapers()));
            binding.FeaturedRecyclerView.setAdapter(new FeaturedAdapter(mainList.getWallpaperFeatured()));
        });

        homeViewModel.getText().observe(requireActivity(), s -> {
//            set.add(s);
//            Collections.sort();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


 /*   private void lodaFragment(Fragment fragment) {
        if (fragment != null)
            getChildFragmentManager().beginTransaction().replace(R.id.mainFragmentLayout, fragment).addToBackStack(null).commit();
    }
 */


//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.action_filter:
//
//                break;
//            case R.id.action_search:
//
//                break;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    @Override
    public void onItemClick(Tag taglist) {

    }
}


































