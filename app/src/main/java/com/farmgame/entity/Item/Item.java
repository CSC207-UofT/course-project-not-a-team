package com.farmgame.entity.Item;

import com.farmgame.entity.LandEntity;

public interface Item {

    int getPrice();
    String getName();

    void use(LandEntity land);
}
