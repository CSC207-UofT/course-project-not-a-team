package com.farmgame.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.farmgame.R;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.farmgame.gateway.Initializer;
import com.farmgame.viewModel.LoginViewModel;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;


import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.farmgame.databinding.ActivityLoginBinding;


public class PlayerInfo_Activity extends AppCompatActivity {


    private AppBarConfiguration appBarConfiguration;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
        final LoginViewModel viewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView textView = (TextView) findViewById(R.id.player_name);
        textView.setText(LoginViewModel.getPlayer().getName());
    }
}