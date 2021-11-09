package com.farmgame.entity.Item;

public class HoeFactory implements ItemFactory{
    @Override
    public Item CreateItem() { return new Hoe(); }
}
