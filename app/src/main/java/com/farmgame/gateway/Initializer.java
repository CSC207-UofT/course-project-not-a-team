package com.farmgame.gateway;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

import static com.farmgame.constants.Constants.*;

public class Initializer extends SQLiteOpenHelper {



    public Initializer(@Nullable Context context) {

        super(context, "farm.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUserTable());
        db.execSQL(createPlantTable());
        db.execSQL(createItemTable());
        db.execSQL(createWarehouseTable());
        db.execSQL(createLevelTable());
        db.execSQL(createLandTable());
        db.execSQL(createStoreTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String createUserTable(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(PLAYER_NAME, TEXT);
        map.put(PLAYER_LEVEL, INT);
        map.put(PLAYER_EXP, INT);
        map.put(PLAYER_MONEY, INT);
        return createTable(PLAYER, map , PLAYER_NAME);
    }

    private String createPlantTable(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(PLANT_SEED_NAME, TEXT);
        map.put(PLANT_MATURE_NAME, TEXT);
        map.put(PLANT_TIME, INT);
        map.put(PLANT_ID, INT);
        map.put(PLANT_BUY_PRICE, INT);
        map.put(PLANT_SELL_PRICE, INT);
        map.put(PLANT_EXP, INT);
        map.put(PLANT_UNLOCK_LEVEL, INT);
        return createTable(PLANT, map, PLANT_ID);
    }

    private String createItemTable(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(ITEM_ID, INT);
        map.put(ITEM_NAME, TEXT);
        map.put(ITEM_TYPE, TEXT);
        return createTable(ITEM, map, ITEM_ID);
    }


    private String createWarehouseTable(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(WAREHOUSE_TYPE, TEXT);
        map.put(WAREHOUSE_ID, INT);
        map.put(WAREHOUSE_QUANTITY, INT);
        return createTable(WAREHOUSE, map, WAREHOUSE_ID);
    }

    private String createLevelTable(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(LEVEL_LEVEL, INT);
        map.put(LEVEL_EXP, INT);
        map.put(LEVEL_CAPACITY, INT);
        map.put(LEVEL_LAND_MAX, INT);
        return createTable(LEVEL, map, LEVEL_LEVEL);
    }

    private String createLandTable(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(LAND_INDEX, INT);
        map.put(LAND_PRICE, INT);
        map.put(LAND_LOCK_STATUS, BOOLEAN);
        map.put(LAND_PLANT, INT);
        map.put(LAND_WATER_TIME, INT);
        map.put(LAND_FERTILIZE_TIME, INT);
        map.put(LAND_STAGE, INT);
        return createTable(LAND, map, LAND_INDEX);
    }

    private String createStoreTable(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(STORE_ID, INT);
        map.put(STORE_TYPE, TEXT);
        map.put(STORE_UNLOCK_LEVEL, INT);
        return createTable(STORE, map, STORE_ID);
    }

    private String createTable(String tableName, HashMap<String, Integer> map,
                                      String primaryKey){
        return "CREATE TABLE IF NOT EXISTS " +
                tableName + "(" + handlePropertySet(map, primaryKey) + ")";
    }

    private String handlePropertySet(HashMap<String, Integer> map, String primaryKey){
        ArrayList<String> list = new ArrayList<>();
        String primary = null;
        for (String key: map.keySet()){
            switch (map.get(key)){
                case INT:
                    list.add(key + " INT");
                    break;
                case TEXT:
                    list.add(key + " TEXT");
                    break;
                case BOOLEAN:
                    list.add(key + " BOOLEAN");
                    break;
            }
            if (key.equals(primaryKey)){
                primary = "PRIMARY KEY (" + key + ")";
            }
        }

        if (primary != null){
            list.add(primary);
        }


        return String.join(", ", list);
    }

    private void initDataInsertion(){

    }

}
