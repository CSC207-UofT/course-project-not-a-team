package com.farmgame.constants;


public class Constants {

    // Land lock status
    public static final int LOCK_STATUS_LOCKED = 0;
    public static final int LOCK_STATUS_NOT_BOUGHT = 1;
    public static final int LOCK_STATUS_BOUGHT = 2;


    // SQL Table Names
    public static final String USER = "User";
    public static final String PLANT = "Plant";
    public static final String WAREHOUSE = "Warehouse";
    public static final String LEVEL = "Level";


    // SQLite Column Type
    public static final int INT = 0;
    public static final int REAL = 1;
    public static final int TEXT = 2;
    public static final int BOOLEAN = 3;

    // User SQL Column names
    public static final String USER_NAME = "name";
    public static final String USER_LEVEL = "level";
    public static final String USER_EXP = "exp";
    public static final String USER_MONEY = "money";


    // Plant SQL Column names
    public static final String PLANT_NAME = "name";
    public static final String PLANT_TIME = "time";
    public static final String PLANT_BUY_PRICE = "buyPrice";
    public static final String PLANT_SELL_PRICE = "sellPrice";
    public static final String PLANT_EXP = "exp";


    // Warehouse SQL Column names
    public static final String WAREHOUSE_TYPE = "type";
    public static final String WAREHOUSE_ID = "id";
    public static final String WAREHOUSE_QUANTITY = "quantity";

    // Level SQL Column names
    public static final String LEVEL_LEVEL = "level";
    public static final String LEVEL_EXP = "exp";
    public static final String LEVEL_QUANTITY = "quantity";


}
