package com.farmgame.usecase;

import static com.farmgame.constants.Constants.*;
import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.WateringCan;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Seeds;
import java.util.Observable;

public class LandManager extends Observable {
    /**
     * A use case class of LandEntity, which stores a land to manage.
     */
    private final LandEntity land;
    private final int MESSAGE;

    /**
     * Construct a land manager
     *
     * @param land load the land into the land manager
     */
    public LandManager(LandEntity land){
        this.land = land;
        MESSAGE = UPDATE_LAND + land.getIndex();
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
            notifyObservers(MESSAGE);
    }

    /**
     * To harvest the land if it is harvestable
     */
    public void harvest(){
        this.land.reset();
        setChanged();
        notifyObservers(MESSAGE);
    }

    /**
     * To fertilize this land
     *
     * @param fertilizer the fertilizer used to fertilize the land
     */
    public void fertilize(StoreAble fertilizer){
        ((Fertilizer) fertilizer).use(this.land);
        setChanged();
        notifyObservers(MESSAGE);

    }

    /**
     * To water the land
     *
     * @param wateringCan the watering can used to water the land
     */
    public void watering(StoreAble wateringCan){
        ((WateringCan) wateringCan).use(this.land);
        setChanged();
        notifyObservers(MESSAGE);

    }

    /**
     * buy this land, change its status to unlocked and bought.
     */
    public void buy(){
        land.setLockStatus(LOCK_STATUS_BOUGHT);
        setChanged();
        notifyObservers(MESSAGE);
    }

    /**
     * unlock this land, change its status to unlocked but not bought.
     */
    public void unLock(){
        land.setLockStatus(LOCK_STATUS_NOT_BOUGHT);
        setChanged();
        notifyObservers(MESSAGE);
    }
}