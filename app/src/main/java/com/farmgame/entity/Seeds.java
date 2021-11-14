package com.farmgame.entity;

import static com.farmgame.constants.Constants.TYPE_SEED;

import com.farmgame.usecase.StoreAble;

public class Seeds implements StoreAble {
    private final String SEEDS_NAME;
    private final int PLANTING_TIME;
    private final int BUYING_PRICE;
    private final int EXPERIMENT_POINT;
    private final int SEEDS_ID;
    private final String SEEDS_TYPE;

    /**
     * Constructor for seeds.
     *
     * @param name -- Name of plant
     * @param time -- The time it takes for a plant to mature
     * @param buying -- The price of the plant when you buy it
     * @param exp -- Experience points gained while harvesting plants
     * @param id -- The id of seed
     */

    public Seeds(String name, int time, int buying, int exp, int id) {
        this.SEEDS_NAME = name;
        this.PLANTING_TIME = time;
        this.BUYING_PRICE = buying;
        this.EXPERIMENT_POINT = exp;
        this.SEEDS_ID = id;
        this.SEEDS_TYPE = TYPE_SEED;
    }
    /**
     * Getter for NAME attributes.
     *
     * @return String
     */

    @Override
    public String getName() {
        return this.SEEDS_NAME;
    }

    /**
     * Getter for PLANTING_TIME attributes.
     *
     * @return int
     */

    public int getPlantingTime(){

        return this.PLANTING_TIME;
    }

    /**
     * Getter for SELLING_PRICE attributes.
     *
     * @return int
     */
    public int getPrice(){

        return this.BUYING_PRICE;
    }

    /**
     * Getter for EXPERIMENT_POINT attributes.
     *
     * @return int
     */

    public int getExperiencePoint(){

        return this.EXPERIMENT_POINT;
    }

    /**
     * Method to get the plant name of the seed.
     * @return String
     */

    public String getPlantFromSeed(){

        return this.SEEDS_NAME.substring(0, this.SEEDS_NAME.length() - 4);
    }

    /**
     * Method to get the id of the seed.
     * @return int
     */

    public int getSeedId(){

        return this.SEEDS_ID;
    }

    /**
     * Method to get the type of the seed.
     * @return int
     */
    @Override
    public String getType(){

        return this.SEEDS_TYPE;
    }




}
