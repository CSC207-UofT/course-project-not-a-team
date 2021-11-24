package com.farmgame.presenter.LandPresenter;

/**
 * PlantStatusPresenter is used when the player interact with the growing plant.
 */
public class PlantStatusPresenter {
    public PlantStatusPresenter(){}

    /**
     * When the player fertilizes a plant, if there is fertilizer in the warehouse, plants in the
     * land and the plant has not been fertilized, it will present a String message to inform the
     * player that the plant is now fertilized.
     * @return a String message to inform the player that the plant is not fertilized.
     */
    public String fertilizerSuccess(){
        return "You have fertilized this land! The plants are growing faster now!";
    }

    /**
     * When the player waters a plant, if there is watering can in the warehouse, plants in the land
     * and the plant has not been watered, it will present a String message to inform the player
     * that the plant is now watered.
     * @return a String message to inform the player that the plant is now watered.
     */
    public String wateringSuccess(){
        return "You have watered this land! The plants are growing successfully now!";
    }

    /**
     * When the player fertilizes a plant, if the warehouse does not contain fertilizer, it will
     * present a String message to inform the player that the warehouse does not contain fertilizer.
     * @return a String message to inform the player that the warehouse does not contain fertilizer.
     */
    public String not_enough_Fertilizer(){
        return "Ouch! Your warehouse does not have enough fertilizer!";
    }

    /**
     * When the player wants to fertilize or water the plant, but there is no existing plant on the
     * land, it will present a String message to inform the player that there is no existing plant
     * on a given land.
     * @return a String message to inform the player that there is no existing plant on a given land
     */
    public String landNotPlant(){
        return "This land has not been planted yet!";
    }

    /**
     * When the player fertilizes a plant, if the plant is already fertilized, it will present a
     * String message to inform the player that the plant is fertilized.
     * @return a String message to inform the player that the plant is fertilized.
     */

    public String invalidFertilize(){
        return "Ouch! You have just fertilized this land. You may only fertilize once per plant.";
    }

    /**
     * When the player waters a plant, if there is no remaining watering can in the warehouse, it
     * will present a String message to inform the player that the there is not remaining watering
     * can in the warehouse.
     * @return a String message to inform the player that the there is not remaining watering can in
     * the warehouse.
     */

    public String not_enough_WaterCan(){
        return "Unfortunately! The warehouse does not have enough watering can.";
    }

    /**
     * When the player waters a plant, if the plant is just watered, it will present a String
     * message to inform the player that he or she needs to wait several minutes to water next time.
     * @return a String message to inform the player that he or she needs to wait several minutes to
     * water next time.
     */
    public String invalidWater(){
        return "Ouch! This land has just been watered. You may need to wait" +
                " several minutes for the next round";
    }

    /**
     * When the player waters a plant, if the plant is already mature, it will present a String
     * message to inform the player that the plant is already mature.
     * @return a String message to inform the player that the plant is already mature.
     */
    public String invalidWaterMature(){
        return "This plant is mature, you shouldn't water it again.";
    }

}
