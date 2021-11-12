package com.farmgame.constants;


public class Constants {

    // Land lock status
    public static final int LOCK_STATUS_LOCKED = 0;
    public static final int LOCK_STATUS_NOT_BOUGHT = 1;
    public static final int LOCK_STATUS_BOUGHT = 2;


    // SQL Table Names
    public static final String PLAYER = "Player";
    public static final String PLANT = "Plant";
    public static final String ITEM = "Item";
    public static final String WAREHOUSE = "Warehouse";
    public static final String LEVEL = "Level";
    public static final String LAND = "Land";
    public static final String STORE = "Store";


    // SQLite Column Type
    public static final int INT = 0;
    public static final int TEXT = 1;
    public static final int BOOLEAN = 2;

    // User SQL Column names
    public static final String PLAYER_NAME = "name";
    public static final String PLAYER_LEVEL = "level";
    public static final String PLAYER_EXP = "exp";
    public static final String PLAYER_MONEY = "money";


    // Plant SQL Column names
    public static final String PLANT_ID = "id";
    public static final String PLANT_MATURE_NAME = "plantName";
    public static final String PLANT_SEED_NAME = "seedName";
    public static final String PLANT_TIME = "time";
    public static final String PLANT_BUY_PRICE = "buyPrice";
    public static final String PLANT_SELL_PRICE = "sellPrice";
    public static final String PLANT_EXP = "exp";
    public static final String PLANT_UNLOCK_LEVEL = "unlockLevel";

    // Item SQL Column names
    public static final String ITEM_ID = "id";
    public static final String ITEM_NAME = "name";
    public static final String ITEM_TYPE = "type";


    // Warehouse SQL Column names
    public static final String WAREHOUSE_TYPE = "type";
    public static final String WAREHOUSE_ID = "id";
    public static final String WAREHOUSE_QUANTITY = "quantity";

    // Level SQL Column names
    public static final String LEVEL_LEVEL = "level";
    public static final String LEVEL_EXP = "exp";
    public static final String LEVEL_CAPACITY = "capacity";
    public static final String LEVEL_LAND_MAX = "landMax";

    // Land SQL Column names
    public static final String LAND_INDEX = "landIndex";
    public static final String LAND_PRICE = "price";
    public static final String LAND_LOCK_STATUS = "lockStatus";
    public static final String LAND_PLANT = "plant";
    public static final String LAND_WATER_TIME = "waterTime";
    public static final String LAND_FERTILIZE_TIME = "fertilizeTime";
    public static final String LAND_STAGE = "stage";


    // Store SQL Column names
    public static final String STORE_ID = "id";
    public static final String STORE_TYPE = "type";
    public static final String STORE_UNLOCK_LEVEL = "unlockLevel";


    // Type of StoreAble
    public static final String TYPE_FERTILIZER = "Fertilizer";
    public static final String TYPE_WATERING_CAN = "WateringCan";
    public static final String TYPE_SEED = "seed";
    public static final String TYPE_PLANT = "plant";


    // Missing Value
    public static final int MISSING_VALUE = -1;


    // observable messages Store
    public static final int OB_LEVEL_UP = 0;
    public static final int ADD_MONEY = 1;
    public static final int SUBTRACT_MONEY = 2;
    public static final int WAREHOUSE_ADD = 3;
    public static final int WAREHOUSE_SUBTRACT = 4;


}
