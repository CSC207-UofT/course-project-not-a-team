package com.farmgame.controller.LandActivitySystem;

import com.farmgame.controller.System;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;
import com.farmgame.gateway.PlantDBApi;
import com.farmgame.presenter.LandPresenter.HarvestPresenter;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;

public class LandHarvestPlantSystem extends System {
    private final WarehouseManager warehouseManager;
    private final LandManager landManager;
    private final PlayerManager playerManager;

    public LandHarvestPlantSystem(WarehouseManager warehouseManager, LandManager landManager,
                                  PlayerManager playerManager) {
        this.landManager = landManager;
        this.playerManager = playerManager;
        this.warehouseManager = warehouseManager;

        this.landManager.addObserver(this);
        this.playerManager.addObserver(this);
        this.warehouseManager.addObserver(this);

    }

    public String planting(int index, int plant) {
        Seeds seed = this.warehouseManager.getWarehouse().getSeeds(plant);
        HarvestPresenter harvestPresenter = new HarvestPresenter();
        String message = "";
        if (landManager.getLand(index).getLockStatus() == 2
                && landManager.getLand(index).getPlant() == null
                && seed !=null) {
            landManager.planting(index,seed);
            warehouseManager.removeProduct(seed);
            // inform player that he/she has planted the plant successfully
            message += harvestPresenter.plantSuccess() + "\n";

        }
        else if (landManager.getLand(index).getLockStatus() != 2) {
            // inform player that this land hasn't been owned by him/her
            message += harvestPresenter.invalidLand() + "\n";
        }
        else if (landManager.getLand(index).getPlant() != null) {
            // inform player that this land has been planted already
            message += harvestPresenter.landOccupied() + "\n";
        }
        else if (seed == null) {
            // inform player that this seed is not in warehouse
            message += harvestPresenter.not_enough_Seed() + "\n";
        }
        return message;
    }

    public String harvest(int index) {
        HarvestPresenter harvestPresenter = new HarvestPresenter();
        String message = "";
        if (landManager.getLand(index).getPlant() != null
                && landManager.getLand(index).getStage() == 2) {
            playerManager.gainExp(landManager.getLand(index).getPlant().getExperiencePoint());
            int plantId = landManager.getLand(index).getPlant().getId();
            Plants plant = PlantDBApi.createPlant(plantId);
            warehouseManager.addProduct(plant);
            landManager.harvest(index);
        }
        else if (landManager.getLand(index).getPlant() == null) {
            // inform player that this land has not been planted yet
            message += harvestPresenter.landNotPlant() + "\n";

        }
        else if (landManager.getLand(index).getStage() < 2 | landManager.getLand(index).isWet()) {
            // inform player that this plant has not fully grown
            message += harvestPresenter.growingPlant() + "\n";
        }
        return message;
    }
}
