package com.farmgame.viewModel.LandActivitySystem;

import static com.farmgame.constants.Constants.TYPE_FERTILIZER;
import static com.farmgame.constants.Constants.TYPE_WATERING_CAN;
import static com.farmgame.constants.Message.*;

import com.farmgame.viewModel.System;
import com.farmgame.entity.Item.Item;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;

public class LandManagePlantStatusSystem extends System {
    private final WarehouseManager warehouseManager;
    private final LandManager landManager;

    /**
     * Constructor for LandManagePlantStatusSystem
     *
     * @param warehouseManager the warehouse(manager) that LandManagePlantStatusSystem
     *                         interacts with
     * @param landManager the land(manager) that LandManagePlantStatusSystem interacts with
     */
    public LandManagePlantStatusSystem(WarehouseManager warehouseManager, LandManager landManager) {
        this.warehouseManager = warehouseManager;
        this.landManager = landManager;

        this.warehouseManager.addObserver(this);
        this.landManager.addObserver(this);
    }

    /**
     * fertilize the land at given index if possible
     *
     * @param index the index of the land that player want to fertilize on
     * @return a message indicating the result of fertilizing
     */
    public String fertilize(int index) {
        String message = "";
        Item fertilizer = this.warehouseManager.getWarehouse().getItem(TYPE_FERTILIZER);
        if (fertilizer != null
                && landManager.getLand(index).getPlant() != null
                && !landManager.getLand(index).isFertilize()) {
            landManager.fertilize(index,fertilizer);
            warehouseManager.removeProduct(fertilizer);
            // inform player that he/she has fertilized the land successfully
            message +=  FERTILIZE_SUCCESS + "\n";

        }
        else if (fertilizer == null) {
            // inform player that the warehouse has not fertilizer left
            message += NOT_ENOUGH_FERTILIZER + "\n";

        }
        else if (landManager.getLand(index).getPlant() == null) {
            // inform player that this land hasn't been planted yet
            message += LAND_NOT_PLANT + "\n";
        }
        else if (landManager.getLand(index).isFertilize()) {
            // inform player that this land has been fertilized recently, thus
            // should wait for a few minutes for next fertilization.
            message += INVALID_FERTILIZER + "\n";
        }
        return message;
    }


    /**
     * water the land at given index if possible
     *
     * @param index the index of the land that player want to water on
     * @return a message indicating the result of watering
     */
    public String watering(int index) {
        String message = "";
        Item wateringCan = this.warehouseManager.getWarehouse().getItem(TYPE_WATERING_CAN);
        if (wateringCan != null
                && landManager.getLand(index).getPlant() != null
                && landManager.getLand(index).getStage() < 2
                && !landManager.getLand(index).isWet()) {
            landManager.watering(index, wateringCan);
            warehouseManager.removeProduct(wateringCan);
            message += WATERING_SUCCESS + "\n";
            // inform player that he/she has watered the land successfully
        }
        else if (wateringCan == null) {
            // inform player that the warehouse has not watering can left
            message += NOT_ENOUGH_WATERING + "\n";
        }
        else if (landManager.getLand(index).getPlant() == null) {
            // inform player that this land hasn't been planted yet
            message += LAND_NOT_PLANT + "\n";
        }
        else if (landManager.getLand(index).getStage() == 2) {
            // inform player that this land has a fully grown plant, thus should not be watered
            message += INVALID_WATER_MATURE + "\n";
        }
        else if (landManager.getLand(index).isWet()) {
            // inform player that this land has been water recently, thus should wait for a few
            // minutes for next watering.
            message += INVALID_WATER + "\n";
        }
        return message;
    }
}
