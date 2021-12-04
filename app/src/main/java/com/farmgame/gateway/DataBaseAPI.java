package com.farmgame.gateway;

import android.database.sqlite.SQLiteDatabase;

import com.farmgame.viewModel.MainViewModel;

/***
 * The parent class of all database gateways
 * holds a database instance and the view model
 */
public abstract class DataBaseAPI {

    protected static SQLiteDatabase db;
    protected static MainViewModel vm;

    public static void setViewModel(MainViewModel viewModel){
        vm = viewModel;
        db = viewModel.getDB();
    }
}
