package com.farmgame;

public class Plants {
    private final String NAME;
    private final int PLANTING_TIME;
    private final int BUYING_PRICE;
    private final int SELLING_PRICE;
    private final int EXPERIMENT_POINT;

    // PlantName -- Name of plant
    // PlantingTime -- The time it takes for a plant to mature
    // BuyingPrice -- The price of the plant when you buy it
    // SellingPrice -- The price of the plant when you sell it
    // ExperiencePoint -- Experience points gained while harvesting plants

    public Plants(String name, int time, int buying, int selling, int exp) {
        this.NAME = name;
        this.PLANTING_TIME = time;
        this.BUYING_PRICE = buying;
        this.SELLING_PRICE = selling;
        this.EXPERIMENT_POINT = exp;
    }
    // Initialize the plant.

    public String getPlantName(){
        return this.NAME;
    }
    // Get the PlantName of object

    public int getPlantingTime(){
        return this.PLANTING_TIME;
    }
    // Get the PlantingTime of object

    public int getSellingPrice(){
        return this.SELLING_PRICE;
    }
    // Get the SellingPrice of object

    public int getBuyingPrice(){
        return this.BUYING_PRICE;
    }
    // Get the BuyingPrice of object

    public int getExperiencePoint(){
        return this.EXPERIMENT_POINT;
    } // Get the ExperiencePoint of object


}
