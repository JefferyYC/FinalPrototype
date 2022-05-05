package com.example.finalprototype.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalprototype.Goals;
import com.example.finalprototype.R;
import com.example.finalprototype.StartNew;
import com.example.finalprototype.data;
import com.example.finalprototype.data_helper;
import com.example.finalprototype.databinding.FragmentNotificationsBinding;


public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        TextView boxFinished = (TextView) root.findViewById(R.id.B1Finished);
        String finish = String.valueOf(data_helper.getData().getCompleted()); //default value now in data
        boxFinished.setText(finish);

//        Log.d("finish",finish);

        TextView prog = (TextView) root.findViewById(R.id.prog);
        prog.setText((8 + data_helper.getData().getCompleted()) + "/" + data_helper.getData().getGoal());

        ProgressBar p = root.findViewById(R.id.progressBar);
        p.setProgress(8 + data_helper.getData().getCompleted());
        p.setMax(data_helper.getData().getGoal());

        TextView boxMissed = (TextView) root.findViewById(R.id.B1Missed);
        String miss = String.valueOf(data_helper.getData().getIncomplete()); //default value now in data
        boxMissed.setText(miss);

        ImageView pref = root.findViewById(R.id.pref);
        pref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goGoalScreen();
            }
        });
    
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void goGoalScreen() {
        Intent intent = new Intent(getActivity(), Goals.class);
        startActivity(intent);
    }
}