package com.farmgame.usecase;

public interface Tradable {
    int MISSING_PRICE = -1;
    // This value is returned when a price is unavailable.

    int getObjectPrice();
    boolean checkvalidity();
}
