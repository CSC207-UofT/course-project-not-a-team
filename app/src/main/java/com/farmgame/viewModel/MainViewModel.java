package com.farmgame.viewModel;

import android.database.sqlite.SQLiteDatabase;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.farmgame.viewModel.LandActivitySystem.LandChangeStatusSystem;
import com.farmgame.viewModel.LandActivitySystem.LandHarvestPlantSystem;
import com.farmgame.viewModel.LandActivitySystem.LandManagePlantStatusSystem;
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

/***
 * the android viewModel for the main activity of our app
 */
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

    /***
     * initialize the database, entities created from database, managers and systems
     * @param database our database
     */
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

    /***
     * initialize the database
     * @param database our database
     */
    public void initDB(SQLiteDatabase database){
        db = database;
        initDatabaseAPIs();
    }


    /***
     *
     * @return the store system
     */
    public StoreSystem getStoreSystem(){
        return ss;
    }

    /***
     *
     * @return LandHarvestPlantSystem
     */
    public LandHarvestPlantSystem getLHS(){
        return lhs;
    }

    /***
     *
     * @return LandChangeStatusSystem
     */
    public LandChangeStatusSystem getLCS(){
        return lcs;
    }

    /***
     *
     * @return LandManagePlantStatusSystem
     */
    public LandManagePlantStatusSystem getLMS(){
        return lms;
    }


    /***
     * notify the UI to update player
     */
    public void updatePlayer(){
        playerData.setValue(this.playerData.getValue());
    }

    /***
     * notify the UI to update warehouse
     */
    public void updateWarehouse(){
        warehouseData.setValue(warehouseData.getValue());
    }

    /***
     * notify the UI to update land
     */
    public void updateLand(){
        landMapData.setValue(landMapData.getValue());
    }

    /***
     * notify the UI to update store - here we created a new store
     */
    public void updateStore(){
        storeData.setValue(StoreDBApi.getStore());
        ss.setStore(storeData.getValue());
    }

    /***
     *
     * @return the database instance
     */
    public SQLiteDatabase getDB(){
        return db;
    }

    /***
     *
     * @return the player instance
     */
    public Player getPlayer(){
        return playerData.getValue();
    }

    /***
     *
     * @return the warehouse instance
     */
    public Warehouse getWarehouse(){
            return warehouseData.getValue();
    }

    /***
     *
     * @param landIndex index of the land
     * @return the land of the index
     */
    public LandEntity getLand(int landIndex){
        return Objects.requireNonNull(landMapData.getValue()).get(landIndex);
    }


    /***
     * set viewModel to the database API, since the method is static, all database APIs will set
     * when we call it on one of them
     */
    private void initDatabaseAPIs(){
        PlayerDBApi.setViewModel(this);
    }

    /***
     *
     * @return convert arraylist of arraylist of item into that of store able
     */
    public ArrayList<ArrayList<StoreAble>> convertItem(){
        ArrayList<ArrayList<StoreAble>> result = new ArrayList<>();
        for (ArrayList<Item> list : getWarehouse().getItemInventory().values()){
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    /***
     *
     * @return convert arraylist of arraylist of plant into that of store able
     */
    public ArrayList<ArrayList<StoreAble>> convertPlant(){
        ArrayList<ArrayList<StoreAble>> result = new ArrayList<>();
        for (ArrayList<Plants> list : getWarehouse().getPlantInventory().values()){
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    /***
     *
     * @return convert arraylist of arraylist of seed into that of store able
     */
    public ArrayList<ArrayList<StoreAble>> convertSeed(){
        ArrayList<ArrayList<StoreAble>> result = new ArrayList<>();
        for (ArrayList<Seeds> list : getWarehouse().getSeedInventory().values()){
            result.add(new ArrayList<>(list));
        }
        return result;
    }

}
