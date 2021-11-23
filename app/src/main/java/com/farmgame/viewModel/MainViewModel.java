package com.farmgame.viewModel;

import android.database.sqlite.SQLiteDatabase;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.farmgame.controller.LandActivitySystem.LandChangeStatusSystem;
import com.farmgame.controller.LandActivitySystem.LandHarvestPlantSystem;
import com.farmgame.controller.LandActivitySystem.LandManagePlantStatusSystem;
import com.farmgame.controller.StoreSystem;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Player;
import com.farmgame.entity.Seeds;
import com.farmgame.entity.Store;
import com.farmgame.entity.Warehouse;
import com.farmgame.gateway.LandDBApi;
import com.farmgame.gateway.PlantDBApi;
import com.farmgame.gateway.PlayerDBApi;
import com.farmgame.gateway.StoreDBApi;
import com.farmgame.gateway.WarehouseDBApi;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.StoreAble;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainViewModel extends ViewModel {

    private SQLiteDatabase db;


    private StoreSystem ss;
    private LandChangeStatusSystem lcs;
    private LandHarvestPlantSystem lhs;
    private LandManagePlantStatusSystem lms;

    public final MutableLiveData<Player> playerData = new MutableLiveData<>();
    public final MutableLiveData<Warehouse> warehouseData = new MutableLiveData<>();
    public final MutableLiveData<HashMap<Integer, LandEntity>> landMapData = new MutableLiveData<>();
    public final MutableLiveData<Store> storeData = new MutableLiveData<>();

    public void initViewModel(SQLiteDatabase database){
        initDB(database);

        playerData.setValue(PlayerDBApi.getPlayer());
        warehouseData.setValue(WarehouseDBApi.getWarehouse());
        landMapData.setValue(new HashMap<>());
        storeData.setValue(StoreDBApi.getStore());
        for (LandEntity land : LandDBApi.getLandList()){
            Objects.requireNonNull(landMapData.getValue()).put(land.getIndex(), land);
        }

        LandManager lm = new LandManager(landMapData.getValue());

        PlayerManager pm = new PlayerManager(playerData.getValue(), PlayerDBApi.getExpTable());

        WarehouseManager wm = new WarehouseManager(warehouseData.getValue());

        lcs = new LandChangeStatusSystem(lm, pm);
        lhs = new LandHarvestPlantSystem(wm, lm, pm);
        lms = new LandManagePlantStatusSystem(wm, lm);

        ss = new StoreSystem(storeData.getValue(), pm, wm);

    }

    public void initDB(SQLiteDatabase database){
        db = database;
        initDatabaseAPIs();
    }


    public StoreSystem getStoreSystem(){
        return ss;
    }

    public LandHarvestPlantSystem getLHS(){
        return lhs;
    }

    public LandChangeStatusSystem getLCS(){
        return lcs;
    }

    public LandManagePlantStatusSystem getLMS(){
        return lms;
    }


    public void updatePlayer(){
        playerData.setValue(this.playerData.getValue());
    }

    public void updateWarehouse(){
        warehouseData.setValue(warehouseData.getValue());
    }

    public void updateLand(){
        landMapData.setValue(landMapData.getValue());
    }

    public void updateStore(){
        storeData.setValue(StoreDBApi.getStore());
        ss.setStore(storeData.getValue());
    }

    public SQLiteDatabase getDB(){
        return db;
    }

    public Player getPlayer(){
        return playerData.getValue();
    }

    public Warehouse getWarehouse(){
            return warehouseData.getValue();
    }

    public LandEntity getLand(int landIndex){
        return Objects.requireNonNull(landMapData.getValue()).get(landIndex);
    }


    private void initDatabaseAPIs(){
        PlayerDBApi.setViewModel(this);
        WarehouseDBApi.setViewModel(this);
        PlantDBApi.setViewModel(this);
    }

    public ArrayList<ArrayList<StoreAble>> convertItem(){
        ArrayList<ArrayList<StoreAble>> result = new ArrayList<>();
        for (ArrayList<Item> list : getWarehouse().getItemInventory().values()){
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    public ArrayList<ArrayList<StoreAble>> convertPlant(){
        ArrayList<ArrayList<StoreAble>> result = new ArrayList<>();
        for (ArrayList<Plants> list : getWarehouse().getPlantInventory().values()){
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    public ArrayList<ArrayList<StoreAble>> convertSeed(){
        ArrayList<ArrayList<StoreAble>> result = new ArrayList<>();
        for (ArrayList<Seeds> list : getWarehouse().getSeedInventory().values()){
            result.add(new ArrayList<>(list));
        }
        return result;
    }

}
