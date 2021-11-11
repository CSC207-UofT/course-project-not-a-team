package com.farmgame.usecase.StoreManager;

import com.farmgame.usecase.StoreAble;


public interface TradeAble {
    int MISSING_PRICE = -1;
    // This value is returned when a price is unavailable.

    int getObjectPrice(StoreAble object);
    boolean checkValidity(StoreAble object);

}
