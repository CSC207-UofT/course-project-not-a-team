package com.farmgame.entity;


import com.farmgame.Plants;

public class LandEntity {

    /**
     * Land entity class defines a block of land.  It has attribute to indicate if the land is unlocked, watered,
     * fertilized, and if the land has a plant grown on it. There will be attributes indicating how long can you
     * water, fertilize, or harvest the plant grown on the land.
     */
    private int lockStatus;
    private Plants plant;
    private int harvestTime;
    private int waterTime;
    private int fertilizeTime;

    /**
     * lockStatus: whether the land is unlocked, not bought or bought
     * plant: the plant on the land
     * harvestTime: the time left until the plant can be harvested
     * waterTime: the time left until the land can be watered again
     * fertilizeTime: the time left until the land can be watered again
     */

    public LandEntity(int lockStatus, Plants plant, int harvestTime, int waterTime,
                      int fertilizeTime) {

        this.lockStatus = lockStatus;
        this.plant = plant;
        this.harvestTime = harvestTime;
        this.waterTime = waterTime;
        this.fertilizeTime = fertilizeTime;

    }

    public int getLockStatus(){
        return this.lockStatus;
    }

    public void setLockStatus(int lockStatus) {
        this.lockStatus = lockStatus;
    }


    public boolean isEmpty() {
        return this.plant == null;
    }


    public boolean isWet() {
        return this.getWaterTime() != 0;
    }

    public boolean isFertilize() {
        return this.getFertilizeTime() != 0;
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

    public Plants getPlant() {
        return plant;
    }

    public void setPlant(Plants plant) {
        this.plant = plant;
        this.setHarvestTime(plant.getPlantingTime());
    }

    public void reset(){
        this.plant = null;
        this.harvestTime = 0;
        this.fertilizeTime = 0;
        this.waterTime = 0;
    }

}
