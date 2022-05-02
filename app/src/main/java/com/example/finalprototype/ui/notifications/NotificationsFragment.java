package com.example.finalprototype.ui.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalprototype.R;
import com.example.finalprototype.data;
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
        String finish = String.valueOf(data.getCompleted(0)); //default value now in data
        boxFinished.setText(finish);

//        Log.d("finish",finish);

        TextView boxMissed = (TextView) root.findViewById(R.id.B1Missed);
        String miss = String.valueOf(data.getIncomplete(0)); //default value now in data
        boxMissed.setText(miss);
    
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}