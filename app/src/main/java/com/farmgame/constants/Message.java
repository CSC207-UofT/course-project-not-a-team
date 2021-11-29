package com.farmgame.constants;

public class Message {

    // Land Change Status
    public static final String BUY_SUCCESS = "Congratulations! You have bought a new land!";
    public static final String NO_ENOUGH_MONEY = "Unfortunately! You don't have enough money";

    // Harvest Land
    public static final String PLANT_SUCCESS = "Congratulations! You have planted successfully!";
    public static final String INVALID_LAND = "Unfortunately! You don't own this land";
    public static final String LAND_OCCUPIED = "Ouch! A plant is growing in this land. You are not "
            + " allowed to plant a new one";
    public static final String NOT_ENOUGH_SEED = "Ouch! Your warehouse does not have this seed!";
    public static final String LAND_NOT_PLANT = "This land has not been planted yet!";
    public static final String GROWING_PLANT = "This plants has not been fully grown.";
    public static final String HARVEST_PLANT = "The plant is harvested successfully.";

    // Plant Status
    public static final String FERTILIZE_SUCCESS = "You have fertilized this land! " +
            "The plants are growing faster now!";
    public static final String WATERING_SUCCESS = "You have watered this land! The plants are " +
            "growing successfully now!";
    public static final String NOT_ENOUGH_FERTILIZER = "Ouch! Your warehouse does " +
            "not have enough fertilizer!";
    public static final String INVALID_FERTILIZER = "Ouch! You have just fertilized this land. " +
            "You may only fertilize once per plant.";
    public static final String NOT_ENOUGH_WATERING = "Unfortunately! The warehouse does " +
            "not have enough watering can.";
    public static final String INVALID_WATER_MATURE = "This plant is mature, " +
            "you shouldn't water it again.";
    public static final String INVALID_WATER = "Ouch! This land has just been watered. " +
            "You may need to wait several minutes for the next round";

    // Store Transaction
    public static final String INVALID_PRODUCT = "This product is not provided in store.";
    public static final String PURCHASE_SUCCESS = "Congratulations! " +
            "You have successfully made a purchase";
    public static final String NOT_ENOUGH_CAPACITY = "The purchase is unsuccessfully. " +
            "The warehouse does not have enough capacity.";
    public static final String UPDATE_SUCCESS = "The purchased object has already " +
            "been added to warehouse.";
    public static final String SELL_SUCCESS = "Congratulations! You have earned ";
    public static final String SELL_FAIL = "Sorry! This product is not able to sell";
}
