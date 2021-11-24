package com.farmgame.frontEnd.login;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.farmgame.frontEnd.main.MainActivity;
import com.farmgame.gateway.Initializer;

import androidx.appcompat.app.AppCompatActivity;


import com.farmgame.databinding.ActivityLoginBinding;
import com.farmgame.viewModel.RegisterViewModel;

/**
 * The launch activity of the app, also responsible for the register of player if the player is not
 * registered.
 */
public class LoginActivity extends AppCompatActivity {

    private SQLiteDatabase db;


    /**
     * Create the activity, initialize viewModel
     */
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

    /**
     * jump to MainActivity if the player is created
     */
    public void jumpToMain(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        db.close();
        startActivity(intent);
        this.finish();
    }

}