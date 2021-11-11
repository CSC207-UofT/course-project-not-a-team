package com.farmgame.presenter;

public class StorePresenter {
    public StorePresenter(){};

    public void welcome(){
        System.out.println("Welcome to Store");
    }

    public void remaining_money(int money){
        System.out.println("You have " + String.valueOf(money) + "remaining");
    }

    public void not_enough_money(){
        System.out.println("The purchase is unsuccessfully. Please check whether you have enough" +
                "money left.");
    }

    public void not_enough_capacity(){
        System.out.println("The purchase is unsuccessfully. The warehouse does not have enough" +
                "capacity.");
    }

    public void purchase_success(){
        System.out.println("Congratulations! You have successfully made a purchase");
    }

    public void sell_success(int money){
        System.out.println("Congratulations! You have earned" + String.valueOf(money));
    }
}
