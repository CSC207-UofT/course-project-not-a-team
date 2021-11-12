package com.farmgame.controller.LandActivitySystem;

import static com.farmgame.constants.Constants.TYPE_FERTILIZER;
import static com.farmgame.constants.Constants.TYPE_WATERING_CAN;

import com.farmgame.controller.System;
import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Item.WateringCan;
import com.farmgame.presenter.LandPresenter.PlantStatusPresenter;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.StoreAble;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;

public class LandManagePlantStatusSystem extends System {
    private final WarehouseManager warehouseManager;
    private final LandManager landManager;

    public LandManagePlantStatusSystem(WarehouseManager warehouseManager, LandManager landManager) {
        this.warehouseManager = warehouseManager;
        this.landManager = landManager;
    }

    public void fertilize() {
        PlantStatusPresenter plantStatusPresenter = new PlantStatusPresenter();
        Item fertilizer = this.warehouseManager.getWarehouse().getItem(TYPE_FERTILIZER);
        if (fertilizer != null
                && landManager.getLand().getPlant() != null
                && !landManager.getLand().isFertilize()) {
            landManager.fertilize((Fertilizer) fertilizer);
            warehouseManager.removeProduct((StoreAble) fertilizer);
            // inform player that he/she has fertilized the land successfully
            plantStatusPresenter.fertilizerSuccess();

        }
        else if (fertilizer == null) {
            // inform player that the warehouse has not fertilizer left
            plantStatusPresenter.not_enough_Fertilizer();

        }
        else if (landManager.getLand().getPlant() == null) {
            // inform player that this land hasn't been planted yet
            plantStatusPresenter.landNotPlant();
        }
        else if (landManager.getLand().isFertilize()) {
            // inform player that this land has been fertilized recently, thus should wait for a few minutes for next fertilization.
            plantStatusPresenter.invalidFertilize();
        }
        else {
            // an error has occurred somehow, because the above else if should cover every possible cases. Maybe call this ImplementationError?
        }
    }



    public void watering() {
        PlantStatusPresenter plantStatusPresenter = new PlantStatusPresenter();
        Item wateringCan = this.warehouseManager.getWarehouse().getItem(TYPE_WATERING_CAN);
        if (wateringCan != null
                && landManager.getLand().getPlant() != null
                && landManager.getLand().getStage() < 2
                && !landManager.getLand().isWet()) {
            landManager.watering((WateringCan) wateringCan);
            warehouseManager.removeProduct((StoreAble) wateringCan);
            // inform player that he/she has watered the land successfully
        }
        else if (wateringCan == null) {
            // inform player that the warehouse has not watering can left
            plantStatusPresenter.not_enough_WaterCan();
        }
        else if (landManager.getLand().getPlant() == null) {
            // inform player that this land hasn't been planted yet
            plantStatusPresenter.landNotPlant();
        }
        else if (landManager.getLand().isWet()) {
            // inform player that this land has been water recently, thus should wait for a few minutes for next watering.
            plantStatusPresenter.invalidWater();
        }
        else if (landManager.getLand().getStage() == 2) {
            // inform player that this land has a fully grown plant, thus should not be watered
            plantStatusPresenter.invalidWaterMature();
        }
        else {
            // an error has occurred somehow, because the above else if should cover every possible cases. Maybe call this ImplementationError?
        }
    }
}
