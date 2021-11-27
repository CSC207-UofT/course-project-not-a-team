package com.farmgame.usecase;

import static com.farmgame.constants.Constants.*;
import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.WateringCan;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Seeds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Observable;

public class LandManager extends Observable {
    /**
     * A use case class of LandEntity, which stores all lands to manage.
     */
    private final HashMap<Integer, LandEntity> landMap;

    /**
     * Construct a land manager
     *
     * @param landMap load the map of lands into the land manager
     */
    public LandManager(HashMap<Integer, LandEntity> landMap){
        this.landMap = landMap;
    }

    /**
     * Get the indices for all the lands
     *
     * @return the list of indices
     */
    public ArrayList<Integer> getAllIndices(){
        return new ArrayList<>(landMap.keySet());
    }

    /**
     * getter for the a land stored in land manager
     *
     * @return the land held by the land manager
     */
    public LandEntity getLand(int index) {
        return landMap.get(index);
    }

    /**
     * Plant a plant into the land
     *
     * @param plant the plant to be planted
     */
    public void planting(int index, Seeds plant){
        LandEntity land = Objects.requireNonNull(landMap.get(index));
        land.setPlant(plant);
        land.setWaterTime();
        setChanged();
        notifyObservers(UPDATE_LAND + land.getIndex());
    }

    /**
     * To harvest the land if it is harvestable
     */
    public void harvest(int index){
        LandEntity land = Objects.requireNonNull(landMap.get(index));
        land.reset();
        setChanged();
        notifyObservers(UPDATE_LAND + land.getIndex());
    }

    /**
     * To fertilize this land
     *
     * @param fertilizer the fertilizer used to fertilize the land
     */
    public void fertilize(int index,StoreAble fertilizer){
        LandEntity land = Objects.requireNonNull(landMap.get(index));
        ((Fertilizer) fertilizer).use(land);
        setChanged();
        notifyObservers(UPDATE_LAND + land.getIndex());

    }

    /**
     * To water the land
     *
     * @param wateringCan the watering can used to water the land
     */
    public void watering(int index, StoreAble wateringCan){
        LandEntity land = Objects.requireNonNull(landMap.get(index));
        ((WateringCan) wateringCan).use(land);
        setChanged();
        notifyObservers(UPDATE_LAND + land.getIndex());

    }

    /**
     * buy this land, change its status to unlocked and bought.
     */
    public void buy(int index){
        LandEntity land = Objects.requireNonNull(landMap.get(index));
        land.setLockStatus(LOCK_STATUS_BOUGHT);
        setChanged();
        notifyObservers(UPDATE_LAND + land.getIndex());
    }

    /**
     * unlock this land, change its status to unlocked but not bought.
     */
    public void unLock(int index){
        LandEntity land = Objects.requireNonNull(landMap.get(index));
        land.setLockStatus(LOCK_STATUS_NOT_BOUGHT);
        setChanged();
        notifyObservers(UPDATE_LAND + land.getIndex());
    }
}