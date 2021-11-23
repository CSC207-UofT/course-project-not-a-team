package com.farmgame.frontEnd.login;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.farmgame.databinding.FragmentRegisterBinding;
import com.farmgame.gateway.InitData;

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




        binding.register.setOnClickListener(v -> {
            if (binding.username.getText().toString().length() > 0){
                binding.register.setClickable(false);
                InitData.createPlayer(binding.username.getText().toString());
                ((LoginActivity) requireActivity()).jumpToMain();
            } else { Toast.makeText(requireActivity(), "please enter your player name", Toast.LENGTH_SHORT).show(); }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}