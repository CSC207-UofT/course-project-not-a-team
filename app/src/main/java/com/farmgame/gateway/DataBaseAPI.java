package com.farmgame.gateway;

import android.database.sqlite.SQLiteDatabase;

import com.farmgame.viewModel.LoginViewModel;

public abstract class DataBaseAPI {

    protected static SQLiteDatabase db;
    protected static LoginViewModel vm;

    public static void setViewModel(LoginViewModel viewModel){
        vm = viewModel;
        db = viewModel.getDB();
    }
}
