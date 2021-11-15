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


import com.farmgame.gateway.Initializer;


import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    protected SQLiteDatabase db;


    @Before
    public void createDb(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Initializer initializer = new Initializer(appContext);
        db = initializer.getReadableDatabase();
        dropTables();

    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void TestConnected(){
        assert db != null;
    }

    protected void dropTables(){
        String[] tables = new String[]{PLAYER, PLANT, ITEM, WAREHOUSE, LEVEL, LAND};
        for (String table : tables){
            String sql = "DELETE FROM " + table;
            db.execSQL(sql);
        }
    }

    protected int countRow(Cursor cursor){
        int count = 0;
        while (cursor.moveToNext()){
            count += 1;
        }
        return count;
    }
}
