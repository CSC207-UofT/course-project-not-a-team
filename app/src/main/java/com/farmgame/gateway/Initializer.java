package com.farmgame.gateway;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import static com.farmgame.constants.Constants.*;

/***
 * initializer of all tables when first enter the game
 */
public class Initializer extends SQLiteOpenHelper {


    /***
     *
     * @param context the context of the sqlite helper
     */
    public Initializer(@Nullable Context context) {

        super(context, "farm.db", null, 1);
    }

    /***
     * create all tables
     * @param db database instance
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUserTable());
        db.execSQL(createPlantTable());
        db.execSQL(createItemTable());
        db.execSQL(createWarehouseTable());
        db.execSQL(createLevelTable());
        db.execSQL(createLandTable());
    }

    /***
     * here we only have 1 database version, so we are not using this currently(but may be used
     * later)
     * @param db database
     * @param oldVersion old version of database
     * @param newVersion new version of database
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /***
     *
     * @return the sql string to create user table
     */
    private String createUserTable(){
        ArrayList<String[]> list = new ArrayList<>();
        list.add(new String[]{PLAYER_NAME, TEXT});
        list.add(new String[]{PLAYER_LEVEL, INT});
        list.add(new String[]{PLAYER_EXP, INT});
        list.add(new String[]{PLAYER_MONEY, INT});
        return createTable(PLAYER, list , new String[]{PLAYER_NAME});
    }
    /***
     *
     * @return the sql string to create plant table
     */
    private String createPlantTable(){
        ArrayList<String[]> list = new ArrayList<>();
        list.add(new String[]{PLANT_ID, INT});
        list.add(new String[]{PLANT_MATURE_NAME, TEXT});
        list.add(new String[]{PLANT_SEED_NAME, TEXT});
        list.add(new String[]{PLANT_TIME, INT});
        list.add(new String[]{PLANT_BUY_PRICE, INT});
        list.add(new String[]{PLANT_SELL_PRICE, INT});
        list.add(new String[]{PLANT_EXP, INT});
        list.add(new String[]{PLANT_UNLOCK_LEVEL, INT});
        return createTable(PLANT, list, new String[]{PLANT_ID});
    }

    /***
     *
     * @return the sql string to create item table
     */
    private String createItemTable(){
        ArrayList<String[]> list = new ArrayList<>();
        list.add(new String[]{ITEM_ID, INT});
        list.add(new String[]{ITEM_NAME, TEXT});
        list.add(new String[]{ITEM_TYPE, TEXT});
        list.add(new String[]{ITEM_PRICE, INT});
        return createTable(ITEM, list, new String[]{ITEM_ID});
    }


    /***
     *
     * @return the sql string to create warehouse table
     */
    private String createWarehouseTable(){
        ArrayList<String[]> list = new ArrayList<>();

        list.add(new String[]{WAREHOUSE_ID, INT});
        list.add(new String[]{WAREHOUSE_TYPE, TEXT});
        list.add(new String[]{WAREHOUSE_QUANTITY, INT});
        return createTable(WAREHOUSE, list, new String[]{WAREHOUSE_ID, WAREHOUSE_TYPE});
    }

    /***
     *
     * @return the sql string to create level table
     */
    private String createLevelTable(){
        ArrayList<String[]> list = new ArrayList<>();
        list.add(new String[]{LEVEL_LEVEL, INT});
        list.add(new String[]{LEVEL_EXP, INT});
        list.add(new String[]{LEVEL_CAPACITY, INT});
        return createTable(LEVEL, list, new String[]{LEVEL_LEVEL});
    }

    /***
     *
     * @return the sql string to create land table
     */
    private String createLandTable(){
        ArrayList<String[]> list = new ArrayList<>();
        list.add(new String[]{LAND_INDEX, INT});
        list.add(new String[]{LAND_PRICE, INT});
        list.add(new String[]{LAND_LOCK_STATUS, BOOLEAN});
        list.add(new String[]{LAND_PLANT, INT});
        list.add(new String[]{LAND_WATER_TIME, TEXT});
        list.add(new String[]{LAND_IS_FERTILIZED, BOOLEAN});
        list.add(new String[]{LAND_STAGE, INT});
        list.add(new String[]{LAND_UNLOCK_LEVEL, INT});
        return createTable(LAND, list, new String[]{LAND_INDEX});
    }

    /***
     *
     * @param tableName name of the table
     * @param list list of attributes
     * @param primaryKeys list of primary keys
     * @return the sql string to create a table
     */
    private String createTable(String tableName, ArrayList<String[]> list,
                                      String[] primaryKeys){
        return "CREATE TABLE IF NOT EXISTS " +
                tableName + "(" + handlePropertySet(list, primaryKeys) + ")";
    }

    /***
     *
     * @param list list of attributes and its type
     * @param primaryKeys list of primary keys
     * @return converted sql string
     */
    private String handlePropertySet(ArrayList<String[]> list, String[] primaryKeys){
        ArrayList<String> lst = new ArrayList<>();
        for (String[] pair: list){
            switch (pair[1]){
                case INT:
                    lst.add(pair[0] + " INT");
                    break;
                case TEXT:
                    lst.add(pair[0] + " TEXT");
                    break;
                case BOOLEAN:
                    lst.add(pair[0] + " BOOLEAN");
                    break;
            }
        }

        if (primaryKeys.length > 0){
            lst.add("PRIMARY KEY (" + String.join(", ", primaryKeys) + ")");
        }


        return String.join(", ", lst);
    }

}
