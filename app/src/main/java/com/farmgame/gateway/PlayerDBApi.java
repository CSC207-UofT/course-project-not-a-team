package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

import android.content.ContentValues;
import android.database.Cursor;

import com.farmgame.entity.Player;

import java.util.HashMap;

public class PlayerDBApi extends DataBaseAPI {


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
        return PlayerDBApi.getPlayer() != null;
    }

    public static Player getPlayer(){
        Cursor cursor = db.query(PLAYER, new String[]{"*"},
                null, null, null, null, null);
        if(!cursor.moveToFirst()){
            return null;
        }
        String name = cursor.getString(cursor.getColumnIndex(PLAYER_NAME));
        int level = cursor.getInt(cursor.getColumnIndex(PLAYER_LEVEL));
        int exp = cursor.getInt(cursor.getColumnIndex(PLAYER_EXP));
        int money = cursor.getInt(cursor.getColumnIndex(PLAYER_MONEY));
        cursor.close();
        return new Player(name, level, money, new int[]{exp, 10});
    }

    public static void updatePlayer(){
        Player player = vm.getPlayer();
        int level = player.getLevel();
        int exp = player.getExp_bar()[0];
        int money = player.getMoney();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PLAYER_LEVEL, level);
        contentValues.put(PLAYER_EXP, exp);
        contentValues.put(PLAYER_MONEY, money);

        db.update(
                PLAYER, contentValues, PLAYER_NAME + " = ?",
                new String[]{player.getName()});
    }

    public static HashMap<Integer, Integer> getExpTable(){
        Cursor cursor = db.query(
                LEVEL, new String[]{LEVEL_LEVEL, LEVEL_EXP},
                null, null, null ,null, null);

        HashMap<Integer, Integer> map = new HashMap<>();
        if (cursor.moveToNext()){
            int level = cursor.getInt(cursor.getColumnIndex(LEVEL_LEVEL));
            int exp = cursor.getInt(cursor.getColumnIndex(LEVEL_EXP));
            map.put(level, exp);
        }

        cursor.close();

        return map;
    }


    // player get money, spend money

    // plant

    // store buy, read, sell

    //


}
