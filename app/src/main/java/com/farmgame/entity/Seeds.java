package com.farmgame.entity;

public class Seeds {
    private final String SEEDS_NAME;
    private final int PLANTING_TIME;
    private final int BUYING_PRICE;
    private final int EXPERIMENT_POINT;

    /**
     * Constructor for seeds.
     *
     * @param name -- Name of plant
     * @param time -- The time it takes for a plant to mature
     * @param buying -- The price of the plant when you buy it
     * @param exp -- Experience points gained while harvesting plants
     */

    public Seeds(String name, int time, int buying, int exp) {
        this.SEEDS_NAME = name;
        this.PLANTING_TIME = time;
        this.BUYING_PRICE = buying;
        this.EXPERIMENT_POINT = exp;
    }
    /**
     * Getter for NAME attributes.
     *
     * @return String
     */

    public String getSeedsName(){

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
    public int getBuyingPrice(){

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
}
