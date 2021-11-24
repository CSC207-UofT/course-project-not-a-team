package com.farmgame.presenter.LandPresenter;

/**
 * The HarvestPresenter is used when the player plants seed and harvest plants in the land.
 */
public class HarvestPresenter {

    public HarvestPresenter(){}

    /**
     * When the player plants a seed, if the player has already purchased the land, there's no
     * growing plant on the land, and the player has the seed in warehouse, then the planting is
     * successful and it will present a String message to inform the player that the planting is
     * successful.
     * @return a String message to inform the players that the planting is successful
     */
    public String plantSuccess(){
        return "Congratulations! You have planted successfully!";
    }

    /**
     * When the player plants a seed, if the player did not purchase the selected land, it will
     * present a String message to inform the player that the land is not owned.
     * @return a String message to inform the player that the land is not owned.
     */
    public String invalidLand(){
        return "Unfortunately! You don't own this land";
    }

    /**
     * When the player plants a seed, if there's still growing plant in the land, it will present
     * a String message to inform the player that the planting is not successful due to the existing
     * plant in the land.
     * @return a String message to inform the player that the planting is not successful due to the
     * existing plant in the land
     */
    public String landOccupied(){
        return "Ouch! A plant is growing in this land. You are not " +
                " allowed to plant a new one";
    }

    /**
     * When the player plants a seed, if there's no remaining selected seed in the warehouse, it
     * will present a String message to inform the player that warehouse does not have the selected
     * String.
     * @return a String message to inform the player that warehouse does not have the selected
     * String.
     */
    public String  not_enough_Seed(){
        return "Ouch! Your warehouse does not have this seed!";
    }

    /**
     * When the player wants to harvest the plant, if there is no existing plant on a given land,
     * it will present a String message to inform the player that the land is not planted.
     * @return a String message to inform the player that the land is not planted.
     */
    public String landNotPlant(){
        return "This land has not been planted yet!";
    }

    /**
     * When the player wants to harvest the plant, if the plant is still growing, it will present
     * a String message to inform the player that the plant is still growing and can not be
     * harvested.
     * @return a String message to inform the player that the plant is still growing and can not be
     * harvested.
     */

    public String growingPlant(){
        return "This plants has not been fully grown.";
    }

    /**
     * When the player wants to harvest the plant, if the plant is mature, it will present a String
     * message to inform the player that the plant is harvested successfully.
     * @return a String message to inform the player that the plant is harvested successfully
     */
    public String harvestPlant(){
        return "The plant is harvested successfully.";
    }


}
