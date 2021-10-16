package com.farmgame.Item;

public class Item{
    private int num_usage;    // -1 means this item can be used infinitely many times.

    public Item(int num_usage) {
        this.num_usage = num_usage;
    }

    public int getNum_usage() {
        return num_usage;
    }

    public void setNum_usage(int num_usage) {
        this.num_usage = num_usage;
    }
}
