package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

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


}