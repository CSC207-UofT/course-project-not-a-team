package com.farmgame.entity.Item;

public class WateringCanFactory implements ItemFactory{
    @Override
    public Item CreateItem() { return new WateringCan(); }
}