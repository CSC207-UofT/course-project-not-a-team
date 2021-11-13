package com.farmgame.presenter.LandPresenter;

public class ChangeStatusPresenter {
    public ChangeStatusPresenter(){}

    public String lockSuccess(){
        return "Congratulations! You have unlocked a new land!";
    }

    public String buySuccess(){
        return "Congratulations! You have bought a new land!";
    }

    public String not_enough_money(){
        return "Unfortunately! You don't have enough money";
    }

    public String remaining_money(int money){
        return "You have " + money + " remaining";
    }

}
