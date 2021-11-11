package com.farmgame;

import static com.farmgame.constants.Constants.TYPE_FERTILIZER;
import static com.farmgame.constants.Constants.TYPE_WATERING_CAN;
import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Item.WateringCan;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;
import com.farmgame.gateway.PlantDBApi;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;
import com.farmgame.usecase.StoreAble;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;



public class LandSystem {
    private final LandManager[][] list_of_land;
    private final PlayerManager playerManager;
    private final WarehouseManager warehouseManager;
    private final int[] unlock_new_land;
    private final int[] buy_new_land;



    public LandSystem(PlayerManager playerManager, WarehouseManager warehouseManager) {
        this.list_of_land = new LandManager[3][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                this.list_of_land[j][i] = new LandManager(
                        new LandEntity(0, null, 0, 0, 0));
            }
        }

        this.playerManager = playerManager;
        this.warehouseManager = warehouseManager;
        this.unlock_new_land = new int[]{1, 0};
        list_of_land[0][0].getLand().setLockStatus(1);
        this.buy_new_land = new int[]{0, 0};
    }



    public void unlockLand() {
        LandEntity land = list_of_land[unlock_new_land[0]][unlock_new_land[1]].getLand();
        land.setLockStatus(1);
        if (unlock_new_land[0] < 2) {
            unlock_new_land[0] += 1;
        }
        else if (unlock_new_land[1] < 3) {
            unlock_new_land[0] = 0;
            unlock_new_land[1] += 1;
        }
        else {
            // return error?
        }
    }



    public void buyLand() {
        LandEntity land = list_of_land[buy_new_land[0]][buy_new_land[1]].getLand();
        if (buy_new_land[1] < unlock_new_land[1] |
                ( buy_new_land[1] == unlock_new_land[1] && buy_new_land[0] < unlock_new_land[0])) {
            land.setLockStatus(2);
            if (buy_new_land[0] < 2) {
                buy_new_land[0] += 1;
            }
            else if (buy_new_land[1] < 3) {
                buy_new_land[0] = 0;
                buy_new_land[1] += 1;
            }
            else {
                // return error?
            }
        }
        else {
            // return error?
        }
    }



    public void planting(int[] coordinate, String plant) {
        LandManager landManager = list_of_land[coordinate[0]][coordinate[1]];
        Seeds seed = this.warehouseManager.getWarehouse().getSeeds(plant);
        if (landManager.getLand().getLockStatus() == 2
                && landManager.getLand().getPlant() == null
                && seed !=null) {
            landManager.planting(seed);
            warehouseManager.removeProduct(seed);
        }
        else {
            // return error message?
        }
    }



    public void fertilize(int[] coordinate) {
        LandManager landManager = list_of_land[coordinate[0]][coordinate[1]];
        Item fertilizer = this.warehouseManager.getWarehouse().getItem(TYPE_FERTILIZER);
        if (fertilizer != null
                && landManager.getLand().getPlant() != null
                && !landManager.getLand().isFertilize()) {
            landManager.fertilize((Fertilizer) fertilizer);
            warehouseManager.removeProduct((StoreAble) fertilizer);
        }
        else {
            // return error message?
        }
    }



    public void watering(int[] coordinate) {
        LandManager landManager = list_of_land[coordinate[0]][coordinate[1]];
        Item wateringCan = this.warehouseManager.getWarehouse().getItem(TYPE_WATERING_CAN);
        if (wateringCan != null
                && landManager.getLand().getPlant() != null
                && landManager.getLand().getStage() < 2
                && !landManager.getLand().isWet()) {
            landManager.watering((WateringCan) wateringCan);
            warehouseManager.removeProduct((StoreAble) wateringCan);
        }
        else {
            // return error message
        }
    }



    public void harvest(int[] coordinate) {
        LandManager landManager = list_of_land[coordinate[0]][coordinate[1]];

        if (landManager.getLand().getPlant() != null
                && landManager.getLand().getStage() == 2
                && !landManager.getLand().isWet()) {
            playerManager.gainExp(landManager.getLand().getPlant().getExperiencePoint());
            int plantId = landManager.getLand().getPlant().getSeedId();
            Plants plant = PlantDBApi.createPlant(plantId);
            warehouseManager.addProduct((StoreAble) plant);
        }
        else {
            // return error message
        }
    }
}
