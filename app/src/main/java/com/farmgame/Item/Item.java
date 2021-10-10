package com.farmgame;

public class Item{
    private int num_usage;    // -1 means this item can be used infinitely many times.

    public Item(int num_usage) {
        this.num_usage = num_usage;
    }
}

public class Hoe extends Item implements Usable{

    public Hoe() {
        super(-1);
    }

    @Override
    public void use() {
        // usage of Hoe
    }
}

public class Fertilizer extends Item implements Usable{
    public Fertilizer() {
        super(10);
    }

    @Override
    public void use() {
        // usage of Fertilizer
    }
}
