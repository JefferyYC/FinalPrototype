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

import com.example.finalprototype.R;
import com.example.finalprototype.StartNew;
import com.example.finalprototype.data;
import com.example.finalprototype.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        //proof of concept for static database
        data d = new data();
        TextView cur = (TextView) root.findViewById(R.id.time1);
        cur.setText(data.getWorkout(1).get(0));
        cur = (TextView) root.findViewById(R.id.duration1);
        cur.setText(data.getWorkout(1).get(1));

        Button start = binding.startNew;
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goStartScreen();
            }
        });

        return root;
    }

    public void goStartScreen() {
        Intent intent = new Intent(getActivity(), StartNew.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}