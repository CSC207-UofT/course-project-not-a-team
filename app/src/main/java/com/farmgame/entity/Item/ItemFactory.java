package com.farmgame.entity.Item;

public class ItemFactory {

    public Item createItem(String itemType) {
        if (itemType.equals("Fertilizer")) {
            return new Fertilizer();
        }
        else if (itemType.equals("WateringCan")) {
            return new WateringCan();
        }
        else {
            // throw exception?
            return null;
        }
    }
}
