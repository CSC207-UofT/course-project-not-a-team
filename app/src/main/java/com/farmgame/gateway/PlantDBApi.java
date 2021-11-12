package com.farmgame.gateway;


import static com.farmgame.constants.Constants.*;

import android.database.Cursor;

import com.farmgame.entity.Plants;

import java.util.HashMap;


public class PlantDBApi extends DataBaseAPI {

    public static HashMap<Integer, Integer> getBuyPrice(){
        Cursor cursor = db.query(PLANT, new String[]{PLANT_ID, PLANT_BUY_PRICE}, null, null, null, null, null);
        HashMap<Integer, Integer> map = new HashMap<>();
        while (cursor.moveToNext()){
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
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(PLANT_ID));
            int price = cursor.getInt(cursor.getColumnIndex(PLANT_SELL_PRICE));
            map.put(id, price);
        }
        cursor.close();
        return map;
    }

    public static Plants createPlant(int id){
        Cursor cursor = db.query(
                PLANT, new String[]{PLANT_SELL_PRICE, PLANT_MATURE_NAME},
                PLANT_ID + " = ?", new String[]{String.valueOf(id)},
                null, null, null, null);
        cursor.moveToFirst();

        int price = cursor.getInt(cursor.getColumnIndex(PLANT_SELL_PRICE));
        String name = cursor.getString(cursor.getColumnIndex(PLANT_MATURE_NAME));


        cursor.close();

        return new Plants(name, price, id);
    }

}