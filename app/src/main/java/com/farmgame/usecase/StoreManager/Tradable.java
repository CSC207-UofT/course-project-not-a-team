package com.farmgame.usecase.StoreManager;

import com.farmgame.usecase.StoreAble;

public interface Tradable {
    int MISSING_PRICE = -1;
    // This value is returned when a price is unavailable.

    int getObjectPrice(StoreAble object);
    boolean checkvalidity(StoreAble object);
}
