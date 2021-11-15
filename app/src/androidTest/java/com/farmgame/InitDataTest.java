package com.farmgame;


import static com.farmgame.constants.Constants.*;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import com.farmgame.gateway.InitData;
import com.farmgame.gateway.Initializer;


import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class InitDataTest extends DatabaseTest{




    @Test
    public void TestSetUpDB(){
        InitData.setDb(db);
    }

    @Test
    public void TestPlayer() throws Exception {
        String name = "farmer";
        InitData.setDb(db);
        InitData.createPlayer(name);
        Cursor cursor = db.query(PLAYER, new String[]{"*"}, null, null,
                null, null, null);
        cursor.moveToFirst();
        assert  cursor.getString(cursor.getColumnIndex(PLAYER_NAME)).equals(name);
        cursor.close();

    }

    @Test
    public void TestPlant() throws Exception {
        String name = "farmer";
        InitData.setDb(db);
        InitData.createPlayer(name);
        Cursor cursor = db.query(PLANT, new String[]{"*"}, null, null,
                null, null, null);
        int count = 0;
        while (cursor.moveToNext()){
            count += 1;
        }
        cursor.close();
        assert count == 21;

    }

    @Test
    public void TestItem() throws Exception {
        String name = "farmer";
        InitData.setDb(db);
        InitData.createPlayer(name);
        Cursor cursor = db.query(ITEM, new String[]{"*"}, null, null,
                null, null, null);
        int count = 0;
        while (cursor.moveToNext()){
            count += 1;
        }
        cursor.close();
        assert count == 2;

    }

    @Test
    public void TestWarehouse() throws Exception {
        String name = "farmer";
        InitData.setDb(db);
        InitData.createPlayer(name);
        Cursor cursor = db.query(WAREHOUSE, new String[]{"*"}, null, null,
                null, null, null);
        int count = 0;
        while (cursor.moveToNext()){
            count += 1;
        }
        cursor.close();
        assert count == 0;

    }

    @Test
    public void TestLevel() throws Exception {
        String name = "farmer";
        InitData.setDb(db);
        InitData.createPlayer(name);
        Cursor cursor = db.query(LEVEL, new String[]{"*"}, null, null,
                null, null, null);
        int count = 0;
        while (cursor.moveToNext()){
            count += 1;
        }
        cursor.close();
        assert count == 20;

    }

    @Test
    public void TestLand() throws Exception {
        String name = "farmer";
        InitData.setDb(db);
        InitData.createPlayer(name);
        Cursor cursor = db.query(LAND, new String[]{"*"}, null, null,
                null, null, null);
        int count = 0;
        while (cursor.moveToNext()){
            count += 1;
        }
        cursor.close();
        assert count == 20;

    }



}
