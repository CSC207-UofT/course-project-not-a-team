package com.farmgame.usecase;

import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Warehouse;

import java.util.ArrayList;

public class WarehouseManager {
    public void addItem(Warehouse warehouse, Item item) {
        ArrayList<Item> lst = warehouse.getItemInventory();
        lst.add(item);
        warehouse.setItemInventory(lst);
    }

    public void removeItem(Warehouse warehouse, Item item) {
        ArrayList<Item> lst = warehouse.getItemInventory();
        lst.remove(item);
        warehouse.setItemInventory(lst);
    }

    public void addPlant(Warehouse warehouse, Plants plant){
        ArrayList<Plants> lst = warehouse.getPlantInventory();
        lst.add(plant);
        warehouse.setPlantInventory(lst);
    }


    public void removePlant(Warehouse warehouse, Plants plant){
        ArrayList<Plants> lst = warehouse.getPlantInventory();
        lst.remove(plant);
        warehouse.setPlantInventory(lst);
    }

    public void upgradeCapacity(Warehouse warehouse) {
        warehouse.setCapacity(warehouse.getCapacity() + 5);
    }

    public void upgradeCapacity(Warehouse warehouse, int capacity) {
        warehouse.setCapacity(capacity);
    }
}