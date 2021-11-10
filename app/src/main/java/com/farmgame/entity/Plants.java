package com.farmgame.entity;

public class Plants {

    private final String PLANTS_NAME;
    private final int SELLING_PRICE;

    /**
     * Constructor for plants.
     * @param selling -- The price of the plant when you sell it
     */

    public Plants(String name, int selling) {
        this.PLANTS_NAME = name;
        this.SELLING_PRICE = selling;
    }
    /**
            * Getter for PLANTS_NAME attributes.
            *
            * @return String
     */

    public String getPlantName() {

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




}