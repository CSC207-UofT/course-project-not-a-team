package com.farmgame.entity.Item;

public class ItemFactory {

    /**
     * Create an item based on the itemType.
     *
     * @param itemType the type of item.
     * @return an item with desired type.
     */
    public Item createItem(String itemType) {
        if (itemType.equals("Fertilizer")) {
            return new Fertilizer();
        }
        else if (itemType.equals("WateringCan")) {
            return new WateringCan();
        }
        else {
            // Question: throw exception?
            return null;
        }
    }
}
