package com.farmgame.entity;


public class LandEntity {

    public static final int LOCK_STATUS_LOCKED = 0;
    public static final int LOCK_STATUS_NOT_BOUGHT = 1;
    public static final int LOCK_STATUS_BOUGHT = 2;


    private int lockStatus;

    /**
     * Land entity class defines a block of land.  It has attribute to indicate if the land is unlocked, watered,
     * fertilized, and if the land has a plant grown on it. There will be attributes indicating how long can you
     * water, fertilize, or harvest the plant grown on the land.
     */

    private boolean empty;
    private boolean wet;
    private boolean fertilize;
    private boolean unlocked;
    private int harvestTime;
    //Question: Should this be plant's attribute? Since we can harvest a plant before it is grown to clear up a land
    private int waterTime;
    private int fertilizeTime;


    public LandEntity(int lockStatus, boolean empty, boolean wet, boolean fertilize,
                      boolean unlocked, int harvestTime, int waterTime, int fertilizeTime) {
        this.lockStatus = lockStatus;
        this.empty = empty;
        this.wet = wet;
        this.fertilize = fertilize;
        this.harvestTime = harvestTime;
        this.waterTime = waterTime;
        this.fertilizeTime = fertilizeTime;
        this.unlocked = unlocked;
    }
    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }
    public int getLockStatus(){
        return this.lockStatus;
    }

    public void setLockStatus(int lockStatus) {
        this.lockStatus = lockStatus;
    }

    /**
     * wet: if the land is wet
     * fertilize: if the land is fertilized
     * unlocked: if the land is unlocked
     * harvestTime: the time left until the plant can be harvested
     * waterTime: the time left until the land can be watered again
     * fertilizeTime: the time left until the land can be watered again
     */

    public LandEntity(){
        this.empty = true;
        this.wet = false;
        this.fertilize = false;
        this.unlocked = false;

    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isWet() {
        return wet;
    }

    public void setWet(boolean wet) {
        this.wet = wet;
    }

    public boolean isFertilize() {
        return fertilize;
    }

    public void setFertilize(boolean fertilize) {
        this.fertilize = fertilize;
    }

    public int getHarvestTime() {
        return harvestTime;
    }

    public void setHarvestTime(int harvestTime) {
        this.harvestTime = harvestTime;
    }

    public int getWaterTime() {
        return waterTime;
    }

    public void setWaterTime(int waterTime) {
        this.waterTime = waterTime;
    }

    public int getFertilizeTime() {
        return fertilizeTime;
    }

    public void setFertilizeTime(int fertilizeTime) {
        this.fertilizeTime = fertilizeTime;
    }


}
