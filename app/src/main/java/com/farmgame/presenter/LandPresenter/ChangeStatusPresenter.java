package com.farmgame.presenter.LandPresenter;

public class ChangeStatusPresenter {
    public ChangeStatusPresenter(){}

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

}
