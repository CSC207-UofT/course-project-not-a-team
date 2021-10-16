package com.farmgame.Item;

public class Fertilizer extends Item {

    /**
     * Constructor for Fertilizer, which can be used 10 times (limited).
     */
    public Fertilizer() {
        super(10);
    }

    @Override
    public void use() {
        // usage of fertilizer
    }
}