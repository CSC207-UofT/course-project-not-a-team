package com.farmgame.entity.Item;

import static com.farmgame.constants.Constants.TYPE_WATERING_CAN;

import com.farmgame.entity.LandEntity;


public class WateringCan extends Item {

    /**
     * Constructor of WateringCan.
     */
    public WateringCan(int price, int id){
        super(price, TYPE_WATERING_CAN, id);
    }


    /**
     * Return the type of watering can
     *
     * @return the type of watering can
     */
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
