package com.farmgame.usecase.WarehouseManager;

import com.farmgame.entity.Plants;

public interface WarehouseMunipulate {
    void addProduct(StoreAble object);
    void removeProduct(StoreAble object);
    StoreAble getProduct(String s);
}
