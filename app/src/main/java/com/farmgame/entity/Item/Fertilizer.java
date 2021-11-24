package com.farmgame.entity.Item;

import static com.farmgame.constants.Constants.Fertilizer_ID;
import static com.farmgame.constants.Constants.Fertilizer_Price;
import static com.farmgame.constants.Constants.TYPE_FERTILIZER;
import com.farmgame.entity.LandEntity;



public class Fertilizer extends Item {
    /**
     * Constructor for Fertilizer.
     */
    public Fertilizer(int price, int id){
        super(price, TYPE_FERTILIZER, id);
    }


    /**
     * Return the type of fertilizer.
     *
     * @return the type of fertilizer
     */
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
        land.setFertilize(true);
    }
}
