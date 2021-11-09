package com.farmgame.entity;

import com.farmgame.entity.Item.Item;

import java.util.ArrayList;

public class Warehouse {
    private int capacity;
    private ArrayList<Item> itemInventory;
    private ArrayList<Plants> plantInventory;

    public Warehouse(){
        this.capacity = 5;
        this.itemInventory = new ArrayList<>();
        this.plantInventory = new ArrayList<>();
    }

    public ArrayList<Item> getItemInventory() {
        return itemInventory;
    }

    public void setItemInventory(ArrayList<Item> itemInventory) {
        this.itemInventory = itemInventory;
    }

    public ArrayList<Plants> getPlantInventory() {
        return plantInventory;
    }

    public void setPlantInventory(ArrayList<Plants> plantInventory) {
        this.plantInventory = plantInventory;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
