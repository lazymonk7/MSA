package com.example.moneytracking.ui.spending;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.moneytracking.R;
import com.example.moneytracking.databinding.FragmentSpendingAddBinding;
import com.example.moneytracking.entities.Spending;


public class SpendingAddFragment extends Fragment {

    private FragmentSpendingAddBinding binding;
    private final String addSpendingTag = "SpendingAddFragment";


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSpendingAddBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SpendingAddFragment.this)
                        .navigate(R.id.action_SpendingAddFragment_to_SpendingListFragment);
            }
        });

        binding.btnAddSpending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Spending sp = new Spending(binding.tiSpendingTitle.getText().toString(), Integer.parseInt(binding.tiSpendingCost.getText().toString()));
                    Log.i(addSpendingTag, sp.toString());
                    Log.i(addSpendingTag, binding.tiSpendingTitle.getText().toString());
                    Log.i(addSpendingTag, binding.tiSpendingCost.getText().toString());
                    // TODO: Persist
                } catch (NullPointerException | NumberFormatException  | Spending.InvalidSpendingException e) {
                    Log.e(addSpendingTag, e.toString());
                    Toast toast = Toast.makeText(view.getContext(), "unable to create spending item", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}