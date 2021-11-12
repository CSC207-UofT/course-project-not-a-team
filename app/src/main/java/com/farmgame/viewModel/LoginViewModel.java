package com.farmgame.viewModel;

import android.database.sqlite.SQLiteDatabase;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.farmgame.controller.LandActivitySystem.LandHarvestPlantSystem;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Player;
import com.farmgame.entity.Warehouse;
import com.farmgame.gateway.PlantDBApi;
import com.farmgame.gateway.PlayerDBApi;
import com.farmgame.gateway.WarehouseDBApi;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;

import java.util.HashMap;

public class LoginViewModel extends ViewModel {

    private SQLiteDatabase db;

    private PlayerManager pm;
    private WarehouseManager wm;
    private HashMap<Integer, LandManager> lmMap;

    public void initViewModel(SQLiteDatabase database){
        db = database;
        initDatabaseAPIs();
        if (PlayerDBApi.hasPlayer()){
            addManagers();
        }
    }

    public void addManagers(){
        pm = new PlayerManager(PlayerDBApi.getPlayer());
        wm = new WarehouseManager(WarehouseDBApi.getWarehouse());
    }

    public SQLiteDatabase getDB(){
        return db;
    }

    public Player getPlayer(){
        return pm.getPlayer();
    }

    public Warehouse getWarehouse(){
            return wm.getWarehouse();
    }


    private void initDatabaseAPIs(){
        PlayerDBApi.setViewModel(this);
        WarehouseDBApi.setViewModel(this);
        PlantDBApi.setViewModel(this);
    }

}
