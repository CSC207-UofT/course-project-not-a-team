package com.farmgame.usecase;

import com.farmgame.usecase.PlayerManager;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Item.Item;

public interface StorePurchase<Item> {
    void makepurchase(Item object, PlayerManager playerManager);
    void updatewarehouse(Item object, WarehouseManager warehouseManager);
}
