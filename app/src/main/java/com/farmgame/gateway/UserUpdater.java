package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.farmgame.entity.Player;

public class UserUpdater {

    private static SQLiteDatabase db;


    public static void setDb(SQLiteDatabase database){
        db = database;
    }

    public static Player getPlayer(){
        Cursor cursor = db.query(USER, new String[]{"*"}, null, null, null, null, null);
        if(!cursor.moveToFirst()){
            return null;
        }
        String name = cursor.getString(cursor.getColumnIndex(USER_NAME));
        int level = cursor.getInt(cursor.getColumnIndex(USER_LEVEL));
        int exp = cursor.getInt(cursor.getColumnIndex(USER_EXP));
        int money = cursor.getInt(cursor.getColumnIndex(USER_MONEY));
        cursor.close();
        return new Player(name, level, money, new int[]{exp, 10});
    }

    public static boolean levelUp(int level, int exp){
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_LEVEL, level);
        contentValues.put(USER_EXP, exp);
//        db.update(USER, contentValues);
        return true;
    }

    // player get money, spend money

    // plant

    // store buy, read, sell

    //


}
