package com.farmgame.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.farmgame.R;
import com.farmgame.databinding.FragmentSecondBinding;
import com.farmgame.viewModel.LoginViewModel;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    final LoginViewModel viewModel =
            new ViewModelProvider(requireActivity()).get(LoginViewModel.class);

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(view1 -> NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_SecondFragment_to_RegisterFragment));
        final LoginViewModel viewModel =
                new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}