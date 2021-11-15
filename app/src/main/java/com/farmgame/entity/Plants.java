package com.farmgame.entity;

import static com.farmgame.constants.Constants.TYPE_PLANT;
import com.farmgame.usecase.StoreAble;

public class Plants implements StoreAble {
    private final String PLANTS_NAME;
    private final int SELLING_PRICE;
    private final int PLANTS_ID;
    private final String PLANTS_TYPE;

    /**
     * Constructor for plants.
     * @param name -- The name of the plant
     * @param selling -- The price that you get when you sell the plant
     * @param id -- the id of the plant, same as seed
     */

    public Plants(String name, int selling, int id) {
        this.PLANTS_NAME = name;
        this.SELLING_PRICE = selling;
        this.PLANTS_ID = id;
        this.PLANTS_TYPE = TYPE_PLANT;
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
    @Override
    public int getPrice(){
        return this.SELLING_PRICE;
    }

    /**
     * Getter for PLANT_ID attributes.
     *
     * @return int
     */
    @Override
    public int getId(){
        return this.PLANTS_ID;
    }

    /**
     * Getter for PLANTS_TYPE attributes.
     *
     * @return String
     */
    @Override
    public String getType() {
        return this.PLANTS_TYPE;
    }
}