package com.farmgame.entity.Item;

import com.farmgame.entity.LandEntity;

public class Fertilizer implements Item{
    /**
     * Fertilizer is a class that implements Item interface, it has a fixed price, which is 10. Its
     * purpose is to fertilize a land if necessary.
     */
    private final int price;
    private final String itemname;

    public Fertilizer(){
        this.price = 10;
        this.itemname = "Fertilizer";
    }

    /**
     * A getter method for the price of fertilizer.
     *
     * @return the price of fertilizer.
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
     * Fertilize the land with fertilizer.
     *
     * @param land the land in which the fertilizer is used.
     */
    @Override
    public void use(LandEntity land) {
        // usage of fertilizer
    }
}
