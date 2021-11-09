package com.farmgame.entity;

import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Player;
import java.util.ArrayList;

public class Warehouse {
    private int capacity;
    private ArrayList<Item> itemInventory;
    private ArrayList<Plants> plantInventory;


    /**
     * Warehouse is a place where player can store items and plants.
     * Warehouse's capacity increases based on the player's level
     * @param player The warehouse's capacity will increase as the player's level increase.
     */
    public Warehouse(Player player){
        int playerLevel = player.getLevel();
        if (playerLevel >=1 && playerLevel <= 5){
            this.capacity = 5;
        }else if (playerLevel >5 && playerLevel <= 10){
            this.capacity = 10;
        }else if (playerLevel >10 && playerLevel <= 20){
            this.capacity = 20;
        }else if (playerLevel >20 && playerLevel <= 30){
            this.capacity = 40;
        }else if (playerLevel >30 && playerLevel <= 40){
            this.capacity = 60;
        }else (playerLevel >40){
            this.capacity = 100;
        }
        this.itemInventory = new ArrayList<>();
        this.plantInventory = new ArrayList<>();
    }

    /**
     * get item inventory
     * @return an arraylist that represents item inventory
     */
    public ArrayList<Item> getItemInventory() {
        return itemInventory;
    }

    /**
     * given an arraylist, set it to item inventory
     * @param itemInventory an arraylist of items
     */
    public void setItemInventory(ArrayList<Item> itemInventory) {
        this.itemInventory = itemInventory;
    }

    /**
     * get plant inventory
     * @return an arraylist that represents plant inventory
     */
    public ArrayList<Plants> getPlantInventory() {
        return plantInventory;
    }

    /**
     *  given an arraylist, set it to plant inventory,
     * @param plantInventory an arraylist of plants
     */
    public void setPlantInventory(ArrayList<Plants> plantInventory) {
        this.plantInventory = plantInventory;
    }

    /**
     * Get the capacity
     * @return an int that represents capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Set capacity to given integer
     * @param capacity given integer
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
