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

        db.execSQL(createUser());
        db.execSQL(createPlant());
        db.execSQL(createWarehouse());
        db.execSQL(createLevel());


        // plants, warehouse, store
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String createUser(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("name", TEXT);
        map.put("pwd", TEXT);
        map.put("level", INT);
        map.put("exp", INT);
        return createTable("User", map);
    }

    private String createPlant(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("name", TEXT);
        map.put("time", TEXT);
        map.put("buyPrice", INT);
        map.put("sellPrice", INT);
        map.put("exp", INT);
        return createTable("Plant", map);
    }

    private String createWarehouse(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("type", TEXT);
        map.put("id", INT);
        map.put("quantity", INT);
        return createTable("Warehouse", map);
    }

    private String createLevel(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("level", INT);
        map.put("exp", INT);
        return createTable("LevelUpExp", map);
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
                case BOOLEAN:
                    list.add(key + " BOOLEAN");
            }
        }

        return String.join(",", list);
    }
}
