package com.farmgame.presenter.LandPresenter;

/**
 * ChangeStatusPresenter is used when the player interact with the status of the land.
 */
public class ChangeStatusPresenter {
    public ChangeStatusPresenter(){}

    /**
     * When the player levels up, new land(s) will be unlocked automatically, and it will present a
     * String message to inform the player that a new land is unlocked.
     * @return a String message to inform the player that a new land is unlocked
     */
    public String lockSuccess(){
        return "Congratulations! You have unlocked a new land!";
    }

    /**
     * When the player buys the land, if the land is unlocked and the player has enough money to buy
     * the land, it will present a String message to inform the player that the purchase is
     * successful.
     * @return a String message to inform the player that the purchase is successful
     */
    public String buySuccess(){
        return "Congratulations! You have bought a new land!";
    }

    /**
     * When the player buys the land, if the player does not have enough money, it will present a
     * String message to inform the player that he or she does not have enough money.
     * @return a String message to inform the player that he or she does not have enough money.
     */
    public String not_enough_money(){
        return "Unfortunately! You don't have enough money";
    }

    /**
     * When the player buys the land, if the player does not have enough money, it will also
     * present a String message to tell the player how much money he or she has right now.
     * @param money The amount of money the player has
     * @return a String message to tell the player how much money he or she has right now.
     */

    public String remaining_money(int money){
        return "You have " + money + " remaining";
    }

}
