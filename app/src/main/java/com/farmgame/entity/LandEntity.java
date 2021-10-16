package com.farmgame.entity;


public class LandEntity {
    public static final int LOCK_STATUS_LOCKED = 0;
    public static final int LOCK_STATUS_NOT_BOUGHT = 1;
    public static final int LOCK_STATUS_BOUGHT = 2;


    private int lockStatus;
    private boolean empty;
    private boolean wet;
    private boolean fertilize;
    private int harvestTime;
    private int waterTime;
    private int fertilizeTime;


    public LandEntity(int lockStatus, boolean empty, boolean wet, boolean fertilize, int harvestTime, int waterTime, int fertilizeTime) {
        this.lockStatus = lockStatus;
        this.empty = empty;
        this.wet = wet;
        this.fertilize = fertilize;
        this.harvestTime = harvestTime;
        this.waterTime = waterTime;
        this.fertilizeTime = fertilizeTime;
    }

    public int getLockStatus(){
        return this.lockStatus;
    }

    public void setLockStatus(int lockStatus){
        this.lockStatus = lockStatus;
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
