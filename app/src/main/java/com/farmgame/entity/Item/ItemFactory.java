package com.farmgame.entity.Item;

import static com.farmgame.constants.Constants.*;

public class ItemFactory {

    /**
     * Create an item based on the itemType.
     *
     * @param itemType the type of item.
     * @return an item with desired type.
     */
    public Item createItem(String itemType) {
        if (itemType.equals(TYPE_FERTILIZER)) {
            return new Fertilizer(10, 14159);
        }
        else if (itemType.equals(TYPE_WATERING_CAN)) {
            return new WateringCan(5, 26535);
        }
        else {
            return null;
        }
    }
}
