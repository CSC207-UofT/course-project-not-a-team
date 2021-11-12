package com.farmgame.entity.Item;

import static com.farmgame.constants.Constants.TYPE_FERTILIZER;
import com.farmgame.entity.LandEntity;
import com.farmgame.usecase.StoreAble;



public class Fertilizer implements Item, StoreAble {
    /**
     * Fertilizer is a class that implements Item interface, it has a fixed price, which is 10. Its
     * purpose is to fertilize a land if required. It also implements the store-able interface.
     */
    private final int price;
    private final String item_name;
    private final int id;



    /**
     * Constructor for Fertilizer.
     */
    public Fertilizer(){
        this.price = 10;
        this.item_name = TYPE_FERTILIZER;
        this.id = 14159;
    }



    /**
     * A getter method for the id of fertilizer.
     *
     * @return the id of fertilizer.
     */
    @Override
    public int getId() {
        return this.id;
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



    /**
     * A getter method for the name of fertilizer.
     *
     * @return the name of fertilizer.
     */
    @Override
    public String getName(){
        return this.item_name;
    }

    @Override
    public String getType() {
        return TYPE_FERTILIZER;
    }


    /**
     * Fertilize the land with fertilizer.
     *
     * @param land the land in which the fertilizer is used.
     */
    @Override
    public void use(LandEntity land) {
        land.addStage();
    }
}
