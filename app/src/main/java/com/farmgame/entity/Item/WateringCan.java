package com.farmgame.entity.Item;

public class WateringCan implements Item{
    private int price = 5;

    public int getPrice() { return price; }

    @Override
    public void use() {
        // usage of WateringCan
    }
}
