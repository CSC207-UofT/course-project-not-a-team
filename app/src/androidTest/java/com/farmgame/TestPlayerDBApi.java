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
public class TestPlayerDBApi extends DatabaseTest{



    @Test
    public void TestSetUpDB(){
        InitData.setDb(db);
    }


}
