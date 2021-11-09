package com.farmgame;

public class Plants {
    private final String NAME;
    private final int PLANTING_TIME;
    private final int BUYING_PRICE;
    private final int SELLING_PRICE;
    private final int EXPERIMENT_POINT;

    /**
     * Constructor for player.
     *
     * @param name -- Name of plant
     * @param time -- The time it takes for a plant to mature
     * @param buying -- The price of the plant when you buy it
     * @param selling -- The price of the plant when you sell it
     * @param exp -- Experience points gained while harvesting plants
     */
    public Plants(String name, int time, int buying, int selling, int exp) {
        this.NAME = name;
        this.PLANTING_TIME = time;
        this.BUYING_PRICE = buying;
        this.SELLING_PRICE = selling;
        this.EXPERIMENT_POINT = exp;
    }

    /**
     * Getter for NAME attributes.
     *
     * @return String
     */

    public String getPlantName(){

        return this.NAME;
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

    public int getSellingPrice(){

        return this.SELLING_PRICE;
    }

    /**
     * Getter for BUYING_PRICE attributes.
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
    } // Get the ExperiencePoint of object


}