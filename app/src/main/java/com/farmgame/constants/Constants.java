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


    // SQLite Column Type
    public static final String INT = "INT";
    public static final String TEXT = "TEXT";
    public static final String BOOLEAN = "BOOLEAN";

    // User SQL Column names
    public static final String PLAYER_NAME = "name";
    public static final String PLAYER_LEVEL = "level";
    public static final String PLAYER_EXP = "playerExp";
    public static final String PLAYER_MONEY = "money";


    // Plant SQL Column names
    public static final String PLANT_ID = "id";
    public static final String PLANT_MATURE_NAME = "plantName";
    public static final String PLANT_SEED_NAME = "seedName";
    public static final String PLANT_TIME = "time";
    public static final String PLANT_BUY_PRICE = "buyPrice";
    public static final String PLANT_SELL_PRICE = "sellPrice";
    public static final String PLANT_EXP = "plantExp";
    public static final String PLANT_UNLOCK_LEVEL = "unlockLevel";

    // Item SQL Column names
    public static final String ITEM_ID = "id";
    public static final String ITEM_NAME = "name";
    public static final String ITEM_TYPE = "itemType";


    // Warehouse SQL Column names
    public static final String WAREHOUSE_TYPE = "type";
    public static final String WAREHOUSE_ID = "id";
    public static final String WAREHOUSE_QUANTITY = "quantity";

    // Level SQL Column names
    public static final String LEVEL_LEVEL = "level";
    public static final String LEVEL_EXP = "exp";
    public static final String LEVEL_CAPACITY = "capacity";

    // Land SQL Column names
    public static final String LAND_INDEX = "landIndex";
    public static final String LAND_PRICE = "price";
    public static final String LAND_LOCK_STATUS = "lockStatus";
    public static final String LAND_PLANT = "plant";
    public static final String LAND_WATER_TIME = "waterTime";
    public static final String LAND_IS_FERTILIZED = "isFertilized";
    public static final String LAND_STAGE = "stage";
    public static final String LAND_UNLOCK_LEVEL = "unlockLevel";

    // Type of StoreAble
    public static final String TYPE_FERTILIZER = "Fertilizer";
    public static final String TYPE_WATERING_CAN = "WateringCan";
    public static final String TYPE_SEED = "seed";
    public static final String TYPE_PLANT = "plant";


    // Missing Value
    public static final int MISSING_VALUE = -1;
    //Invalid Purchase
    public static final int NOT_ENOUGH_MONEY = -10;
    public static final int NOT_ENOUGH_SPACE = -20;
    public static final int SUCCESS = 10;


    // observable messages Store
    public static final int UPDATE_PLAYER = 0;
    public static final int UPDATE_WAREHOUSE = 1;
    public static final int UPDATE_LAND = 2;
    public static final int AUTO_UNLOCK = -1;


}
