package com.farmgame;


import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


import com.farmgame.entity.Store;
import com.farmgame.gateway.StoreDBApi;


@RunWith(AndroidJUnit4.class)
public class TestStoreDBApi extends DataBaseApiTest{



    @Test
    public void testGetPlantList(){
        assert StoreDBApi.getPlantList().size() == 21;
    }


    @Test
    public void testGetSeedList(){
        assert StoreDBApi.getSeedList().size() == 1;
    }

    @Test
    public void testGetItemList(){
        assert StoreDBApi.getItemList().size() == 2;
    }

    @Test
    public void testGetStore(){
        Store store = StoreDBApi.getStore();
        assert store.getCurrentProducts_items().size() == 2;
        assert store.getCurrentProducts_plants().size() == 21;
        assert store.getCurrentSeed().size() == 1;
    }

}