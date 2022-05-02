package com.example.finalprototype.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalprototype.Exercise;
import com.example.finalprototype.R;
import com.example.finalprototype.StartNew;
import com.example.finalprototype.data;
import com.example.finalprototype.data_helper;
import com.example.finalprototype.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        */

        Button start = binding.startNew;
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goStartScreen();
            }
        });

        Button box = binding.box;
        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_helper.getData().duration = 5;
                goExerciseScreen();
            }
        });

        return root;
    }

    public void goStartScreen() {
        Intent intent = new Intent(getActivity(), StartNew.class);
        startActivity(intent);
    }

    public void goExerciseScreen() {
        Intent intent = new Intent(getActivity(), Exercise.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}