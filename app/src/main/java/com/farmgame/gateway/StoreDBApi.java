package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

import android.database.Cursor;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Item.WateringCan;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;
import com.farmgame.entity.Store;

import java.util.ArrayList;

public class StoreDBApi extends DataBaseAPI {


    public static Store getStore(){
        return new Store(getPlantList(), getSeedList(), getItemList());
    }

    public static ArrayList<Plants> getPlantList(){

        ArrayList<Plants> list = new ArrayList<>();

        Cursor cursor = db.query(
                PLANT,
                new String[]{"*"}, null, null,
                null, null, null);

        while (cursor.moveToNext()){

            String name = cursor.getString(cursor.getColumnIndex(PLANT_MATURE_NAME));
            int selling = cursor.getInt(cursor.getColumnIndex(PLANT_SELL_PRICE));
            int id = cursor.getInt(cursor.getColumnIndex(PLANT_ID));

            list.add(new Plants(name, selling, id));
        }

        cursor.close();

        return list;
    }

    public static ArrayList<Seeds> getSeedList(){

        ArrayList<Seeds> list = new ArrayList<>();

        Cursor cursor = db.query(
                PLANT,
                new String[]{"*"},
                PLANT_UNLOCK_LEVEL + " <= ?", new String[]{String.valueOf(PlayerDBApi.getPlayer().getLevel())},
                null, null, null);

        while (cursor.moveToNext()){

            String name = cursor.getString(cursor.getColumnIndex(PLANT_SEED_NAME));
            int time = cursor.getInt(cursor.getColumnIndex(PLANT_TIME));
            int buying = cursor.getInt(cursor.getColumnIndex(PLANT_BUY_PRICE));
            int exp = cursor.getInt(cursor.getColumnIndex(PLANT_EXP));
            int id = cursor.getInt(cursor.getColumnIndex(PLANT_ID));

            list.add(new Seeds(name, time, buying, exp, id));
        }

        cursor.close();

        return list;

    }

    public static ArrayList<Item> getItemList(){

        ArrayList<Item> list = new ArrayList<>();

        Cursor cursor = db.query(
                ITEM,
                new String[]{"type"}, null, null,
                null, null, null);


        while (cursor.moveToNext()){
            String type = cursor.getString(cursor.getColumnIndex(ITEM_TYPE));
            switch (type){
                case TYPE_FERTILIZER:
                    list.add(new Fertilizer());
                    break;
                case TYPE_WATERING_CAN:
                    list.add(new WateringCan());
                    break;
            }
        }

        cursor.close();

        return list;
    }

}
