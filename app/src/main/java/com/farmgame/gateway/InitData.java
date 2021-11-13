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
                "(14159, 'fertilizer', 'Fertilizer')",
                "(26535. 'watering can', 'WateringCan')"
        };
        return "INSERT INTO " + ITEM + " VALUES" + String.join(", ", array);
    }

    private static String initLevel(){
        String[] array = new String[]{
                // level, exp, capacity, landMax
                "(1, 10, 10, 1)",
                "(2, 15, 10, 2)",
                "(3, 20, 15, 3)",
                "(4, 25, 15, 4)",
                "(5, 30, 20, 5)",
                "(6, 35, 20, 6)",
                "(7, 40, 25, 7)",
                "(8, 45, 25, 8)",
                "(9, 50, 30, 9)",
                "(10, 55, 30, 10)",
                "(11, 60, 30, 11)",
                "(12, 65, 30, 12)",
                "(13, 70, 30, 13)",
                "(14, 75, 30, 14)",
                "(15, 80, 40, 15)",
                "(16, 85, 40, 20)",
                "(17, 90, 40, 20)",
                "(18, 95, 40, 20)",
                "(19, 100, 40, 20)",
                "(20, 110, 40, 20)",
        };

        return "INSERT INTO " + LEVEL + " VALUES" + String.join(", ", array);
    }

    private static String initLand(){

        String[] array = new String[]{
                // landIndex, price, lockStatus, plant, waterTime, fertilizeTime, stage
                "(0, 10, 0, NULL, '-1', '-1', 0)",
                "(1, 10, 0, NULL, '-1', '-1', 0)",
                "(2, 10, 0, NULL, '-1', '-1', 0)",
                "(3, 10, 0, NULL, '-1', '-1', 0)",
                "(4, 10, 0, NULL, '-1', '-1', 0)",
                "(5, 20, 0, NULL, '-1', '-1', 0)",
                "(6, 20, 0, NULL, '-1', '-1', 0)",
                "(7, 20, 0, NULL, '-1', '-1', 0)",
                "(8, 20, 0, NULL, '-1', '-1', 0)",
                "(9, 20, 0, NULL, '-1', '-1', 0)",
                "(10, 30, 0, NULL, '-1', '-1', 0)",
                "(11, 30, 0, NULL, '-1', '-1', 0)",
                "(12, 30, 0, NULL, '-1', '-1', 0)",
                "(13, 30, 0, NULL, '-1', '-1', 0)",
                "(14, 30, 0, NULL, '-1', '-1', 0)",
                "(15, 40, 0, NULL, '-1', '-1', 0)",
                "(16, 40, 0, NULL, '-1', '-1', 0)",
                "(17, 40, 0, NULL, '-1', '-1', 0)",
                "(18, 40, 0, NULL, '-1', '-1', 0)",
                "(19, 40, 0, NULL, '-1', '-1', 0)",
        };

        return "INSERT INTO " + LAND + " VALUES" + String.join(", ", array);
    }

}
