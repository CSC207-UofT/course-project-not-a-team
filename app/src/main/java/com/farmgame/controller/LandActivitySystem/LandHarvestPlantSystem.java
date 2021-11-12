package com.farmgame.controller.LandActivitySystem;

import com.farmgame.controller.System;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;
import com.farmgame.gateway.PlantDBApi;
import com.farmgame.presenter.LandPresenter.HarvestPresenter;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.StoreAble;
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

    }

    public void planting(String plant) {
        Seeds seed = this.warehouseManager.getWarehouse().getSeeds(plant);
        HarvestPresenter harvestPresenter = new HarvestPresenter();
        if (landManager.getLand().getLockStatus() == 2
                && landManager.getLand().getPlant() == null
                && seed !=null) {
            landManager.planting(seed);
            warehouseManager.removeProduct(seed);
            // inform player that he/she has planted the plant successfully
            harvestPresenter.plantSuccess();

        }
        else if (landManager.getLand().getLockStatus() != 2) {
            // inform player that this land hasn't been owned by him/her
            harvestPresenter.invalidLand();
        }
        else if (landManager.getLand().getPlant() != null) {
            // inform player that this land has been planted already
            harvestPresenter.landOccupied();
        }
        else if (seed == null) {
            // inform player that this seed is not in warehouse
            harvestPresenter.not_enough_Seed();
        }
        else {
            // an error has occurred somehow, because the above else if should cover every possible cases. Maybe call this ImplementationError?
        }
    }

    public void harvest() {
        HarvestPresenter harvestPresenter = new HarvestPresenter();
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
            harvestPresenter.landNotPlant();

        }
        else if (landManager.getLand().getStage() < 2 | landManager.getLand().isWet()) {
            // inform player that this plant has not fully grown
            harvestPresenter.growingPlant();
        }
        else {
            // an error has occurred somehow, because the above else if should cover every possible cases. Maybe call this ImplementationError?
        }
    }
}
