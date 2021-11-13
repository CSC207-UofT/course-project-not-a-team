package com.farmgame.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.farmgame.R;
import com.farmgame.databinding.FragmentSecondBinding;
import com.farmgame.entity.Player;
import com.farmgame.viewModel.LoginViewModel;

class PlayerInfoFragment extends Fragment {


    private FragmentSecondBinding binding;
    final LoginViewModel viewModel =
            new ViewModelProvider(requireActivity()).get(LoginViewModel.class);


    public PlayerInfoFragment() {
        super(R.layout.player_info_fragment);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();


        Player player = viewModel.getPlayer();
        TextView textView = (TextView) findViewById(R.id.player_name);
        textView.setText(player.getName());

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(view1 -> NavHostFragment.findNavController(PlayerInfoFragment.this)
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