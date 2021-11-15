package com.farmgame.entity.Item;

import com.farmgame.entity.LandEntity;
import com.farmgame.usecase.StoreAble;

public abstract class Item implements StoreAble {
    /**
     * A parent class of all item, which implements StoreAble interface.
     */
    private final int price;
    private final String item_name;
    private final int id;

    /**
     * Constructor for Item.
     *
     * @param price the price of this item
     * @param item_name the name of this item
     * @param id the id of this item
     */
    public Item(int price, String item_name, int id) {
        this.price = price;
        this.item_name = item_name;
        this.id = id;
    }

    /**
     * getter of price
     *
     * @return the price of this item
     */
    public int getPrice() {
        return price;
    }

    /**
     * getter of id
     *
     * @return the id of this item
     */
    public int getId() {
        return id;
    }

    /**
     * getter of name
     *
     * @return the name of this item
     */
    public String getName() {
        return item_name;
    }

    /**
     * getter of type
     *
     * @return the type of this item
     */
    public abstract String getType();

    /**
     * use this item on the land
     *
     * @param land the land on which the item is used
     */
    public abstract void use(LandEntity land);
}
