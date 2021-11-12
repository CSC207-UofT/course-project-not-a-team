package com.farmgame.usecase;

import static com.farmgame.constants.Constants.*;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.WateringCan;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Seeds;
import com.farmgame.usecase.WarehouseManager.WarehouseManipulate;

import java.util.Observable;


public class LandManager extends Observable {
    /**
     * A use case class of LandEntity, which stores a land to manage.
     */
    private final LandEntity land;



    /**
     * Construct a land manager
     *
     * @param land load the land into the land manager
     */
    public LandManager(LandEntity land){
        this.land = land;
    }



    /**
     * getter for the land stored in land manager
     *
     * @return the land held by the land manager
     */
    public LandEntity getLand() {
        return this.land;
    }



    /**
     * Plant a plant into the land
     *
     * @param plant the plant to be planted
     */
    public void planting(Seeds plant){
            land.setPlant(plant);
            land.setWaterTime();
            setChanged();
            notifyObservers(UPDATE_LAND + land.getIndex());
    }



    /**
     * To harvest the land if it is harvestable
     *
     * @param pm the player manager to manage the player
     */
    public void harvest(PlayerManager pm, WarehouseManipulate wm){
        if (land.getStage() == 2 && land.getWaterTime().equals("-1")){
            wm.addProduct((StoreAble) this.land.getPlant());
            pm.gainExp(this.land.getPlant().getExperiencePoint());
            this.land.reset();
            setChanged();
            notifyObservers(UPDATE_LAND + land.getIndex());
        }
    }



    /**
     * To fertilize this land
     *
     */
    public void fertilize(StoreAble fertilizer){
        if (!land.isFertilize()) {
            ((Fertilizer) fertilizer).use(this.land);
            setChanged();
            notifyObservers(UPDATE_LAND + land.getIndex());
        }
    }



    /**
     * To water the land
     */
    public void watering(StoreAble wateringCan){
        if (land.getStage() < 2 && !land.isWet()){
            ((WateringCan) wateringCan).use(this.land);
            setChanged();
            notifyObservers(UPDATE_LAND + land.getIndex());
        }
    }
}