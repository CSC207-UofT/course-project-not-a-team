package com.farmgame;

public class Plants {
    private final String FINAL_PLANTTIME;
    private final int FINAL_PLANTINGTIME;
    private final int FINAL_BUYINGPRICE;
    private final int FINAL_SELLINGPRICE;
    private final int FINAL_EXPERIMENTPOINT;

    // PlantName -- Name of plant
    // PlantingTime -- The time it takes for a plant to mature
    // BuyingPrice -- The price of the plant when you buy it
    // SellingPrice -- The price of the plant when you sell it
    // ExperiencePoint -- Experience points gained while harvesting plants

    public Plants(String name, int time, int buying, int selling, int exp) {
        this.FINAL_PLANTTIME = name;
        this.FINAL_PLANTINGTIME = time;
        this.FINAL_BUYINGPRICE = buying;
        this.FINAL_SELLINGPRICE = selling;
        this.FINAL_EXPERIMENTPOINT = exp;
    }
    // Initialize the plant.

    public String getPlantName(){
        return this.FINAL_PLANTTIME;
    }
    // Get the PlantName of object

    public int getPlantingTime(){
        return this.FINAL_PLANTINGTIME;
    }
    // Get the PlantingTime of object

    public int getSellingPrice(){
        return this.FINAL_SELLINGPRICE;
    }
    // Get the SellingPrice of object

    public int getBuyingPrice(){
        return this.FINAL_BUYINGPRICE;
    }
    // Get the BuyingPrice of object

    public int getExperiencePoint(){
        return this.FINAL_EXPERIMENTPOINT;
    } // Get the ExperiencePoint of object


}
