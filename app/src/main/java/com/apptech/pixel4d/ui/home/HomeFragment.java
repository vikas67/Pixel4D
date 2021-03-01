package com.apptech.pixel4d.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.apptech.pixel4d.R;
import com.apptech.pixel4d.adapter.FeaturedAdapter;
import com.apptech.pixel4d.adapter.TagAdapter;
import com.apptech.pixel4d.databinding.FragmentHomeBinding;
import com.apptech.pixel4d.ui.productimage.ProductImageFragment;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment implements TagAdapter.TagInterface {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.FeaturedRecyclerView.setAdapter(new FeaturedAdapter());
        binding.TagRecyclerView.setAdapter(new TagAdapter());


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void lodaFragment(Fragment fragment) {
        if (fragment != null)
            getChildFragmentManager().beginTransaction().replace(R.id.mainFragmentLayout, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onItemClick() {
        lodaFragment(new ProductImageFragment());
    }

    @Override
    public void onStart() {
        super.onStart();
        lodaFragment(new ProductImageFragment());
    }
}


































