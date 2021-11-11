package com.farmgame.entity;


import com.farmgame.usecase.PlayerManager;

import java.util.ArrayList;
import java.util.List;


public class Store {
    //List<Plants> totalProducts;             //we need to define later
    int StoreLevel;
    int PlayerMoney;
    List<Integer> currentProducts;
    List<Integer> totalProducts_plants;

    List<Integer> currentItem;
    /**
     * User can use store to buy plants, sell plants. Sold plants are
     * automatically stored into warehouse.
     * totalProducts is a List of plants sells in store in TOTAL
     * currentProducts ArrayList of plants that sells in store(current level)
     * StoreLevel an integer that shows the level of the store
     */
    public Store(PlayerManager playerManager){
        //constructor, take StoreLevel as parameter, initiate ArrayList currentProducts given the StoreLevel
        this.StoreLevel = playerManager.getPlayer().getLevel();
        this.PlayerMoney = playerManager.getPlayer().getMoney();
        this.totalProducts_plants = new ArrayList<>();
        this.currentProducts = this.totalProducts_plants.subList(0, this.StoreLevel);
        this.currentItem = new ArrayList<>();

    }

    /**
     * Return the current plants list
     * @return List
     */
    public List<Integer> getCurrentProducts_plants(){
        return new ArrayList<>(this.currentProducts);
    }

    /**
     * Return the current item list
     * @return List
     */
   public List<Integer> getCurrentProducts_items(){
       return new ArrayList<>(this.currentItem);
   }

    /**
     * Return the current player money
     * @return int
     */
    public int getPlayerMoney() {
        return PlayerMoney;
    }
}
