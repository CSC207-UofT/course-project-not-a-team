package com.farmgame.Activity.login;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.farmgame.databinding.FragmentRegisterBinding;
import com.farmgame.gateway.InitData;
import com.farmgame.gateway.PlayerDBApi;
import com.farmgame.viewModel.MainViewModel;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final MainViewModel viewModel =
                new ViewModelProvider(requireActivity()).get(MainViewModel.class);


        Context that = this.getActivity();


        binding.register.setOnClickListener(v -> {
            if (binding.username.getText().toString().length() > 0){
                InitData.createPlayer(binding.username.getText().toString());
                viewModel.initWhenHasPlayer();
            } else { Toast.makeText(that, "please enter your player name", Toast.LENGTH_SHORT).show(); }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}