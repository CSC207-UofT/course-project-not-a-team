package com.farmgame.entity;


import com.farmgame.entity.Item.Item;

import java.util.ArrayList;
import java.util.List;


public class Store {
//    int StoreLevel;
//    int PlayerMoney;
    List<Plants> currentPlants;
    List<Item> currentItem;
    List<Seeds> currentSeed;
    /**
     * User can use store to buy plants, sell plants. Sold plants are
     * automatically stored into warehouse.
     * totalProducts is a List of plants sells in store in TOTAL
     * currentProducts ArrayList of plants that sells in store(current level)
     * StoreLevel an integer that shows the level of the store
     */
    public Store(ArrayList<Plants> plantList, ArrayList<Seeds> seedList, ArrayList<Item> itemList){
        //constructor, take StoreLevel as parameter, initiate ArrayList currentProducts given the StoreLevel
        //this.StoreLevel = playerManager.getPlayer().getLevel();
//        this.PlayerMoney = playerManager.getPlayer().getMoney()
        this.currentPlants = plantList;
        this.currentSeed = seedList;
        this.currentItem = itemList;

    }

    /**
     * Return the current plants list
     * @return List
     */
    public List<Plants> getCurrentProducts_plants(){
        return new ArrayList<>(this.currentPlants);
    }

    public List<Seeds> getCurrentSeed(){
        return new ArrayList<>(this.currentSeed);
    }

    /**
     * Return the current item list
     * @return List
     */
   public List<Item> getCurrentProducts_items(){
       return new ArrayList<>(this.currentItem);
   }

//    /**
//     * Return the current player money
//     * @return int
//     */
//    public int getPlayerMoney() {
//        return PlayerMoney;
//    }
}
