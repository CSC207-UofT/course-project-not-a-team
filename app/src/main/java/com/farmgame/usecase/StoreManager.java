package com.farmgame.usecase;

import com.farmgame.entity.Plants;
import com.farmgame.entity.Store;

import java.util.List;

public class StoreManager {
    public void storeLevelUp(Store store, int level){
        store.setStoreLevel(level+1);
    }

    public void sellToPlayer(Store store){
        /*
        Display all current products, allow player to choose what to buy.
        Plants selling price varies according to the date.
        Calculate total payment, check if player has enough money to pay.
        If not, the order fails and display a warning message.
        If yes, money deduct from player, and add purchased products to player's warehouse
         */
    }
    public void purchaseTools(){
        /*
        Display all items(only fertilizer for now), , allow player to choose what to buy.
        Calculate total payment, check if player has enough money to pay.
        If not, the order fails and display a warning message.
        If yes, money deduct from player, and add purchased products to player's warehouse
         */
    }
    public void buyFromPlayer(Store store, List<Plants> plants){
        /*
        The input includes a list of products player wants to sell.
        Plants buying price varies according to the date.
        Calculate total payment, remove the sold plants from player's warehouse, add money to player.
         */
    }
}