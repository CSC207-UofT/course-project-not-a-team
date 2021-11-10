package com.farmgame.usecase.StoreManager;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Store;
import com.farmgame.entity.Item.Item;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.WarehouseManager;

public class StoreManager<T> implements Storetranscation, Tradable {
    /**
     * StoreManager is a class that manages the buying and selling transaction between player
     * and store. The player can only trade plants, items with store. The attribute store is the
     * store this class will manage, the attribute object can either be item or plants.
     */
    private final Store store;
    private final T object;

    public StoreManager(Store store, T object) {
        this.store = store;
        this.object = object;
    }

    /**
     * Return the price of the object.
     */

    @Override
    public int getObjectPrice() {
        if (this.object instanceof Item) {
            if (this.store.getCurrentProducts_items().contains((this.object))) {
                return ((Fertilizer) object).getPrice();
            }
        } else if (this.object instanceof Plants) {
            if (this.store.getcurrentProducts_plants().contains(this.object)) {
                return ((Plants) object).getBuyingPrice();
            }
        }
        return MISSING_PRICE;
    }

    /**
     * Check if it is valid to buy. The transaction is valid if and only if the
     * player has enough money to purchase.
     * @return boolean
     */

    @Override
    public boolean checkvalidity() {
        if (getObjectPrice() == -1){
            return false;
        }
        else if (this.object instanceof Item) {
            return getObjectPrice() <= this.store.getPlayerMoney();
        }
        else {
            return ((Plants) this.object).getBuyingPrice() <= this.store.getPlayerMoney();
        }
    }

    /**
     * If the buy is valid, then subtract money from this player's account and then add
     * this object to warehouse.
     * @param playermanager: The player manager
     * @param warehouseManager: The warehouse manager
     * @return boolean
     */
    @Override
    public boolean makepurchase(PlayerManager playermanager,
                                WarehouseManager warehouseManager) {
        if (checkvalidity()) {
            playermanager.subtractMoney(getObjectPrice());
            updatewarehouse(warehouseManager);
            return true;
        }
        return false;
    }

    /**
     * If the buy is successful, add the object to the warehouse.
     * @param warehouseManager: The warehouse manager.
     */
    @Override
    public void updatewarehouse(WarehouseManager warehouseManager) {
        if (this.object instanceof Item) {
            warehouseManager.addItem((Item) this.object);
        } else {
            warehouseManager.addPlant((Plants) this.object);
        }
    }

    /**
     * The player will only sell plants to store. After the selling, the player money will increase
     * and the warehouse will add the new item
     * @param plants: The plants the player wants to sell
     * @param playerManager: The player manager
     * @param warehouseManager: The warehouse manager
     */
    @Override
    public void sell(Plants plants, PlayerManager playerManager, WarehouseManager
            warehouseManager) {
        int sellingprice = plants.getSellingPrice();
        playerManager.addMoney(sellingprice);
        warehouseManager.removePlant(plants);
    }
}