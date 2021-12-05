package com.farmgame.gateway;


import static com.farmgame.constants.Constants.*;

import android.database.Cursor;

import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;

import java.util.HashMap;

/***
 * database gateway to plant
 */
public class PlantDBApi extends DataBaseAPI {


    /***
     *
     * @param id id of the plant
     * @return Plants instance from the given id
     */
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

    /***
     *
     * @param seedId id of the seed
     * @return Seeds instance from the given id
     */
    public static Seeds getSeed(int seedId){

        Cursor cursor = db.query(
                PLANT,
                new String[]{"*"},
                PLANT_ID + " = ?", new String[]{String.valueOf(seedId)},
                null, null, null);
        cursor.moveToFirst();

        String name = cursor.getString(cursor.getColumnIndex(PLANT_SEED_NAME));
        int time = cursor.getInt(cursor.getColumnIndex(PLANT_TIME));
        int buying = cursor.getInt(cursor.getColumnIndex(PLANT_SEED_NAME));
        int exp = cursor.getInt(cursor.getColumnIndex(PLANT_EXP));
        int id = cursor.getInt(cursor.getColumnIndex(PLANT_ID));

        cursor.close();

        return new Seeds(name, time, buying, exp, id);
    }

}