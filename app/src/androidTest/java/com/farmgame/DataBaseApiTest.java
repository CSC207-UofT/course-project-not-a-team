package com.farmgame;


import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.farmgame.gateway.InitData;
import com.farmgame.viewModel.MainViewModel;

import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DataBaseApiTest extends DatabaseTest{

    @Override
    public void createDb() {
        super.createDb();
        MainViewModel vm = new MainViewModel();
        vm.initDB(db);
        InitData.setDb(db);
        InitData.createPlayer("farmer");
    }
}
