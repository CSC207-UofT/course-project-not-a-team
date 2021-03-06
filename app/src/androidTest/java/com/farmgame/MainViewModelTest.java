package com.farmgame;

import com.farmgame.viewModel.MainViewModel;

import org.junit.Before;
import org.junit.Test;

public class MainViewModelTest extends DatabaseTest{

    MainViewModel vm;

    @Override
    public void createDb() {
        super.createDb();
        vm = new MainViewModel();
    }

    @Test
    public void TestSetDB(){
        vm.initDB(db);
        assert vm.getDB() == db;
    }

}
