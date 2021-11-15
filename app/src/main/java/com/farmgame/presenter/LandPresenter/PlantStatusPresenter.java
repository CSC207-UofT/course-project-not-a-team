package com.farmgame.presenter.LandPresenter;

public class PlantStatusPresenter {
    public PlantStatusPresenter(){}

    public String fertilizerSuccess(){
        return "You have fertilized this land! The plants are growing faster now!";
    }

    public String not_enough_Fertilizer(){
        return "Ouch! Your warehouse does not have enough fertilizer!";
    }

    public String landNotPlant(){
        return "This land has not been planted yet!";
    }

    public String invalidFertilize(){
        return "Ouch! You have just fertilized this land. You may only fertilize once per plant.";
    }

    public String not_enough_WaterCan(){
        return "Unfortunately! The warehouse does not have enough watering can.";
    }

    public String invalidWater(){
        return "Ouch! This land has just been watered. You may need to wait" +
                " several minutes for the next round";
    }

    public String invalidWaterMature(){
        return "This plant is mature, you shouldn't water it again.";
    }

}
