package com.farmgame.presenter.LandPresenter;

public class PlantStatusPresenter {
    public PlantStatusPresenter(){}

    public void fertilizerSuccess(){
        System.out.println("You have fertilized this land! The plants are growing faster now!");
    }

    public void not_enough_Fertilizer(){
        System.out.println("Ouch! Your warehouse does not have enough fertilizer!");
    }

    public void landNotPlant(){
        System.out.println("This land has not been planted yet!");
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

}
