package com.farmgame.usecase.StoreManager;

import com.farmgame.usecase.PlayerManager;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Item.Item;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;
import com.farmgame.usecase.StoreAble;

public interface Storetranscation {
    boolean makepurchase(StoreAble object, PlayerManager playerManager,
                         WarehouseManager warehouseManager);
    void updatewarehouse(StoreAble object, WarehouseManager warehouseManager);
    void sell(StoreAble object, PlayerManager playerManager, WarehouseManager warehouseManager);
}
