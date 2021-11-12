package com.farmgame.controller;

import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;
import com.farmgame.entity.Store;
import com.farmgame.entity.Item.Item;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.StoreAble;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;
import com.farmgame.presenter.StorePresenter;
import static com.farmgame.constants.Constants.*;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class StoreSystem extends System {
    /**
     * StoreManager is a class that manages the buying and selling transaction between player
     * and store. The player can only trade plants, items with store. The attribute store is the
     * store this class will manage, the attribute object can either be item or plants.
     */
     private final Store store;
     private final PlayerManager playerManager;
     private final WarehouseManager warehouseManager;

     public StoreSystem(Store store, PlayerManager playerManager, WarehouseManager warehouseManager) {
         this.store = store;
         this.playerManager = playerManager;
         this.warehouseManager = warehouseManager;

         this.playerManager.addObserver(this);
         this.warehouseManager.addObserver(this);
     }

     /**
     * Return the price of the object.
      * @return int: return the price of this plant
      */

     public int getPrice(StoreAble object) {
         if (object instanceof Item) {
             for (Item item : this.store.getCurrentProducts_items()){
                 if (((Item) object).getId() == item.getId()){
                     return item.getPrice();
                 }
             }

         } else if (object instanceof Seeds) {
             for (Seeds seed : this.store.getCurrentSeed()){
                 if (((Seeds) object).getSeedId() == seed.getSeedId()){
                     return seed.getBuyingPrice();
                 }
             }
     }
         return MISSING_VALUE;
     }

     /**
     * Check if it is valid to buy. The transaction is valid if and only if the
     * player has enough money to purchase.
     *
     * @return boolean
     */
     public boolean checkValidity(StoreAble object){
             StorePresenter storePresenter = new StorePresenter();
             int object_price = getPrice(object);
             if (object_price == MISSING_VALUE){
                 storePresenter.invalid_product();
                 return false;
             }
             else if (object_price > playerManager.getPlayer().getMoney()) {
                 storePresenter.not_enough_money();
                 return false;
             } else if (!this.warehouseManager.getWarehouse().checkCapacity()) {
                 storePresenter.not_enough_capacity();
                 return false;
             } else {
                 return true;
             }
         }


//         if (getObjectPrice(object) == -1) {
//                return false;
//         } else if (object instanceof Item) {
//                return getObjectPrice(object) <= this.store.getPlayerMoney();
//         } else {
//                return ((Seeds) object).getBuyingPrice() <= this.store.getPlayerMoney();

     /**
     * If the buy is valid, then subtract money from this player's account and then add
     * this object to warehouse.
     *
     * @param  object: The object the player wants to purchase.
     */
     public void makePurchase(StoreAble object) {
         StorePresenter storePresenter = new StorePresenter();
         if (checkValidity(object)) {
             playerManager.subtractMoney(getPrice(object));
             storePresenter.purchase_success();
             storePresenter.remaining_money(playerManager.getPlayer().getMoney());
             updateWarehouse(object);
         }
     }
     /**
     * If the buy is successful, add the object to the warehouse.
     *
     *  @param object: The purchased object
     */
     public void updateWarehouse(StoreAble object) {
         StorePresenter storePresenter = new StorePresenter();
         warehouseManager.addProduct(object);
         storePresenter.update_success();
     }

     /**
     * The player will only sell plants to store. After the selling, the player money will increase
     * and the warehouse will add the new item
     *
     * @param object: The object the player wants to sell, only plants are allowed to sell
     */
     public void sell(StoreAble object) {
         StorePresenter storePresenter = new StorePresenter();
         if (object instanceof Plants) {
             for (Plants plant : this.store.getCurrentProducts_plants()){
                 if (plant.getPlantID() == ((Plants) object).getPlantID()){
                 int sellingPrice = ((Plants) object).getSellingPrice();
                 playerManager.addMoney(sellingPrice);
                 warehouseManager.removeProduct(object);
                 storePresenter.sell_success(playerManager.getPlayer().getMoney());
             }
            }
        }
    }

}

