package com.farmgame.entity;

public class Plants {
    private final String PlantName;
    private final int PlantingTime;
    private final int BuyingPrice;
    private final int SellingPrice;
    private final int ExperiencePoint;

    // PlantName -- Name of plant
    // PlantingTime -- The time it takes for a plant to mature
    // BuyingPrice -- The price of the plant when you buy it
    // SellingPrice -- The price of the plant when you sell it
    // ExperiencePoint -- Experience points gained while harvesting plants

    public Plants(String name, int time, int buying, int selling, int exp) {
        this.PlantName = name;
        this.PlantingTime = time;
        this.BuyingPrice = buying;
        this.SellingPrice = selling;
        this.ExperiencePoint = exp;
    }
    // Initialize the plant.

    public String getPlantName(){
        return this.PlantName;
    }
    // Get the PlantName of object

    public int getPlantingTime(){
        return this.PlantingTime;
    }
    // Get the PlantingTime of object

    public int getSellingPrice(){
        return this.SellingPrice;
    }
    // Get the SellingPrice of object

    public int getBuyingPrice(){
        return this.BuyingPrice;
    }
    // Get the BuyingPrice of object

    public int getExperiencePoint(){
        return this.ExperiencePoint;
    } // Get the ExperiencePoint of object


}
