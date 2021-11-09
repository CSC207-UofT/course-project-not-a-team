package com.farmgame.entity.Item;

import com.farmgame.entity.LandEntity;

public class Fertilizer implements Item{
    @Override
    public void use(LandEntity land) {
        land.setFertilize(true);
    }
}

