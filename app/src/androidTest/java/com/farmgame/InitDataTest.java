package com.farmgame;


import static com.farmgame.constants.Constants.*;


import android.database.Cursor;

import androidx.test.ext.junit.runners.AndroidJUnit4;


import org.junit.Test;
import org.junit.runner.RunWith;


import com.farmgame.gateway.InitData;


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
        assert countRow(cursor) == 21;
        cursor.close();

    }

    @Test
    public void TestItem() throws Exception {
        String name = "farmer";
        InitData.setDb(db);
        InitData.createPlayer(name);
        Cursor cursor = db.query(ITEM, new String[]{"*"}, null, null,
                null, null, null);

        assert countRow(cursor) == 2;
        cursor.close();

    }

    @Test
    public void TestWarehouse() throws Exception {
        String name = "farmer";
        InitData.setDb(db);
        InitData.createPlayer(name);
        Cursor cursor = db.query(WAREHOUSE, new String[]{"*"}, null, null,
                null, null, null);

        assert countRow(cursor) == 0;
        cursor.close();

    }

    @Test
    public void TestLevel() throws Exception {
        String name = "farmer";
        InitData.setDb(db);
        InitData.createPlayer(name);
        Cursor cursor = db.query(LEVEL, new String[]{"*"}, null, null,
                null, null, null);

        assert countRow(cursor) == 20;
        cursor.close();

    }

    @Test
    public void TestLand() throws Exception {
        String name = "farmer";
        InitData.setDb(db);
        InitData.createPlayer(name);
        Cursor cursor = db.query(LAND, new String[]{"*"}, null, null,
                null, null, null);

        assert countRow(cursor) == 20;
        cursor.close();

    }



}
