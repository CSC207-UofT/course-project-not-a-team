package com.farmgame.usecase;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Hoe;
import com.farmgame.entity.Plants;
import com.farmgame.entity.LandEntity;


public class LandManager {
    /**
     * A use case class of LandEntity to manage the land
     */

    private final LandEntity land;

    /**
     * Construct a land manager
     * @param land load the land into the land manager
     */
    public LandManager(LandEntity land){
        this.land = land;
    }

    /**
     * getter
     * @return the land held by the land manager
     */
    public LandEntity getLand() {
        return land;
    }


    /**
     * Plant a plant into the land
     * @param plant the plant to be planted
     */
    public void planting(Plants plant){
        if (land.getPlant() == null){
            land.setPlant(plant);
            land.setHarvestTime(plant.getPlantingTime());
        }

    }

    /**
     * To harvest the land if it is harvestable
     * @param pm the player manager to manage the player
     * @param hoe a hoe needed for harvest
     */
    public void harvest(PlayerManager pm, Hoe hoe){
        if (land.getStage() == 2 && land.getHarvestTime() == 0 && hoe != null){
            pm.gainExp(land.getPlant().getExperiencePoint());
            land.reset();
        }
    }

    /**
     * To fertilize the land
     * @param fertilizer the fertilizer used to fertilize the land
     */
    public void fertilize(Fertilizer fertilizer){
        if (!land.isFertilize() && fertilizer.getNum_usage() != 0){
            land.setFertilizeTime(100);
            land.setHarvestTime((int) (land.getHarvestTime() * 0.75));
        }

    }

    /**
     * To water the land
     */
    public void watering(){
        if (land.getStage() < 2 && !land.isWet()){
            land.setWaterTime(100);
            land.addStage();
        }
    }








}
