package com.farmgame.usecase;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Store;
import com.farmgame.entity.Item.Item;

public class StoreManager<T> implements Storetranscation, Tradable {
    private final Store store;
    private final T object;

    public StoreManager(Store store, T object) {
        this.store = store;
        this.object = object;
    }

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

    @Override
    public void updatewarehouse(WarehouseManager warehouseManager) {
        if (this.object instanceof Item) {
            warehouseManager.addItem((Item) this.object);
        } else {
            warehouseManager.addPlant((Plants) this.object);
        }
    }

    @Override
    public void sell(Plants plants, PlayerManager playerManager, WarehouseManager
            warehouseManager) {
        int sellingprice = plants.getSellingPrice();
        playerManager.addMoney(sellingprice);
        warehouseManager.removePlant(plants);
    }
}