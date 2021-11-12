package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

import android.content.ContentValues;
import android.database.Cursor;


import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Player;
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



    public static void updateLand(int landIndex){
        LandEntity land = vm.getLand(landIndex);
        ContentValues contentValues = new ContentValues();
        contentValues.put(LAND_LOCK_STATUS, land.getLockStatus());
        contentValues.put(LAND_PLANT, land.getPlant().getSeedId());
        contentValues.put(LAND_WATER_TIME, land.getWaterTime());
        contentValues.put(LAND_FERTILIZE_TIME, land.getFertilizeTime());
        contentValues.put(LAND_STAGE, land.getStage());

        db.update(
                LAND, contentValues, LAND_INDEX + " = ?",
                new String[]{String.valueOf(land.getIndex())});
    }

}