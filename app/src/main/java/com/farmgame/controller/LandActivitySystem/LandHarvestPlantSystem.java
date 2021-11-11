package com.farmgame.controller.LandActivitySystem;

import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;
import com.farmgame.gateway.PlantDBApi;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.StoreAble;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;

public class LandHarvestPlantSystem {
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
        if (landManager.getLand().getLockStatus() == 2
                && landManager.getLand().getPlant() == null
                && seed !=null) {
            landManager.planting(seed);
            warehouseManager.removeProduct(seed);
            // inform player that he/she has planted the plant successfully
        }
        else if (landManager.getLand().getLockStatus() != 2) {
            // inform player that this land hasn't been owned by him/her
        }
        else if (landManager.getLand().getPlant() != null) {
            // inform player that this land has been planted already
        }
        else if (seed == null) {
            // inform player that this seed is not in warehouse
        }
        else {
            // an error has occurred somehow, because the above else if should cover every possible cases. Maybe call this ImplementationError?
        }
    }

    public void harvest() {
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
        }
        else if (landManager.getLand().getStage() < 2 | landManager.getLand().isWet()) {
            // inform player that this plant has not fully grown
        }
        else {
            // an error has occurred somehow, because the above else if should cover every possible cases. Maybe call this ImplementationError?
        }
    }
}
