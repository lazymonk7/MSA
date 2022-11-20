package com.example.moneytracking.ui.spending;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.moneytracking.R;
import com.example.moneytracking.databinding.FragmentSpendingListBinding;
import com.example.moneytracking.models.SpendingViewModel;
import com.google.android.material.snackbar.Snackbar;


public class SpendingListFragment extends Fragment {

    private FragmentSpendingListBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSpendingListBinding.inflate(inflater, container, false);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SpendingListFragment.this)
                        .navigate(R.id.action_SpendingListFragment_to_SpendingAddFragment);
            }
        });

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        SpendingViewModel spendingViewModel = ((MainActivity)getActivity()).getSpendingViewModel();
        spendingViewModel.getSpendings().observe(getViewLifecycleOwner(), spendings -> {
            if (spendings != null) {
                Log.i("SpendingListFragment", "spendings + ");
                spendings.forEach(e -> {
                    Log.i("SpendingListFragment", e.toString());
                });
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}