package com.farmgame.usecase;

public interface Tradable<T> {
    // This value is returned when a price is unavailable.

    int getPrice(T object);
    boolean checkvalidity(T object);
}
