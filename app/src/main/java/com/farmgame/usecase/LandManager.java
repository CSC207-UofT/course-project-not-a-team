package com.farmgame.usecase;

import com.farmgame.Item.Fertilizer;
import com.farmgame.Item.Hoe;
import com.farmgame.Plants;
import com.farmgame.Player;
import com.farmgame.entity.Warehouse;
import com.farmgame.entity.LandEntity;


import static com.farmgame.constants.Constants.*;

public class LandManager {


    public LandManager(){
    }


    public void buyLand(LandEntity land, Player player){

    }

    public void planting(LandEntity land, Plants plant){
        land.setPlant(plant);
        land.setHarvestTime(plant.getPlantingTime());
    }

    public void harvest(LandEntity land, Player player, Hoe hoe){
        if (land.getHarvestTime() == 0 && hoe != null){
            player.gainExp(land.getPlant().getExperiencePoint());
            land.reset();
        }
    }

    public void fertilize(LandEntity land, Fertilizer fertilizer){
        if (land.getFertilizeTime() == 0 && fertilizer.getNum_usage() != 0){
            land.setFertilizeTime(100);
            land.setHarvestTime((int) (land.getHarvestTime() * 0.75));
        }

    }

    public void watering(LandEntity land){
        if (land.getWaterTime() == 0){
            land.setWaterTime(100);
        }
    }








}
