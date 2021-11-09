package com.farmgame.usecase;

import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Warehouse;

import java.util.ArrayList;

public class WarehouseManager {
    /**
     * Add item to Warehouse's Item Inventory
     * @param warehouse an Warehouse instance
     * @param item an item that needs to be added to the warehouse
     */
    public void addItem(Warehouse warehouse, Item item) {
        ArrayList<Item> lst = warehouse.getItemInventory();
        lst.add(item);
        warehouse.setItemInventory(lst);
    }

    /**
     * Remove item from Warehouse's Item Inventory
     * @param warehouse an Warehouse instance
     * @param item an item that needs to be removed from the warehouse
     */
    public void removeItem(Warehouse warehouse, Item item) {
        ArrayList<Item> lst = warehouse.getItemInventory();
        lst.remove(item);
        warehouse.setItemInventory(lst);
    }

    /**
     * Add plant to Warehouse's Plant Inventory
     * @param warehouse an Warehouse instance
     * @param plant a plant that needs to be added to the warehouse
     */
    public void addPlant(Warehouse warehouse, Plants plant){
        ArrayList<Plants> lst = warehouse.getPlantInventory();
        lst.add(plant);
        warehouse.setPlantInventory(lst);
    }

    /**
     * Remove plant from Warehouse's plant Inventory
     * @param warehouse an Warehouse instance
     * @param plant a plant that needs to be removed from the warehouse
     */
    public void removePlant(Warehouse warehouse, Plants plant){
        ArrayList<Plants> lst = warehouse.getPlantInventory();
        lst.remove(plant);
        warehouse.setPlantInventory(lst);
    }


}
