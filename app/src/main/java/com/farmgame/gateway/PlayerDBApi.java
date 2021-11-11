package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

import android.content.ContentValues;
import android.database.Cursor;

import com.farmgame.entity.Player;

public class PlayerDBApi extends DataBaseAPI {


    public static Player createPlayer(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_NAME, name);
        contentValues.put(USER_LEVEL, 1);
        contentValues.put(USER_MONEY, 0);
        contentValues.put(USER_EXP, 0);
        db.insert(USER, null, contentValues);

        return getPlayer();

    }

    public static Player getPlayer(){
        Cursor cursor = db.query(USER, new String[]{"*"},
                null, null, null, null, null);
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

    public static boolean levelUp(Player player){
        int level = player.getLevel();
        int exp = player.getExp_bar()[0];
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_LEVEL, level);
        contentValues.put(USER_EXP, exp);

        return db.update(
                USER, contentValues, USER_NAME + " = ?",
                new String[]{player.getName()}) == 1;
    }

    // player get money, spend money

    // plant

    // store buy, read, sell

    //


}
