package com.farmgame.entity.Item;

public class Fertilizer implements Item{
    private int price = 10;

    public int getPrice() {
        return this.price;
    }

    @Override
    public void use() {
        // usage of fertilizer
    }
}
