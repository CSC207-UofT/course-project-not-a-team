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

public class StoreSystem extends System {
    /**
     * StoreManager is a class that manages the buying and selling transaction between player
     * and store. The player can only trade plants, items with store. The attribute store is the
     * store this class will manage, the attribute object can either be item or plants.
     */
     private Store store;
     private final PlayerManager playerManager;
     private final WarehouseManager warehouseManager;

     public StoreSystem(Store store, PlayerManager playerManager, WarehouseManager warehouseManager) {
         this.store = store;
         this.playerManager = playerManager;
         this.warehouseManager = warehouseManager;

         this.playerManager.addObserver(this);
         this.warehouseManager.addObserver(this);
     }

     public void setStore(Store store){
         this.store = store;
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
                 if (((Seeds) object).getId() == seed.getId()){
                     return seed.getPrice();
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
     public int checkValidity(StoreAble object){
             int object_price = getPrice(object);
             if (object_price == MISSING_VALUE){
                 return MISSING_VALUE;
             }
             else if (object_price > playerManager.getPlayer().getMoney()) {
                return NOT_ENOUGH_MONEY;
             } else if (!this.warehouseManager.getWarehouse().checkCapacity()) {
                 return NOT_ENOUGH_SPACE;
             } else {
                 return SUCCESS;
             }
         }
     /**
     * If the buy is valid, then subtract money from this player's account and then add
     * this object to warehouse.
     *
     * @param  object: The object the player wants to purchase.
     */
     public String makePurchase(StoreAble object) {
         StorePresenter storePresenter = new StorePresenter();
         String message = "";
         if (checkValidity(object) == MISSING_VALUE){
             message += storePresenter.invalid_product() + "\n";
         }
         else if (checkValidity(object) == SUCCESS) {
             playerManager.subtractMoney(getPrice(object));
             message += storePresenter.purchase_success() + "\n";
             message += storePresenter.remaining_money(playerManager.getPlayer().getMoney()) + "\n";
             message += updateWarehouse(object) + "\n";
         }
         else if (checkValidity(object) == NOT_ENOUGH_MONEY){
             message += storePresenter.not_enough_money();
         }
         else if (checkValidity(object) == NOT_ENOUGH_SPACE){
             message += storePresenter.not_enough_capacity();
         }
         return message;
     }
     /**
     * If the buy is successful, add the object to the warehouse.
     *
     *  @param object: The purchased object
     */
     public String updateWarehouse(StoreAble object) {
         StorePresenter storePresenter = new StorePresenter();
         String message = "";
         warehouseManager.addProduct(object);
         message += storePresenter.update_success() + "\n";
         return message;
     }

     /**
     * The player will only sell plants to store. After the selling, the player money will increase
     * and the warehouse will add the new item
     *
     * @param object: The object the player wants to sell, only plants are allowed to sell
     */
     public String sell(StoreAble object) {
         StorePresenter storePresenter = new StorePresenter();
         StringBuilder message = new StringBuilder();
         if (object instanceof Plants) {
             for (Plants plant : this.store.getCurrentProducts_plants()){
                 if (plant.getId() == ((Plants) object).getId()){
                 int sellingPrice = object.getPrice();
                 playerManager.addMoney(sellingPrice);
                 warehouseManager.removeProduct(object);
                 message.append(storePresenter.sell_success(
                         playerManager.getPlayer().getMoney())).append("\n");
             }
            }
        }
         else {
             message.append(storePresenter.sell_fail()).append("\n");
         }
         return message.toString();
    }
    
}

