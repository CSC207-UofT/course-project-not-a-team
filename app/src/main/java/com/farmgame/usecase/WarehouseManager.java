package com.farmgame.usecase;

import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Warehouse;

import java.util.ArrayList;

public class WarehouseManager {
    private final Warehouse warehouse;

    /**
     * Initialize warehouse
     * @param warehouse an warehouse instance
     */
    public WarehouseManager(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    /**
     * return the warehouse
     * @return warehouse
     */
    public Warehouse getWarehouse(){
        return this.warehouse;
    }

    /**
     * Add item to Warehouse's Item Inventory if capable
     * @param item an item that needs to be added to the warehouse
     */
    public void addItem(Item item) {
        ArrayList<Item> lst = this.warehouse.getItemInventory();
        if (lst.size() < this.warehouse.getCapacity()){
            lst.add(item);
            this.warehouse.setItemInventory(lst);
        }
    }

    /**
     * Remove item from Warehouse's Item Inventory
     * @param item an item that needs to be removed from the warehouse
     */
    public void removeItem( Item item) {
        ArrayList<Item> lst = this.warehouse.getItemInventory();
        lst.remove(item);
        this.warehouse.setItemInventory(lst);
    }

    /**
     * Add plant to Warehouse's Plant Inventory
     * @param plant a plant that needs to be added to the warehouse
     */
    public void addPlant( Plants plant){
        ArrayList<Plants> lst = this.warehouse.getPlantInventory();
        lst.add(plant);
        this.warehouse.setPlantInventory(lst);
    }

    /**
     * Remove plant from Warehouse's plant Inventory
     * @param plant a plant that needs to be removed from the warehouse
     */
    public void removePlant( Plants plant){
        ArrayList<Plants> lst = this.warehouse.getPlantInventory();
        lst.remove(plant);
        this.warehouse.setPlantInventory(lst);
    }


}
