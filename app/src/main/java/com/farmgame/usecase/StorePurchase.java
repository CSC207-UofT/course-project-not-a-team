package com.farmgame.usecase;

import com.farmgame.usecase.PlayerManager;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Item.Item;

public interface StorePurchase<T> {
    void makepurchase(T object, PlayerManager playerManager);
    void updatewarehouse();
}
