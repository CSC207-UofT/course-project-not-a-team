package com.farmgame.usecase.WarehouseManager;
import com.farmgame.usecase.StoreAble;
import com.farmgame.entity.Plants;

public interface WarehouseManipulate {
    void addProduct(StoreAble object, int quantity);
    void removeProduct(StoreAble object);
}