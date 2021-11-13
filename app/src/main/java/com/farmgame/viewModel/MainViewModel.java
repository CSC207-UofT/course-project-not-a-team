package com.farmgame.viewModel;

import android.database.sqlite.SQLiteDatabase;

import androidx.lifecycle.ViewModel;

import com.farmgame.controller.StoreSystem;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Player;
import com.farmgame.entity.Store;
import com.farmgame.entity.Warehouse;
import com.farmgame.gateway.PlantDBApi;
import com.farmgame.gateway.PlayerDBApi;
import com.farmgame.gateway.StoreDBApi;
import com.farmgame.gateway.WarehouseDBApi;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;

import java.util.HashMap;
import java.util.Objects;

public class MainViewModel extends ViewModel {

    private SQLiteDatabase db;

    private PlayerManager pm;
    private WarehouseManager wm;
    private HashMap<Integer, LandManager> lmMap;

    private StoreSystem ss;

    public String name;

    public void initViewModel(SQLiteDatabase database){
        db = database;
        initDatabaseAPIs();
        initWhenHasPlayer();

    }

    public void initWhenHasPlayer(){
        addSystems();
    }

    private void addManagers(){
        pm = new PlayerManager(PlayerDBApi.getPlayer());
        name = getPlayer().getName();
        wm = new WarehouseManager(WarehouseDBApi.getWarehouse());
    }

    private void addSystems(){
        addManagers();

        Store store = new Store(StoreDBApi.getPlantList(), StoreDBApi.getSeedList(), StoreDBApi.getItemList());
        ss = new StoreSystem(store, pm, wm);
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

    public LandEntity getLand(int landIndex){
        return Objects.requireNonNull(lmMap.get(landIndex)).getLand();
    }


    private void initDatabaseAPIs(){
        PlayerDBApi.setViewModel(this);
        WarehouseDBApi.setViewModel(this);
        PlantDBApi.setViewModel(this);
    }

}
