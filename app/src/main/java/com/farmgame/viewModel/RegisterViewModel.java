package com.farmgame.viewModel;

import android.database.sqlite.SQLiteDatabase;

import androidx.lifecycle.ViewModel;

import com.farmgame.gateway.InitData;

public class RegisterViewModel extends ViewModel {

    public RegisterViewModel(SQLiteDatabase database){
        InitData.setDb(database);
    }

    public boolean hasPlayer(){
        return InitData.hasPlayer();
    }
}
