package com.example.finalprototype.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalprototype.Schedule;
import com.example.finalprototype.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // final TextView textView = binding.textDashboard;
        // dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());

        // check if meditation block is scheduled
        ImageView meditationBlock = binding.meditationBlock;
        if (pref.getBoolean("5", false))
        {
            meditationBlock.setVisibility(View.VISIBLE);
        }

        ImageView calendar = binding.calendar;
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goScheduleScreen();
            }
        });
        return root;
    }

    public void goScheduleScreen() {
        Intent intent = new Intent(getActivity(), Schedule.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}