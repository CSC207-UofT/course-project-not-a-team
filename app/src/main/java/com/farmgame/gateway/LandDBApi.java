package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

import android.content.ContentValues;
import android.database.Cursor;


import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Seeds;

import java.util.ArrayList;
import java.util.HashMap;

public class LandDBApi extends DataBaseAPI {

    public static HashMap<Integer, Integer> getLandMaxTable(){
        Cursor cursor = db.query(
                LEVEL,
                new String[]{LEVEL_LEVEL, LEVEL_LAND_MAX},
                null, null, null ,null, null);

        HashMap<Integer, Integer> map = new HashMap<>();

        if (cursor.moveToNext()){
            int level = cursor.getInt(cursor.getColumnIndex(LEVEL_LEVEL));
            int max = cursor.getInt(cursor.getColumnIndex(LEVEL_LAND_MAX));
            map.put(level, max);
        }

        cursor.close();

        return map;
    }

    public static ArrayList<LandEntity> getLandList(){
        ArrayList<LandEntity> list = new ArrayList<>();
        Cursor cursor = db.query(
                LAND,
                new String[]{"*"},
                null,null,null,null,null
        );
        while (cursor.moveToNext()){
            int lockStatus = cursor.getInt(cursor.getColumnIndex(LAND_LOCK_STATUS));
            int seedID = cursor.getInt(cursor.getColumnIndex(LAND_PLANT));
            Seeds seed = seedID != -1 ? PlantDBApi.getSeed(seedID) : null;
            String waterTime = cursor.getString(cursor.getColumnIndex(LAND_WATER_TIME));
            boolean isFertilize = cursor.getInt(cursor.getColumnIndex(LAND_IS_FERTILIZED)) == 1;
            int stage = cursor.getInt(cursor.getColumnIndex(LAND_STAGE));
            int price = cursor.getInt(cursor.getColumnIndex(LAND_PRICE));
            int index = cursor.getInt(cursor.getColumnIndex(LAND_INDEX));
            list.add(new LandEntity(lockStatus, seed, waterTime, stage, isFertilize, price, index));
        }

        cursor.close();

        return list;
    }



    public static void updateLand(int landIndex){
        LandEntity land = vm.getLand(landIndex);
        ContentValues contentValues = new ContentValues();
        contentValues.put(LAND_LOCK_STATUS, land.getLockStatus());
        contentValues.put(LAND_PLANT, land.getPlant().getId());
        contentValues.put(LAND_WATER_TIME, land.getWaterTime());
        contentValues.put(LAND_IS_FERTILIZED, land.isFertilize()? 1 : 0);
        contentValues.put(LAND_PRICE, land.getPrice());
        contentValues.put(LAND_STAGE, land.getStage());

        db.update(
                LAND, contentValues, LAND_INDEX + " = ?",
                new String[]{String.valueOf(land.getIndex())});

        vm.updateLand();
    }

}