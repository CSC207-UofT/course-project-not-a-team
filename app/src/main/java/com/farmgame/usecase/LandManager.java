package com.farmgame.usecase;

import com.farmgame.Item.Fertilizer;
import com.farmgame.Item.Hoe;
import com.farmgame.Plants;
import com.farmgame.Player;
import com.farmgame.Warehouse;
import com.farmgame.entity.LandEntity;


import static com.farmgame.constants.Constants.*;

public class LandManager {




    /**

     */
    public LandManager(){
    }

    /**
     *
     * @param land the land that is clicked
     * precondition: index < landArray.length.
     * response to clicking an item
     */
    public void onClick(LandEntity land){
        switch (land.getLockStatus()){
            case LOCK_STATUS_LOCKED:
                break;
            case LOCK_STATUS_NOT_BOUGHT:
                break;
            case LOCK_STATUS_BOUGHT:
                break;
        }
    }

    public void buyLand(LandEntity land, Player player){

    }

    public void planting(LandEntity land, Plants plant){
        land.setPlant(plant);
        land.setHarvestTime(plant.getPlantingTime());
    }

    public void harvest(LandEntity land, Player player, Hoe hoe){
        if (land.getHarvestTime() == 0 && hoe != null){
            hoe.use();
            land.setPlant(null);
            player.gainExp(land.getPlant().getExperiencePoint());
        }
    }

    public void fertilize(LandEntity land, Fertilizer fertilizer){
        if (land.getFertilizeTime() == 0){
            fertilizer.use();
            land.setFertilizeTime(100);
            land.setFertilize(true);
        }

    }

    public void watering(LandEntity land){
        if (land.getWaterTime() == 0){
            land.setWaterTime(100);
        }
    }








}
