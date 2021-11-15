package com.farmgame.gateway;

import android.database.sqlite.SQLiteDatabase;

import com.farmgame.viewModel.MainViewModel;

public abstract class DataBaseAPI {

    protected static SQLiteDatabase db;
    protected static MainViewModel vm;

    public static void setViewModel(MainViewModel viewModel){
        vm = viewModel;
        db = viewModel.getDB();
    }
}
