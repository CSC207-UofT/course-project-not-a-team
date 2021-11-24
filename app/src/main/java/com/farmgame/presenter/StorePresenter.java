package com.farmgame.presenter;

/**
 * StorePresenter is used to present messages when making purchase or sell products.
 */
public class StorePresenter {
    public StorePresenter(){}

    /**
     * Print a String message to present the amount of money player has.
     * @param money The amount of money player has.
     * @return a String message to present the amount of money player has.
     */
    public String remaining_money(int money){
        return "You have " + money + " remaining";
    }

    /**
     * When the player making purchase in store, if the store does not contain the given product, it
     * will present a String message to let the player know that the product is not provided in store.
     * @return a String message to let the player know that the product is not provided in store.
     */
    public String invalid_product(){
        return "This product is not provided in store.";
    }

    /**
     * When the player making purchase in store, if the player does not have enough money to buy the
     * given product, it will present a String message to let the player know that he or she does
     * not have enough money to buy the given product.
     * @return a String message to let the player know that he or she does not have enough money to
     * buy the given product.
     */
    public String not_enough_money(){
        return "The purchase is unsuccessfully. Please check whether you have enough" +
                "money left.";
    }

    /**
     * When the player making purchase in store, if the amount of product in warehouse reaches the
     * maximum capacity of warehouse, it will present a String message to inform the player that
     * the warehouse does not have enough capacity.
     * @return a String message to inform the player that the warehouse does not have enough
     * capacity.
     */
    public String not_enough_capacity(){
        return "The purchase is unsuccessfully. The warehouse does not have enough" +
                "capacity.";
    }

    /**
     * When the player making purchase in store, if the purchase is successful, it will present a
     * String message to inform the player that the purchase is successful.
     * @return String message to inform the player that the purchase is successful.
     */
    public String purchase_success(){
        return "Congratulations! You have successfully made a purchase";
    }

    /**
     * When the player sells products to the store, if the sell is successful, it will present a
     * String message to inform the player that the sell is successful and how much money has earned
     * @param money Amount of money has earned by selling the product.
     * @return String message to inform the player that the sell is successful and how much money
     * has earned.
     */
    public String sell_success(int money){
        return "Congratulations! You have earned " + money;
    }

    /**
     * When the player sells products to the store, if the selected product is not a plant or the
     * player does not have the plant, it will present a String message to inform the player that
     * the sell is not successful.
     * @return a String message to inform the player that the sell is not successful
     */
    public String sell_fail(){
        return "Sorry! This product is not able to sell";
    }

    /**
     * When the purchase is successful, the warehouse will be automatically updated. And it will
     * present a String message to inform the player that the update is successful.
     * @return a  String message to inform the player that the update is successful.
     */
    public String update_success(){
        return "The purchased object has already been added to warehouse.";
    }
}
