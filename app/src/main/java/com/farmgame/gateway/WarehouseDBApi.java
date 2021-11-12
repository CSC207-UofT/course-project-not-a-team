package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

import android.database.Cursor;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Item.WateringCan;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;

import java.util.ArrayList;
import java.util.HashMap;

public class WarehouseDBApi extends DataBaseAPI {

    public static HashMap<Integer, ArrayList<Plants>> getPlantsMap(){
        Cursor cursor = db.query(
                WAREHOUSE + " NATURAL JOIN " + PLANT,
                new String[]{WAREHOUSE_QUANTITY, PLANT_MATURE_NAME, PLANT_ID, PLANT_SELL_PRICE},
                WAREHOUSE_TYPE + " =?",
                new String[]{TYPE_PLANT},
                null,
                null,
                null);

        HashMap<Integer, ArrayList<Plants>> map = new HashMap<>();

        while (cursor.moveToFirst()){
            ArrayList<Plants> list = new ArrayList<>();
            int quantity = cursor.getInt(cursor.getColumnIndex(WAREHOUSE_QUANTITY));
            String name = cursor.getString(cursor.getColumnIndex(PLANT_MATURE_NAME));
            int id = cursor.getInt(cursor.getColumnIndex(PLANT_ID));
            int selling = cursor.getInt(cursor.getColumnIndex(PLANT_SELL_PRICE));

            for (int i = 0; i < quantity; i ++){
                list.add(new Plants(name, selling, selling));
            }
            map.put(id, list);
        }
        cursor.close();
        return map;
    }

    public static HashMap<Integer, ArrayList<Seeds>> getSeedsMap(){
        Cursor cursor = db.query(
                WAREHOUSE + " NATURAL JOIN " + PLANT,
                new String[]{WAREHOUSE_QUANTITY, PLANT_SEED_NAME,
                        PLANT_TIME, PLANT_BUY_PRICE, PLANT_EXP, PLANT_ID},
                WAREHOUSE_TYPE + " = ?",
                new String[]{TYPE_SEED},
                null,
                null,
                null);

        HashMap<Integer, ArrayList<Seeds>> map = new HashMap<>();

        while (cursor.moveToFirst()){
            ArrayList<Seeds> list = new ArrayList<>();
            int quantity = cursor.getInt(cursor.getColumnIndex(WAREHOUSE_QUANTITY));
            String name = cursor.getString(cursor.getColumnIndex(PLANT_SEED_NAME));
            int time = cursor.getInt(cursor.getColumnIndex(PLANT_TIME));
            int buying = cursor.getInt(cursor.getColumnIndex(PLANT_BUY_PRICE));
            int exp = cursor.getInt(cursor.getColumnIndex(PLANT_EXP));
            int id = cursor.getInt(cursor.getColumnIndex(PLANT_ID));

            for (int i = 0; i < quantity; i ++){
                list.add(new Seeds(name, time, buying, exp, id));
            }

            map.put(id, list);
        }
        cursor.close();
        return map;
    }

    public static HashMap<Integer, ArrayList<Item>> getItemsMap(){
        Cursor cursor = db.query(
                WAREHOUSE + " NATURAL JOIN " + ITEM,
                new String[]{WAREHOUSE_QUANTITY, ITEM_ID, ITEM_NAME},
                null,
                null,
                null,
                null,
                null);

        HashMap<Integer, ArrayList<Item>> map = new HashMap<>();

        while (cursor.moveToNext()){
            ArrayList<Item> list = new ArrayList<>();
            int quantity = cursor.getInt(cursor.getColumnIndex(WAREHOUSE_QUANTITY));
            String name = cursor.getString(cursor.getColumnIndex(ITEM_NAME));
            int id = cursor.getInt(cursor.getColumnIndex(ITEM_ID));

            for (int i = 0; i < quantity; i ++){
                switch (name){
                    case TYPE_FERTILIZER:
                        list.add(new Fertilizer());
                        break;
                    case TYPE_WATERING_CAN:
                        list.add(new WateringCan());
                        break;
                }
            }

            map.put(id, list);
        }
        cursor.close();
        return map;
    }

    public static HashMap<Integer, Integer> getCapacityTable(){
        Cursor cursor = db.query(
                LEVEL, new String[]{LEVEL_LEVEL, LEVEL_CAPACITY},
                null, null, null ,null, null);

        HashMap<Integer, Integer> map = new HashMap<>();
        if (cursor.moveToNext()){
            int level = cursor.getInt(cursor.getColumnIndex(LEVEL_LEVEL));
            int capacity = cursor.getInt(cursor.getColumnIndex(LEVEL_CAPACITY));
            map.put(level, capacity);
        }

        cursor.close();

        return map;
    }
}