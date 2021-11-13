package com.farmgame.presenter;

public class StorePresenter {
    public StorePresenter(){}

    public String remaining_money(int money){
        return "You have " + money + " remaining";
    }

    public String invalid_product(){
        return "This product is not provided in store.";
    }

    public String not_enough_money(){
        return "The purchase is unsuccessfully. Please check whether you have enough" +
                "money left.";
    }

    public String not_enough_capacity(){
        return "The purchase is unsuccessfully. The warehouse does not have enough" +
                "capacity.";
    }

    public String purchase_success(){
        return "Congratulations! You have successfully made a purchase";
    }

    public String sell_success(int money){
        return "Congratulations! You have earned " + money;
    }

    public String sell_fail(){
        return "Sorry! This product is not able to sell";
    }

    public String update_success(){
        return "The purchased object has already been added to warehouse.";
    }
}
