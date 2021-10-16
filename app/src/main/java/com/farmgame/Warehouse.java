package com.farmgame;

import com.farmgame.Item.Item;

import java.util.ArrayList;

public class Warehouse {
    private int capacity;
    private ArrayList<Item> inventory;

    public Warehouse(){
        this.capacity = 5;
        this.inventory = new ArrayList<Item>();
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
