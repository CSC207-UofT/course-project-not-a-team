package com.farmgame.entity;


import android.annotation.SuppressLint;

import java.util.Calendar;
import java.text.SimpleDateFormat;

import java.util.Date;

public class LandEntity {
    /**
     * Land entity class defines a block of land. It has attribute to indicate if the land is
     * unlocked, watered, fertilized, and if the land has a plant grown on it. There will be
     * attributes indicating how long can you water or fertilize the plant grown on the land.
     */
    private int lockStatus;
    private Seeds plant;
    private String waterTime;
    private int fertilizeTime;
    private int stage;
    private int price;
    private int index;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Constructor of LandEntity class
     *  @param lockStatus if the land is locked, or unlocked but un-bought, or bought.
     * @param plant the plant grown on the land.
     * @param waterTime the cool down of water time, which depends on the plant.
     * @param stage the stage of the land.
     * @param price the price of the land
     * @param index the index of the land
     */
    public LandEntity(int lockStatus, Seeds plant, String waterTime, int stage, int fertilizeTime, int price, int index) {
        this.lockStatus = lockStatus;
        this.plant = plant;
        this.waterTime = waterTime;
        this.stage = stage;
        this.fertilizeTime = fertilizeTime;
        this.price = price;
        this.index = index;
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
        return !this.getWaterTime().equals("-1");
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
    public String getWaterTime() {
        return waterTime;
    }



    /**
     * setter of waterTime
     *
     */
    public void setWaterTime() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, this.plant.getPlantingTime());
        this.waterTime = sdf.format(nowTime.getTime());

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
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, plant.getPlantingTime());
        this.waterTime = sdf.format(nowTime.getTime());
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
        this.waterTime = "-1";
        this.stage = 0;
        this.fertilizeTime = 0;
    }
}
