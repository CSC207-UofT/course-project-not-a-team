package com.farmgame.entity.Item;

public class FertilizerFactory implements ItemFactory{
    @Override
    public Item CreateItem() {
        return new Fertilizer();
    }
}