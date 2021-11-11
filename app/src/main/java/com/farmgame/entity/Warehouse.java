package com.farmgame.entity;

import com.farmgame.entity.Item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Warehouse {
    private int capacity;
    private HashMap<Integer, ArrayList<Item>> itemInventory;
    private HashMap<Integer, ArrayList<Plants>> plantInventory;
    private HashMap<Integer, ArrayList<Seeds>> seedInventory;


    /**
     * Warehouse is a place where player can store items and plants.
     * Warehouse's capacity increases based on the player's level
     * @param player The warehouse's capacity will increase as the player's level increase.
     */
    public Warehouse(Player player, HashMap<Integer, ArrayList<Item>> itemInventory, HashMap<Integer,
            ArrayList<Plants>> plantInventory, HashMap<Integer, ArrayList<Seeds>> seedInventory){
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
        }else{
            this.capacity = 100;
        }
        this.itemInventory = itemInventory;
        this.plantInventory = plantInventory;
        this.seedInventory = seedInventory;
    }

    /**
     * get item inventory
     * @return an arraylist that represents item inventory
     */
    public HashMap<Integer, ArrayList<Item>> getItemInventory() {
        return itemInventory;
    }

    /**
     * given an arraylist, set it to item inventory
     * @param itemInventory an arraylist of items
     */
    public void setItemInventory(HashMap<Integer, ArrayList<Item>> itemInventory) {
        this.itemInventory = itemInventory;
    }

    /**
     * get seed inventory
     * @return an arraylist that represents seed inventory
     */
    public HashMap<Integer, ArrayList<Seeds>> getSeedInventory() {
        return seedInventory;
    }

    /**
     * given an arraylist, set it to seed inventory
     * @param seedInventory an arraylist of items
     */
    public void setSeedInventory(HashMap<Integer, ArrayList<Seeds>> seedInventory) {
        this.seedInventory = seedInventory;
    }

    /**
     * get plant inventory
     * @return an arraylist that represents plant inventory
     */
    public HashMap<Integer, ArrayList<Plants>> getPlantInventory() {
        return plantInventory;
    }

    /**
     *  given an arraylist, set it to plant inventory,
     * @param plantInventory an arraylist of plants
     */
    public void setPlantInventory(HashMap<Integer, ArrayList<Plants>> plantInventory) {
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

    /**
     * check if s is contained in item inventory/plant inventory
     * @param s string s that need to be checked
     * @return true if s is contained, false otherwise
     */
    public Boolean contains(String s){
        for(ArrayList<Item> itemList: this.itemInventory.values()){
            if (itemList.get(0).getName().equals(s)){
                return true;
            }
        }
        for(ArrayList<Plants> plantsList: this.plantInventory.values()){
            if (plantsList.get(0).getName().equals(s)){
                return true;
            }
        }
        for(ArrayList<Seeds> seedsArrayList: this.seedInventory.values()){
            if (seedsArrayList.get(0).getName().equals(s)){
                return true;
            }
        }
        return false;
    }

    public Boolean checkCapacity(){
        int use = 0;
        for(ArrayList<Plants> plantsArrayList: this.plantInventory.values()){
            use += plantsArrayList.size();
        }
        for(ArrayList<Seeds> seedsArrayList: this.seedInventory.values()){
            use += seedsArrayList.size();
        }
        for(ArrayList<Item> itemArrayList: this.itemInventory.values()){
            use += itemArrayList.size();
        }
        return use < this.capacity;

    }

    public Plants getPlants(String plant){
        for(ArrayList<Plants> plantsArrayList: this.plantInventory.values()){
            if(plantsArrayList.get(0).getName().equals(plant)){
                return plantsArrayList.get(0);
            }
        }
        return null;
    }
    public Seeds getSeeds(String seed){
        for(ArrayList<Seeds> seedsArrayList: this.seedInventory.values()){
            if(seedsArrayList.get(0).getName().equals(seed)){
                return seedsArrayList.get(0);
            }
        }
        return null;
    }
    public Item getItem(String item){
        for(ArrayList<Item> itemArrayList: this.itemInventory.values()){
            if(itemArrayList.get(0).getName().equals(item)){
                return itemArrayList.get(0);
            }
        }
        return null;
    }
}



