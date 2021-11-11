package com.farmgame.presenter;

public class LandPresenter {
    public LandPresenter(){}

    public void lockSuccess(){
        System.out.println("Congratulations! You have unlocked a new land!");
    }

    public void buySuccess(){
        System.out.println("Congratulations! You have bought a new land!");
    }

    public void not_enough_money(){
        System.out.println("Unfortunately! You don't have enough money");
    }

    public void remaining_money(int money){
        System.out.println("You have " + money + " remaining");
    }

    public void plantSuccess(){
        System.out.println("Congratulations! You have planted successfully!");
    }

    public void invalidLand(){
        System.out.println("Unfortunately! You don't own this land");
    }

    public void landOccupied(){
        System.out.println("Ouch! A plant is growing in this land. You are not " +
                "allowed to plant a new one");
    }

    public void not_enough_Seed(){
        System.out.println("Ouch! Your warehouse does not have this seed!");
    }

    public void not_enough_Fertilizer(){
        System.out.println("Ouch! Your warehouse does not have enough fertilizer!");
    }

    public void fertilizerSuccess(){
        System.out.println("You have fertilized this land! The plants are growing faster now!");
    }

    public void invalidFertilize(){
        System.out.println("Ouch! You have just fertilized this land. You may need to wait " +
                "several minutes for the next round.");
    }

    public void not_enough_WaterCan(){
        System.out.println("Unfortunately! The warehouse does not have enough watering can.");
    }

    public void invalidWater(){
        System.out.println("Ouch! This land has just been watered. You may need to wait" +
                "several minutes for the next round");
    }

    public void invalidWaterMature(){
        System.out.println("This plant is mature, you shouldn't water it again.");
    }

    public void waterSuccess(){
        System.out.println("You have watered this land successfully!");
    }


    public void landNotPlant(){
        System.out.println("This land has not been planted yet!");
    }

    public void growingPlant(){
        System.out.println("This plants has not been fully grown.");
    }

}
