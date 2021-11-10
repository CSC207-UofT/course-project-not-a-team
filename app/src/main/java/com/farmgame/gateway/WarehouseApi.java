package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.farmgame.entity.Plants;

import java.util.ArrayList;
import java.util.HashMap;

public class WarehouseApi {

    private static SQLiteDatabase db;


    public static void setDb(SQLiteDatabase database){
        db = database;
    }

    public static HashMap<Integer, ArrayList<Plants>> getPlantsMap(){
        Cursor cursor = db.query(WAREHOUSE + " NATURAL JOIN " + PLANT, new String[]{"*"},
                WAREHOUSE_TYPE + " =?", new String[]{Type_PLANT}, null, null, null);
        HashMap<Integer, ArrayList<Plants>> map = new HashMap<>();

        while (cursor.moveToFirst()){
            ArrayList<Plants> list = new ArrayList<>();
            int quantity = cursor.getInt(cursor.getColumnIndex(WAREHOUSE_QUANTITY));
            String name = cursor.getString(cursor.getColumnIndex(PLANT_NAME));
            int time = cursor.getInt(cursor.getColumnIndex(PLANT_TIME));
            int id = cursor.getInt(cursor.getColumnIndex(PLANT_ID));
            int buying = cursor.getInt(cursor.getColumnIndex(PLANT_BUY_PRICE));
            int selling = cursor.getInt(cursor.getColumnIndex(PLANT_SELL_PRICE));
            int exp = cursor.getInt(cursor.getColumnIndex(PLANT_EXP));

            for (int i = 0; i < quantity; i ++){
                list.add(new Plants(name, time, id, buying, selling, exp));
            }
            map.put(id, list);
        }
        cursor.close();
        return map;
    }


}