package com.farmgame.usecase;

import com.farmgame.entity.Player;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Item.Item

public interface StorePurchase<T, G> {
    void checkvalidity(<> object);
    void makepurchase();
    void updatewarehouse();
}
