package com.farmgame.presenter.LandPresenter;

public class HarvestPresenter {

    public HarvestPresenter(){}

    public String plantSuccess(){
        return "Congratulations! You have planted successfully!";
    }

    public String invalidLand(){
        return "Unfortunately! You don't own this land";
    }

    public String landOccupied(){
        return "Ouch! A plant is growing in this land. You are not " +
                " allowed to plant a new one";
    }

    public String  not_enough_Seed(){
        return "Ouch! Your warehouse does not have this seed!";
    }

    public String landNotPlant(){
        return "This land has not been planted yet!";
    }

    public String growingPlant(){
        return "This plants has not been fully grown.";
    }


}
