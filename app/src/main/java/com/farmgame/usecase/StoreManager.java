package com.farmgame.usecase;

import com.farmgame.entity.Plants;
import com.farmgame.entity.Store;

import java.util.List;

public class StoreManager<T> implements StorePurchase, StoreSell{
    private List<Plants> totalProducts;
    List<Plants> currentProducts;


    @Override
    public void checkvalidity(T object) {


    }

    @Override
    public void makepurchase() {

    }

    @Override
    public void updatewarehouse() {

    }

    @Override
    public void sell() {

    }
}
