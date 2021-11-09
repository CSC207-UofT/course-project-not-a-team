package com.farmgame.usecase;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Store;
import com.farmgame.entity.Item.Item;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.WarehouseManager;

public class StorePurchaseManager implements StorePurchase, Tradable{
    private final Store store;

    public StorePurchaseManager(Store store){
        this.store = store;
    }

    @Override
    public int getPrice(Object object) {
        if (object instanceof Fertilizer) {
            if (this.store.getCurrentProducts_items().contains((object)){
                return ((Fertilizer) object).getPrice();
            }
        } else if (object instanceof Plants) {
            if (this.store.getcurrentProducts_plants().contains(object)) {
                return ((Plants) object).getBuyingPrice();
            }
        }
    }

    @Override
    public boolean checkvalidity(Object object) {
        return getPrice(object) <= this.store.getPlayerMoney();
    }


    @Override
    public void makepurchase(Object object, PlayerManager playermanager) {
        if (checkvalidity(object)){
            playermanager.subtractMoney(getPrice(object));
    }



//    @Override
//    public int getSellingPrice(Object object){
//        if (object instanceof Item){
//            if (this.store.getCurrentProducts_items().contains(object)){
//                return ((Item) object).
//            }
//        }
//        elif (object instanceof Plants){
//            if (this.store)
//        }



    }

    @Override
    public void updatewarehouse(Object object, WarehouseManager warehouseManager) {
        warehouseManager.addItem(warehouseManager, (Item) object);

    }

//    public void storeLevelUp(Store store, int level){
//        store.setStoreLevel(level+1);
//    }
//
//    public void sellToPlayer(Store store){
//        /*
//        Display all current products, allow player to choose what to buy.
//        Plants selling price varies according to the date.
//        Calculate total payment, check if player has enough money to pay.
//        If not, the order fails and display a warning message.
//        If yes, money deduct from player, and add purchased products to player's warehouse
//         */
//    }
//    public void purchaseTools(){
//        /*
//        Display all items(only fertilizer for now), , allow player to choose what to buy.
//        Calculate total payment, check if player has enough money to pay.
//        If not, the order fails and display a warning message.
//        If yes, money deduct from player, and add purchased products to player's warehouse
//         */
//    }
//    public void buyFromPlayer(Store store, List<Plants> plants){
//        /*
//        The input includes a list of products player wants to sell.
//        Plants buying price varies according to the date.
//        Calculate total payment, remove the sold plants from player's warehouse, add money to player.
//         */
//    }
}
