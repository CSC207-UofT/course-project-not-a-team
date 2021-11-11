package com.farmgame.usecase.StoreManager;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;
import com.farmgame.entity.Store;
import com.farmgame.entity.Item.Item;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.StoreAble;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;

public class StoreManager implements StoreTransaction, TradeAble {
    /**
     * StoreManager is a class that manages the buying and selling transaction between player
     * and store. The player can only trade plants, items with store. The attribute store is the
     * store this class will manage, the attribute object can either be item or plants.
     */
    private final Store store;

    public StoreManager(Store store) {
        this.store = store;
    }

    /**
     * Return the price of the object.
     */

    @Override
    public int getObjectPrice(StoreAble object) {
        if (object instanceof Item) {
            if (this.store.getCurrentProducts_items().contains(((Item) object).getId())) {
                return ((Fertilizer) object).getPrice();
            }
        } else if (object instanceof Seeds) {
            if (this.store.getCurrentProducts_plants().contains(((Seeds) object).getSeedId())) {
                return ((Seeds) object).getBuyingPrice();
            }
        }
        return MISSING_PRICE;
    }

    /**
     * Check if it is valid to buy. The transaction is valid if and only if the
     * player has enough money to purchase.
     *
     * @return boolean
     */

    @Override
    public boolean checkValidity(StoreAble object) {
        if (getObjectPrice(object) == -1) {
            return false;
        } else if (object instanceof Item) {
            return getObjectPrice(object) <= this.store.getPlayerMoney();
        } else {
            return ((Seeds) object).getBuyingPrice() <= this.store.getPlayerMoney();
        }
    }

    /**
     * If the buy is valid, then subtract money from this player's account and then add
     * this object to warehouse.
     *
     * @param playerManager:    The player manager
     * @param warehouseManager: The warehouse manager
     * @return boolean
     */
    @Override
    public boolean makePurchase(StoreAble object, PlayerManager playerManager,
                                WarehouseManager warehouseManager) {
        if (checkValidity(object)) {
            playerManager.subtractMoney(getObjectPrice(object));
            updateWarehouse(object, warehouseManager);
            return true;
        }
        return false;
    }

    /**
     * If the buy is successful, add the object to the warehouse.
     *
     * @param warehouseManager: The warehouse manager.
     */
    @Override
    public void updateWarehouse(StoreAble object, WarehouseManager warehouseManager) {
        warehouseManager.addProduct(object);
    }

    /**
     * The player will only sell plants to store. After the selling, the player money will increase
     * and the warehouse will add the new item
     *
     * @param object:           The object the player wants to sell, only plants are allowed to sell
     * @param playerManager:    The player manager
     * @param warehouseManager: The warehouse manager
     */
    @Override
    public void sell(StoreAble object, PlayerManager playerManager, WarehouseManager
            warehouseManager) {
        if (object instanceof Plants) {
            int sellingPrice = ((Plants) object).getSellingPrice();
            playerManager.addMoney(sellingPrice);
            warehouseManager.removeProduct(object);
        }
    }
}