package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class InitData{

    private static SQLiteDatabase db;

    public static void setDb(SQLiteDatabase database){
        db = database;
    }

    public static boolean hasPlayer(){
        Cursor cursor = db.query(PLAYER, new String[]{"*"},
                null, null, null, null, null);
        boolean result = cursor.moveToFirst();
        cursor.close();
        return result;
    }

    public static void createPlayer(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put(PLAYER_NAME, name);
        contentValues.put(PLAYER_LEVEL, 1);
        contentValues.put(PLAYER_MONEY, 0);
        contentValues.put(PLAYER_EXP, 0);
        db.insert(PLAYER, null, contentValues);

        db.execSQL(initPlant());
        db.execSQL(initItem());
        db.execSQL(initLevel());
        db.execSQL(initLand());


    }

    private static String initPlant(){
        String[] array = new String[]{
                // id, plantName, seedName, time, buyPrice, sellPrice, exp, unlockLevel
                "(1, 'plant1', 'plant1seed', 1, 1, 2, 3,  0)",
        };
        return "INSERT INTO " + PLANT + " VALUES" + String.join(", ", array);
    }

    private static String initItem(){
        String[] array = new String[]{
                // id, name, type
                "(1, 'fertilizer', 'Fertilizer')",
        };
        return "INSERT INTO " + ITEM + " VALUES" + String.join(", ", array);
    }

    private static String initLevel(){
        String[] array = new String[]{
                // level, exp, capacity, landMax
                "(1, 10, 10, 1)",
        };

        return "INSERT INTO " + LEVEL + " VALUES" + String.join(", ", array);
    }

    private static String initLand(){

        String[] array = new String[]{
                // landIndex, price, lockStatus, plant, waterTime, fertilizeTime, stage
                "(0, 10, 0, NULL, '-1', '-1', 0)",
        };

        return "INSERT INTO " + LAND + " VALUES" + String.join(", ", array);
    }

}
