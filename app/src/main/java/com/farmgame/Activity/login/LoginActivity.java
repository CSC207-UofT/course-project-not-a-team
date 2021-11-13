package com.farmgame.Activity.login;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.farmgame.Activity.main.MainActivity;
import com.farmgame.gateway.Initializer;

import androidx.appcompat.app.AppCompatActivity;


import com.farmgame.databinding.ActivityLoginBinding;
import com.farmgame.viewModel.RegisterViewModel;

public class LoginActivity extends AppCompatActivity {

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Initializer init = new Initializer(getApplication());
        db = init.getReadableDatabase();


        RegisterViewModel viewModel = new RegisterViewModel(db);


        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        if (viewModel.hasPlayer()){
            jumpToMain();
        }

    }

    public void jumpToMain(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        db.close();
        startActivity(intent);
        this.finish();
    }

}