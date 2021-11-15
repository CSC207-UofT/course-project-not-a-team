package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

import android.content.ContentValues;
import android.database.Cursor;

import com.farmgame.entity.Player;

import java.util.HashMap;

public class PlayerDBApi extends DataBaseAPI {


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
        return new Player(name, level, money, new int[]{exp, getExpTable().get(level)});
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

        vm.updatePlayer();
        vm.updateStore();
    }

    public static HashMap<Integer, Integer> getExpTable(){
        Cursor cursor = db.query(
                LEVEL, new String[]{LEVEL_LEVEL, LEVEL_EXP},
                null, null, null ,null, null);

        HashMap<Integer, Integer> map = new HashMap<>();
        while (cursor.moveToNext()){
            int level = cursor.getInt(cursor.getColumnIndex(LEVEL_LEVEL));
            int exp = cursor.getInt(cursor.getColumnIndex(LEVEL_EXP));
            map.put(level, exp);
        }

        cursor.close();

        return map;
    }



}
