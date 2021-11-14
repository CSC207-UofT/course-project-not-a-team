package com.farmgame.entity.Item;

import com.farmgame.entity.LandEntity;
import com.farmgame.usecase.StoreAble;

public abstract class Item implements StoreAble {
    private final int price;
    private final String item_name;
    private final int id;

    public Item(int price, String item_name, int id) {
        this.price = price;
        this.item_name = item_name;
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return item_name;
    }

    public abstract String getType();

    public abstract void use(LandEntity land);
}
