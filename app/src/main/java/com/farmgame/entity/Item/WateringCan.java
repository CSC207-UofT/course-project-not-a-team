package com.farmgame.entity.Item;

import com.farmgame.entity.LandEntity;

public class WateringCan implements Item{
    /**
     * WateringCan is a class that implements Item interface, it has a fixed price, which is 5. Its
     * purpose is to water a land if necessary.
     */
    private final int price;
    private final String itemname;

    public WateringCan(){
        this.price = 5;
        this.itemname = "WateringCan";
    }

    /**
     * A getter method for the price of watering can.
     *
     * @return the price of watering can
     */
    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getName(){
        return this.itemname;
    }
    /**
     * Water the land with watering can.
     *
     * @param land the land in which the watering can is used.
     */
    @Override
    public void use(LandEntity land) {
        land.setWaterTime(land.getPlant().getPlantingTime());
        land.addStage();
    }
}
