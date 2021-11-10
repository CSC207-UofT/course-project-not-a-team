package com.farmgame.usecase;

import com.farmgame.usecase.PlayerManager;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Item.Item;

public interface Storetranscation {
    boolean makepurchase(PlayerManager playerManager,
                         WarehouseManager warehouseManager);
    void updatewarehouse(WarehouseManager warehouseManager);
    void sell(Plants plants, PlayerManager playerManager, WarehouseManager warehouseManager);
}
