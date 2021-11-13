package com.farmgame.Activity.login;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.farmgame.Activity.main.MainActivity;
import com.farmgame.gateway.Initializer;
import com.farmgame.viewModel.MainViewModel;

import androidx.appcompat.app.AppCompatActivity;


import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ui.AppBarConfiguration;

import com.farmgame.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Initializer init = new Initializer(getApplication());
        SQLiteDatabase db = init.getReadableDatabase();


        final MainViewModel viewModel =
                new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.initViewModel(db);


        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        if (viewModel.getPlayer() != null){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

}