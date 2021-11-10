package com.farmgame.entity;



public class LandEntity {
    /**
     * Land entity class defines a block of land. It has attribute to indicate if the land is
     * unlocked, watered, fertilized, and if the land has a plant grown on it. There will be
     * attributes indicating how long can you water or fertilize the plant grown on the land.
     */
    private int lockStatus;
    private Seeds plant;
    private int waterTime;
    private int fertilizeTime;
    private int stage;



    /**
     * Constructor of LandEntity class
     *
     * @param lockStatus if the land is locked, or unlocked but un-bought, or bought.
     * @param plant the plant grown on the land.
     * @param waterTime the cool down of water time, which depends on the plant.
     * @param stage the stage of the land.
     */
    public LandEntity(int lockStatus, Seeds plant, int waterTime, int stage, int fertilizeTime) {
        this.lockStatus = lockStatus;
        this.plant = plant;
        this.waterTime = waterTime;
        this.stage = stage;
        this.fertilizeTime = fertilizeTime;
    }



    /**
     * getter for LockStatus.
     *
     * @return the lock status
     */
    public int getLockStatus(){
        return this.lockStatus;
    }



    /**
     * setter of LockStatus.
     *
     * @param lockStatus lockStatus to be set, 0 is locked, 1 is unlocked but un-bought, or bought.
     */
    public void setLockStatus(int lockStatus) {
        this.lockStatus = lockStatus;
    }



    /**
     * Whether this land is empty
     *
     * @return true if and only if the land is empty
     */
    public boolean isEmpty() {
        return this.plant == null;
    }



    /**
     * Whether this land is wet
     *
     * @return true if and only if the land is wet
     */
    public boolean isWet() {
        return this.getWaterTime() != 0;
    }

    public int getFertilizeTime() {
        return fertilizeTime;
    }

    /**
     * Whether this land is fertilized or not.
     *
     * @return true if and only if the land is fertilized.
     */
    public boolean isFertilize() {
        return this.getFertilizeTime() != 0;
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
     * getter for plants on the land
     *
     * @return the plant on the land
     */
    public Seeds getPlant() {
        return plant;
    }



    /**
     * setter of plant
     *
     * @param plant a plant to be set
     */
    public void setPlant(Seeds plant) {
        this.plant = plant;
        this.setWaterTime(plant.getPlantingTime());
    }



    /**
     * getter for the stage of the land.
     *
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
     * Reset the land to an empty land, which has null plant, zero water time and fertilize time,
     * and its stage is at zero.
     */
    public void reset(){
        this.plant = null;
        this.waterTime = 0;
        this.stage = 0;
        this.fertilizeTime = 0;
    }
}
