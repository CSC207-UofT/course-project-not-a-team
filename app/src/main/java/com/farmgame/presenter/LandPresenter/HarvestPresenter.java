package com.farmgame.presenter.LandPresenter;

public class HarvestPresenter {

    public HarvestPresenter(){}

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

    public void landNotPlant(){
        System.out.println("This land has not been planted yet!");
    }

    public void growingPlant(){
        System.out.println("This plants has not been fully grown.");
    }


}
