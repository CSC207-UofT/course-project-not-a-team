package com.farmgame.viewModel;

import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;
import com.farmgame.entity.Store;
import com.farmgame.entity.Item.Item;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.StoreAble;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;
import static com.farmgame.constants.Constants.*;
import static com.farmgame.constants.Message.*;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreSystem extends System {
    /**
     * StoreManager is a class that manages the buying and selling transaction between player
     * and store. The player can only trade plants, items with store. The attribute store is the
     * store this class will manage, the attribute object can either be item or plants.
     */
    private Store store;
    private final PlayerManager playerManager;
    private final WarehouseManager warehouseManager;

    /**
     * Constructor for StoreSystem
     *
     * @param store the store that StoreSystem interacts with
     * @param playerManager the player(manager) that StoreSystem interacts with
     * @param warehouseManager the warehouse(manager) that StoreSystem interacts with
     */
    public StoreSystem(Store store, PlayerManager playerManager, WarehouseManager warehouseManager) {
        this.store = store;
        this.playerManager = playerManager;
        this.warehouseManager = warehouseManager;

        this.playerManager.addObserver(this);
        this.warehouseManager.addObserver(this);
    }

    /**
     * setter of store
     *
     * @param store store to be set
     */
    public void setStore(Store store){
        this.store = store;
    }

    /**
     * getter of store
     *
     * @return the store used by StoreSystem
     */
    public Store getStore() {
        return store;
    }

    /**
     * Return the price of the object.
     *
     * @return int: return the price of this plant
     */
    public int getPrice(StoreAble object) {
        if (object instanceof Item) {
            for (Item item : this.store.getCurrentProducts_items()){
                if (object.getId() == item.getId()){
                    return item.getPrice();
                }
            }

        } else if (object instanceof Seeds) {
            for (Seeds seed : this.store.getCurrentSeed()){
                if (object.getId() == seed.getId()){
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
    public int checkValidity(StoreAble object, int quantity){
        int object_price = getPrice(object);
        if (object_price == MISSING_VALUE){
            return MISSING_VALUE;
        }
        else if (object_price * quantity > playerManager.getPlayer().getMoney()) {
            return NOT_ENOUGH_MONEY;
        } else if (!this.warehouseManager.getWarehouse().checkCapacity(quantity)) {
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
    public String makePurchase(StoreAble object, int quantity) {
        String message = "";
        if (checkValidity(object, quantity) == MISSING_VALUE){
            message += INVALID_PRODUCT + "\n";
        }
        else if (checkValidity(object, quantity) == SUCCESS) {
            playerManager.subtractMoney(getPrice(object) * quantity);
            message += PURCHASE_SUCCESS + "\n";
            message += updateWarehouse(object, quantity) + "\n";
        }
        else if (checkValidity(object, quantity) == NOT_ENOUGH_MONEY){
            message += NO_ENOUGH_MONEY;
        }
        else if (checkValidity(object, quantity) == NOT_ENOUGH_SPACE){
            message += NOT_ENOUGH_CAPACITY;
        }
        return message;
    }

    /**
     * If the buy is successful, add the object to the warehouse.
     *
     *  @param object: The purchased object
     */
    public String updateWarehouse(StoreAble object, int quantity) {
        String message = "";
        warehouseManager.addProduct(object, quantity);
        message += UPDATE_SUCCESS + "\n";
        return message;
    }

    /**
     * The player will only sell plants to store. After the selling, the player money will increase
     * and the warehouse will add the new item
     *
     * @param object: The object the player wants to sell, only plants are allowed to sell
     */
    public String sell(StoreAble object) {
        StringBuilder message = new StringBuilder();
        if (object instanceof Plants) {
            for (Plants plant : this.store.getCurrentProducts_plants()){
                if (plant.getId() == object.getId()){
                    int sellingPrice = object.getPrice();
                    playerManager.addMoney(sellingPrice);
                    warehouseManager.removeProduct(object);
                    message.append(
                            SELL_SUCCESS).append(playerManager.getPlayer().getMoney()).append("\n");
                }
            }
        }
        else {
            message.append(SELL_FAIL).append("\n");
        }
        return message.toString();
    }

    /**
     * The player will sell all of the plants to store
     */
    public String sellAll() {
        HashMap<Integer, ArrayList<Plants>> plantInventory =  warehouseManager.getWarehouse().
                getPlantInventory();
        for (ArrayList<Plants> plants : plantInventory.values()){
            playerManager.addMoney(plants.get(0).getPrice() * plants.size());
        }
        warehouseManager.removeAllPlants();
        return SELL_SUCCESS + playerManager.getPlayer().getMoney() + "\n";
    }
}