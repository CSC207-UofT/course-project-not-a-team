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

    private PlayerManager pm;
    private WarehouseManager wm;
    private HashMap<Integer, LandManager> lmMap = new HashMap<>();

    private StoreSystem ss;
    private HashMap<Integer, LandChangeStatusSystem> lcs = new HashMap<>();
    private HashMap<Integer, LandHarvestPlantSystem> lhs = new HashMap<>();
    private HashMap<Integer, LandManagePlantStatusSystem> lms = new HashMap<>();

    public final MutableLiveData<Player> playerData = new MutableLiveData<>();
    public final MutableLiveData<Warehouse> warehouseData = new MutableLiveData<>();

    public void initViewModel(SQLiteDatabase database){
        db = database;
        initDatabaseAPIs();

        Player player = updatePlayer();

        pm = new PlayerManager(player);

        Warehouse warehouse = updateWarehouse();

        wm = new WarehouseManager(warehouse);

        ArrayList<LandEntity> landList = LandDBApi.getLandList();
        Store store = StoreDBApi.getStore();

        ss = new StoreSystem(store, pm, wm);

        for (LandEntity land : landList){
            int index = land.getIndex();
            LandManager lm = new LandManager(land);
            lmMap.put(index, lm);
            lcs.put(index, new LandChangeStatusSystem(lm, pm));
            lhs.put(index, new LandHarvestPlantSystem(wm, lm, pm));
            lms.put(index, new LandManagePlantStatusSystem(wm, lm));
        }

    }



    public StoreSystem getStoreSystem(){
        return ss;
    }

    public LandHarvestPlantSystem getLHS(int index){
        return lhs.get(index);
    }


    public Player updatePlayer(){
        Player player = PlayerDBApi.getPlayer();
        this.playerData.setValue(player);
        return player;
    }

    public Warehouse updateWarehouse(){
        Warehouse warehouse  = WarehouseDBApi.getWarehouse();
        this.warehouseData.setValue(warehouse);
        return warehouse;
    }

    public void updateLand(int landIndex){

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
