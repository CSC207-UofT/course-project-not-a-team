package com.farmgame.presenter;

public class StorePresenter {
    public StorePresenter(){}

    public void remaining_money(int money){
        System.out.println("You have " + money + " remaining");
    }

    public void invalid_product(){
        System.out.println("This product is not provided in store.");
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
        System.out.println("Congratulations! You have earned " + money);
    }

    public void update_success(){
        System.out.println("The purchased object has already been added to warehouse.");
    }
}
