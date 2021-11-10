package com.farmgame.entity.Item;

import com.farmgame.entity.LandEntity;

public interface Item {
    int price = 0;

    int getPrice();

    void use(LandEntity land);
}
