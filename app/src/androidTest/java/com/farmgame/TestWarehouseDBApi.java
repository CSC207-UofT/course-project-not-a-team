package com.farmgame;


import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


import com.farmgame.gateway.WarehouseDBApi;

import java.util.Objects;

@RunWith(AndroidJUnit4.class)
public class TestWarehouseDBApi extends DataBaseApiTest{

    @Test
    public void testGetCur(){
        assert WarehouseDBApi.getCur() == 0;
    }


    @Test
    public void testGetSeed(){
        assert WarehouseDBApi.getSeedsMap().size() == 0;
    }

    @Test
    public void testGetItem(){
        assert WarehouseDBApi.getItemsMap().size() == 0;
    }

    @Test
    public void testGetPlant(){
        assert WarehouseDBApi.getPlantsMap().size() == 0;
    }



}
