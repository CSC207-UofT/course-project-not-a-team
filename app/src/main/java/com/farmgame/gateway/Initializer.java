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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String createUserTable(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(USER_NAME, TEXT);
        map.put(USER_LEVEL, INT);
        map.put(USER_EXP, INT);
        map.put(USER_MONEY, INT);
        return createTable(USER, map);
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
        return createTable(PLANT, map);
    }

    private String createItemTable(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(ITEM_ID, INT);
        map.put(ITEM_NAME, TEXT);
        return createTable(ITEM, map);
    }


    private String createWarehouseTable(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(WAREHOUSE_TYPE, TEXT);
        map.put(WAREHOUSE_ID, INT);
        map.put(WAREHOUSE_QUANTITY, INT);
        return createTable(WAREHOUSE, map);
    }

    private String createLevelTable(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(LEVEL_LEVEL, INT);
        map.put(LEVEL_EXP, INT);
        return createTable(LEVEL, map);
    }

    public static String createTable(String tableName, HashMap<String, Integer> map){
        return "CREATE TABLE IF NOT EXISTS " +
                tableName + "(" + handlePropertySet(map) + ")";
    }


    private static String handlePropertySet(HashMap<String, Integer> map){
        ArrayList<String> list = new ArrayList<>();
        for (String key: map.keySet()){
            switch (map.get(key)){
                case INT:
                    list.add(key + " INT");
                    break;
                case REAL:
                    list.add(key + " REAL");
                    break;
                case TEXT:
                    list.add(key + " TEXT");
                    break;
                case BOOLEAN:
                    list.add(key + " BOOLEAN");
                    break;
            }
        }

        return String.join(",", list);
    }
}
