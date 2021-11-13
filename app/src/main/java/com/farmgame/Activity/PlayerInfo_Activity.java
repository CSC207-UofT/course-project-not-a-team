package com.farmgame.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.farmgame.R;


import android.widget.TextView;

import com.farmgame.viewModel.MainViewModel;


import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ui.AppBarConfiguration;

import com.farmgame.databinding.ActivityLoginBinding;


public class PlayerInfo_Activity extends AppCompatActivity {


    private AppBarConfiguration appBarConfiguration;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
        final MainViewModel viewModel =
                new ViewModelProvider(this).get(MainViewModel.class);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView textView = (TextView) findViewById(R.id.player_name);
        textView.setText(viewModel.getPlayer().getName());
    }
}