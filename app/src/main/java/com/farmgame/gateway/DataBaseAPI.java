package com.farmgame.gateway;

import android.database.sqlite.SQLiteDatabase;

public abstract class DataBaseAPI {

    protected static SQLiteDatabase db;

    public static void setDb(SQLiteDatabase database){
        db = database;
    }
}
