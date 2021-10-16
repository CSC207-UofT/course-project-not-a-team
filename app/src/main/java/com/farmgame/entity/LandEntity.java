package com.farmgame.entity;


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
    private int stage;

    /**
     * lockStatus: whether the land is unlocked, not bought or bought
     * plant: the plant on the land
     * harvestTime: the time left until the plant can be harvested
     * waterTime: the time left until the land can be watered again
     * fertilizeTime: the time left until the land can be watered again
     * stage: the stage of the land, from 0 to 2
     */

    public LandEntity(int lockStatus, Plants plant, int harvestTime, int waterTime,
                      int fertilizeTime, int stage) {

        this.lockStatus = lockStatus;
        this.plant = plant;
        this.harvestTime = harvestTime;
        this.waterTime = waterTime;
        this.fertilizeTime = fertilizeTime;
        this.stage = stage;

    }

    /**
     * getter
     * @return the lock status
     */
    public int getLockStatus(){
        return this.lockStatus;
    }

    /**
     * setter of lockStatus
     * @param lockStatus a lockStatus to be set
     */
    public void setLockStatus(int lockStatus) {
        this.lockStatus = lockStatus;
    }

    /**
     * getter
     * @return if the land is empty
     */
    public boolean isEmpty() {
        return this.plant == null;
    }

    /**
     * getter
     * @return if the land is wet
     */
    public boolean isWet() {
        return this.getWaterTime() != 0;
    }

    /**
     * getter
     * @return if the land is fertilized
     */
    public boolean isFertilize() {
        return this.getFertilizeTime() != 0;
    }

    /**
     * getter
     * @return the remaining harvest time
     */
    public int getHarvestTime() {
        return harvestTime;
    }

    /**
     * setter of harvestTime
     * @param harvestTime a harvestTime to be set
     */

    public void setHarvestTime(int harvestTime) {
        this.harvestTime = harvestTime;
    }

    /**
     * getter
     * @return the remaining water time
     */
    public int getWaterTime() {
        return waterTime;
    }

    /**
     * setter of waterTime
     * @param waterTime a waterTime to be set
     */
    public void setWaterTime(int waterTime) {
        this.waterTime = waterTime;
    }

    /**
     * getter
     * @return the remaining fertilized time
     */
    public int getFertilizeTime() {
        return fertilizeTime;
    }

    /**
     * setter of fertilizeTime
     * @param fertilizeTime a fertilizeTime to be set
     */
    public void setFertilizeTime(int fertilizeTime) {
        this.fertilizeTime = fertilizeTime;
    }

    /**
     * getter
     * @return the plant on the land
     */
    public Plants getPlant() {
        return plant;
    }

    /**
     * setter of plant
     * @param plant a plant to be set
     */
    public void setPlant(Plants plant) {
        this.plant = plant;
        this.setHarvestTime(plant.getPlantingTime());
    }

    /**
     * getter
     * @return the stage of the land
     */
    public int getStage() {
        return stage;
    }

    /**
     * add 1 to the stage
     */
    public void addStage() {
        if (this.stage < 2){
            this.stage += 1;
        }
    }

    /**
     * Reset the land to an empty land
     */
    public void reset(){
        this.plant = null;
        this.harvestTime = 0;
        this.fertilizeTime = 0;
        this.waterTime = 0;
        this.stage = 0;
    }

}
