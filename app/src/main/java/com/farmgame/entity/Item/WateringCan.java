package com.farmgame.entity.Item;

import static com.farmgame.constants.Constants.TYPE_WATERING_CAN;
import com.farmgame.entity.LandEntity;
import com.farmgame.usecase.StoreAble;


public class WateringCan implements Item, StoreAble {
    /**
     * WateringCan is a class that implements Item interface, it has a fixed price, which is 5. Its
     * purpose is to water a land if necessary.
     */
    private final int price;
    private final String item_name;
    private final int id;



    /**
     * Constructor of WateringCan.
     */
    public WateringCan(){
        this.price = 5;
        this.item_name = TYPE_WATERING_CAN;
        this.id = 26535;
    }



    /**
     * A getter method for the price of watering can.
     *
     * @return the price of watering can.
     */
    @Override
    public int getPrice() {
        return this.price;
    }



    /**
     * A getter method for id of watering can.
     *
     * @return the id of watering can.
     */
    @Override
    public int getId() {
        return this.id;
    }



    /**
     * A getter method for the name of watering can.
     *
     * @return the name of watering can.
     */
    @Override
    public String getName(){
        return this.item_name;
    }

    @Override
    public String getType() {
        return TYPE_WATERING_CAN;
    }


    /**
     * Water the land with watering can.
     *
     * @param land the land in which the watering can is used.
     */
    @Override
    public void use(LandEntity land) {
        land.setWaterTime();
        land.addStage();
    }
}
