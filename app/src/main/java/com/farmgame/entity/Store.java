package com.farmgame.entity;



import com.farmgame.entity.Plants;

import java.util.ArrayList;

import java.util.List;


public class Store {
    //List<Plants> totalProducts;             //we need to define later
    int StoreLevel;
    List<Plants> currentProducts;
    /**
     * User can use store to buy plants, sell plants. The price varies each day. Sold plants are
     * automatically stored into warehouse.
     * totalProducts is a List of plants sells in store in TOTAL
     * currentProducts ArrayList of plants that sells in store(current level)
     * @param StoreLevel an integer that shows the level of the store
     */
    public Store( int StoreLevel){
        //constructor, take StoreLevel as parameter, initiate ArrayList currentProducts given the StoreLevel
        this.StoreLevel = StoreLevel;
        currentProducts = new ArrayList<>();
        // currentProducts = totalProducts.subList(0, StoreLevel);

    }
    //public List<Plants> getCurrentProducts(){
        //return current products

        //return currentProducts;
    //}
    public int getStoreLevel(){
        //return store level
        return StoreLevel;
    }
    public void setStoreLevel(int level){
        //set store level
        this.StoreLevel = level;
        //currentProducts = totalProducts.subList(0, level);
    }

}
