package com.farmgame.entity;

import com.farmgame.usecase.WarehouseManager.StoreAble;

public class Plants implements StoreAble {

    private final String PLANTS_NAME;
    private final int SELLING_PRICE;
    private final int PLANTS_ID;

    /**
     * Constructor for plants.
     * @param name -- The name of the plant
     * @param selling -- The price of the plant when you sell it
     * @param id -- the id of the plant, same as seed
     */

    public Plants(String name, int selling, int id) {
        this.PLANTS_NAME = name;
        this.SELLING_PRICE = selling;
        this.PLANTS_ID = id;
    }

    /**
     * Getter for PLANTS_NAME attributes.
     *
     * @return String
     */

    @Override
    public String getName() {
        return this.PLANTS_NAME;
    }

    /**
     * Getter for SELLING_PRICE attributes.
     *
     * @return int
     */

    public int getSellingPrice(){

        return this.SELLING_PRICE;
    }

    /**
     * Getter for PLANT_ID attributes.
     *
     * @return int
     */

    public int getPlantID(){

        return this.PLANTS_ID;
    }




}