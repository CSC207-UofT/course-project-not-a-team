package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class InitData{

    private static SQLiteDatabase db;

    public static void setDb(SQLiteDatabase database){
        db = database;
    }

    public static boolean hasPlayer(){
        Cursor cursor = db.query(PLAYER, new String[]{"*"},
                null, null, null, null, null);
        boolean result = cursor.moveToFirst();
        cursor.close();
        return result;
    }

    public static void createPlayer(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put(PLAYER_NAME, name);
        contentValues.put(PLAYER_LEVEL, 1);
        contentValues.put(PLAYER_MONEY, 1000);
        contentValues.put(PLAYER_EXP, 0);
        db.insert(PLAYER, null, contentValues);

        db.execSQL(initPlant());
        db.execSQL(initItem());
        db.execSQL(initLevel());
        db.execSQL(initLand());


    }

    private static String initPlant(){
        String[] array = new String[]{
                // id, plantName, seedName, time, buyPrice, sellPrice, exp, unlockLevel
                "(1001,'SuperPlant','SuperSeed',1,20,30,200,1)",
                "(1002,'Banana','BananaSeed',6,25,40,2,2)",
                "(1003,'Beans','BeansSeed',7,40,70,3,3)",
                "(1004,'Blueberry','BlueberrySeed',10,50,90,4,4)",
                "(1005,'Broccoli','BroccoliSeed',12,70,120,5,5)",
                "(1006,'Cabbage','CabbageSeed',13,80,140,6,6)",
                "(1007,'Carrot','CarrotSeed',15,90,160,7,7)",
                "(1008,'Chestnut','ChestnutSeed',20,100,170,8,8)",
                "(1009,'Chili','ChiliSeed',22,110,190,9,9)",
                "(1010,'Coconut','CoconutSeed',25,120,210,10,10)",
                "(1011,'Corn','CornSeed',30,130,230,11,11)",
                "(1012,'Cucumber','CucumberSeed',32,140,250,12,12)",
                "(1013,'Dragenfruit','DragenfruitSeed',35,150,270,13,13)",
                "(1014,'Edamame','EdamameSeed',38,160,290,14,14)",
                "(1015,'Eggplant','EggplantSeed',45,170,310,15,15)",
                "(1016,'Fruitchili','FruitchiliSeed',60,180,330,16,16)",
                "(1017,'Garlic','GarlicSeed',70,190,350,17,17)",
                "(1018,'Kiwi','KiwiSeed',80,200,370,18,18)",
                "(1019,'Mango','MangosteenSeed',85,210,390,19,19)",
                "(1020,'Watermelon','WatermelonSeed',90,220,410,20,20)",
                "(1021,'Strawberry','StrawberrySeed',100,230,430,20,20)",


        };
        return "INSERT INTO " + PLANT + " VALUES" + String.join(", ", array);
    }

    private static String initItem(){
        String[] array = new String[]{
                // id, name, type
                "(14159, 'fertilizer', 'Fertilizer')",
                "(26535, 'watering can', 'WateringCan')"
        };
        return "INSERT INTO " + ITEM + " VALUES" + String.join(", ", array);
    }

    private static String initLevel(){
        String[] array = new String[]{
                // level, exp, capacity, landMax
                "(1, 100, 10, 1)",
                "(2, 150, 10, 2)",
                "(3, 200, 15, 3)",
                "(4, 250, 15, 4)",
                "(5, 300, 20, 5)",
                "(6, 350, 20, 6)",
                "(7, 400, 25, 7)",
                "(8, 450, 25, 8)",
                "(9, 500, 30, 9)",
                "(10, 550, 30, 10)",
                "(11, 600, 30, 11)",
                "(12, 650, 30, 12)",
                "(13, 700, 30, 13)",
                "(14, 750, 30, 14)",
                "(15, 800, 40, 15)",
                "(16, 850, 40, 20)",
                "(17, 900, 40, 20)",
                "(18, 950, 40, 20)",
                "(19, 1000, 40, 20)",
                "(20, 1100, 40, 20)",
        };

        return "INSERT INTO " + LEVEL + " VALUES" + String.join(", ", array);
    }

    private static String initLand(){

        String[] array = new String[]{
                // landIndex, price, lockStatus, plant, waterTime, isFertilized, stage
                "(0, 1000, 2, -1, '-1', 0, 0)",
                "(1, 1000, 0, -1, '-1', 0, 0)",
                "(2, 1000, 0, -1, '-1', 0, 0)",
                "(3, 1000, 0, -1, '-1', 0, 0)",
                "(4, 1000, 0, -1, '-1', 0, 0)",
                "(5, 2000, 0, -1, '-1', 0, 0)",
                "(6, 2000, 0, -1, '-1', 0, 0)",
                "(7, 2000, 0, -1, '-1', 0, 0)",
                "(8, 2000, 0, -1, '-1', 0, 0)",
                "(9, 2000, 0, -1, '-1', 0, 0)",
                "(10, 3000, 0, -1, '-1', 0, 0)",
                "(11, 3000, 0, -1, '-1', 0, 0)",
                "(12, 3000, 0, -1, '-1', 0, 0)",
                "(13, 3000, 0, -1, '-1', 0, 0)",
                "(14, 3000, 0, -1, '-1', 0, 0)",
                "(15, 4000, 0, -1, '-1', 0, 0)",
                "(16, 4000, 0, -1, '-1', 0, 0)",
                "(17, 4000, 0, -1, '-1', 0, 0)",
                "(18, 4000, 0, -1, '-1', 0, 0)",
                "(19, 4000, 0, -1, '-1', 0, 0)",
        };

        return "INSERT INTO " + LAND + " VALUES" + String.join(", ", array);
    }

}
