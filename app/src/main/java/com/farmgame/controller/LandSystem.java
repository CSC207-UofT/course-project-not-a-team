package com.farmgame.controller;

import static com.farmgame.constants.Constants.TYPE_FERTILIZER;
import static com.farmgame.constants.Constants.TYPE_WATERING_CAN;
import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Item.WateringCan;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;
import com.farmgame.gateway.PlantDBApi;
import com.farmgame.presenter.LandPresenter;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.StoreAble;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;

import java.util.function.Predicate;


public class LandSystem {
    private final LandManager landManager;
    private final PlayerManager playerManager;
    private final WarehouseManager warehouseManager;



    public LandSystem(LandManager landManager, PlayerManager playerManager, WarehouseManager warehouseManager) {
        this.landManager = landManager;
        this.playerManager = playerManager;
        this.warehouseManager = warehouseManager;
    }



    public void unlockLand() {
        LandPresenter landPresenter = new LandPresenter();
        if (landManager.getLand().getLockStatus() == 0) {
            landManager.getLand().setLockStatus(1);
            // inform player that he/she has unlocked the land successfully
            landPresenter.lockSuccess();

        }
        else {
            // return error: invalid initial lock status. This should happen during game
        }
    }



    public void buyLand() {
        LandPresenter landPresenter = new LandPresenter();
        if (landManager.getLand().getLockStatus() == 1) {
            if (playerManager.subtractMoney(landManager.getLand().getPrice())) {
                landManager.getLand().setLockStatus(2);
                // inform player that he/she has bought the land successfully
                landPresenter.buySuccess();

            }
            else {
                landPresenter.not_enough_money();
                landPresenter.remaining_money(playerManager.getPlayer().getMoney());
                // inform player that he/she doesn't have enough money to buy
            }
        }
        else {
            // return error" invalid initial lock status. This should happen during game
        }
    }



    public void planting(String plant) {
        LandPresenter landPresenter = new LandPresenter();
        Seeds seed = this.warehouseManager.getWarehouse().getSeeds(plant);
        if (landManager.getLand().getLockStatus() == 2
                && landManager.getLand().getPlant() == null
                && seed !=null) {
            landManager.planting(seed);
            warehouseManager.removeProduct(seed);
            // inform player that he/she has planted the plant successfully
            landPresenter.plantSuccess();
        }
        else if (landManager.getLand().getLockStatus() != 2) {
            // inform player that this land hasn't been owned by him/her
            landPresenter.invalidLand();
        }
        else if (landManager.getLand().getPlant() != null) {
            // inform player that this land has been planted already
            landPresenter.landOccupied();
        }
        else if (seed == null) {
            // inform player that this seed is not in warehouse
            landPresenter.not_enough_Seed();
        }
        else {
            // an error has occurred somehow, because the above else if should cover every possible cases. Maybe call this ImplementationError?
        }
    }



    public void fertilize() {
        LandPresenter landPresenter = new LandPresenter();
        Item fertilizer = this.warehouseManager.getWarehouse().getItem(TYPE_FERTILIZER);
        if (fertilizer != null
                && landManager.getLand().getPlant() != null
                && !landManager.getLand().isFertilize()) {
            landManager.fertilize((Fertilizer) fertilizer);
            warehouseManager.removeProduct((StoreAble) fertilizer);
            // inform player that he/she has fertilized the land successfully
            landPresenter.fertilizerSuccess();
        }
        else if (fertilizer == null) {
            // inform player that the warehouse has not fertilizer left
            landPresenter.not_enough_Fertilizer();
        }
        else if (landManager.getLand().getPlant() == null) {
            // inform player that this land hasn't been planted yet
            landPresenter.landNotPlant();
        }
        else if (landManager.getLand().isFertilize()) {
            // inform player that this land has been fertilized recently, thus should wait for a few minutes for next fertilization.
            landPresenter.invalidFertilize();

        }
        else {
            // an error has occurred somehow, because the above else if should cover every possible cases. Maybe call this ImplementationError?
        }
    }



    public void watering() {
        LandPresenter landPresenter = new LandPresenter();
        Item wateringCan = this.warehouseManager.getWarehouse().getItem(TYPE_WATERING_CAN);
        if (wateringCan != null
                && landManager.getLand().getPlant() != null
                && landManager.getLand().getStage() < 2
                && !landManager.getLand().isWet()) {
            landManager.watering((WateringCan) wateringCan);
            warehouseManager.removeProduct((StoreAble) wateringCan);
            // inform player that he/she has watered the land successfully
            landPresenter.waterSuccess();

        }
        else if (wateringCan == null) {
            // inform player that the warehouse has not watering can left
            landPresenter.not_enough_WaterCan();
        }
        else if (landManager.getLand().getPlant() == null) {
            // inform player that this land hasn't been planted yet
            landPresenter.landNotPlant();
        }
        else if (landManager.getLand().isWet()) {
            // inform player that this land has been water recently, thus should wait for a few minutes for next watering.
            landPresenter.invalidWater();
        }
        else if (landManager.getLand().getStage() == 2) {
            // inform player that this land has a fully grown plant, thus should not be watered
            landPresenter.invalidWaterMature();
        }
        else {
            // an error has occurred somehow, because the above else if should cover every possible cases. Maybe call this ImplementationError?
        }
    }



    public void harvest() {
        LandPresenter landPresenter = new LandPresenter();
        if (landManager.getLand().getPlant() != null
                && landManager.getLand().getStage() == 2
                && !landManager.getLand().isWet()) {
            playerManager.gainExp(landManager.getLand().getPlant().getExperiencePoint());
            int plantId = landManager.getLand().getPlant().getSeedId();
            Plants plant = PlantDBApi.createPlant(plantId);
            warehouseManager.addProduct((StoreAble) plant);
        }
        else if (landManager.getLand().getPlant() == null) {
            // inform player that this land has not been planted yet
            landPresenter.landNotPlant();
        }
        else if (landManager.getLand().getStage() < 2 | landManager.getLand().isWet()) {
            // inform player that this plant has not fully grown
            landPresenter.growingPlant();
        }
        else {
            // an error has occurred somehow, because the above else if should cover every possible cases. Maybe call this ImplementationError?
        }
    }
}
