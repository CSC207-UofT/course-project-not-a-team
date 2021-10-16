package com.farmgame.Item;

public abstract class Item{
    private int num_usage;    // -1 means this item can be used infinitely many times.

    /**
     * Constructor for Item class.
     *
     * @param num_usage how many time this item can be used,-1 means this item can be used
     *                  infinitely many times.
     */
    public Item(int num_usage) {
        this.num_usage = num_usage;
    }

    public abstract void use();
}
