package com.farmgame.entity.Item;

import com.farmgame.entity.LandEntity;

public interface Item {

    int getPrice();

    int getId();

    String getName();

    void use(LandEntity land);
}
