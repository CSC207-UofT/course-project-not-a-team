package com.farmgame.usecase.StoreManager;

import com.farmgame.usecase.PlayerManager;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Item.Item;
import com.farmgame.usecase.WarehouseManager;

public interface Storetranscation {
    boolean makepurchase(PlayerManager playerManager,
                         WarehouseManager warehouseManager);
    void updatewarehouse(WarehouseManager warehouseManager);
    void sell(Plants plants, PlayerManager playerManager, WarehouseManager warehouseManager);
}
