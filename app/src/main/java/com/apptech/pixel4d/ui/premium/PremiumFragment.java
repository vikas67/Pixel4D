package com.apptech.pixel4d.ui.premium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apptech.pixel4d.R;

public class PremiumFragment extends Fragment {

    private PremiumViewModel mViewModel;
    TextView title;
    ImageView close;

    public static PremiumFragment newInstance() {
        return new PremiumFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.premium_fragment, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        title= view.findViewById(R.id.title);
        close= view.findViewById(R.id.close);
        int[] color = {getResources().getColor(R.color.gadient_start),getResources().getColor(R.color.gadient_end)};
        float[] position = {0, 1};
        Shader.TileMode tile_mode = Shader.TileMode.MIRROR; // or TileMode.REPEAT;
        LinearGradient lin_grad = new LinearGradient(0, 0, 0, 50,color,position, tile_mode);
        Shader shader_gradient = lin_grad;
        title.getPaint().setShader(shader_gradient);
        close.setOnClickListener(v -> {
            NavController navController= Navigation.findNavController(view);
//            navController.navigate();
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PremiumViewModel.class);
        // TODO: Use the ViewModel
    }


}