package com.farmgame.gateway;


import static com.farmgame.constants.Constants.*;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;


public class PlantDBApi {

    private static SQLiteDatabase db;


    public static void setDb(SQLiteDatabase database){
        db = database;
    }

    public static HashMap<Integer, Integer> getBuyPrice(){
        Cursor cursor = db.query(PLANT, new String[]{PLANT_ID, PLANT_BUY_PRICE}, null, null, null, null, null);
        HashMap<Integer, Integer> map = new HashMap<>();
        while (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex(PLANT_ID));
            int price = cursor.getInt(cursor.getColumnIndex(PLANT_BUY_PRICE));
            map.put(id, price);
        }
        cursor.close();
        return map;
    }

    public static HashMap<Integer, Integer> getSellPrice(){
        Cursor cursor = db.query(PLANT, new String[]{PLANT_ID, PLANT_SELL_PRICE}, null, null, null, null, null);
        HashMap<Integer, Integer> map = new HashMap<>();
        while (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex(PLANT_ID));
            int price = cursor.getInt(cursor.getColumnIndex(PLANT_SELL_PRICE));
            map.put(id, price);
        }
        cursor.close();
        return map;
    }

}