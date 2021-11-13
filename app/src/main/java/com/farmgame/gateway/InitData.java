package com.farmgame.gateway;

import static com.farmgame.constants.Constants.PLAYER;
import static com.farmgame.constants.Constants.PLAYER_EXP;
import static com.farmgame.constants.Constants.PLAYER_LEVEL;
import static com.farmgame.constants.Constants.PLAYER_MONEY;
import static com.farmgame.constants.Constants.PLAYER_NAME;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class InitData{

    private static SQLiteDatabase db;

    public static void setDb(SQLiteDatabase database){
        db = database;
    }

    public static void createPlayer(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put(PLAYER_NAME, name);
        contentValues.put(PLAYER_LEVEL, 1);
        contentValues.put(PLAYER_MONEY, 0);
        contentValues.put(PLAYER_EXP, 0);
        db.insert(PLAYER, null, contentValues);

        db.execSQL("INSERT INTO LEVEL VALUES (1, 10, 10, 1)");
        db.execSQL("INSERT INTO LAND VALUES(0, 10, 0, 1, 1, 1, 0)");


    }

    public static boolean hasPlayer(){
        Cursor cursor = db.query(PLAYER, new String[]{"*"},
                null, null, null, null, null);
        boolean result = cursor.moveToFirst();
        cursor.close();
        return result;
    }

}
