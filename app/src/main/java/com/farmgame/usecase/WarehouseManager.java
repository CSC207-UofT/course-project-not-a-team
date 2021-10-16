package com.farmgame.usecase;

import com.farmgame.Item.Item;
import com.farmgame.entity.Warehouse;

import java.util.ArrayList;

public class WarehouseManager {
    public void addItem(Warehouse warehouse, Item item) {
        ArrayList<Item> lst = warehouse.getInventory();
        lst.add(item);
        warehouse.setInventory(lst);
    }

    public void removeItem(Warehouse warehouse, Item item) {
        ArrayList<Item> lst = warehouse.getInventory();
        lst.remove(item);
        warehouse.setInventory(lst);
    }

    public void upgradeCapacity(Warehouse warehouse) {
        warehouse.setCapacity(warehouse.getCapacity() + 5);
    }

    public void upgradeCapacity(Warehouse warehouse, int capacity) {
        warehouse.setCapacity(capacity);
    }
}