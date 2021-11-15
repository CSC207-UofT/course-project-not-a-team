package com.farmgame;


import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


import com.farmgame.gateway.PlantDBApi;

@RunWith(AndroidJUnit4.class)
public class TestPlantDBApi extends DataBaseApiTest{



    @Test
    public void TestCreatePlant(){
        assert PlantDBApi.createPlant(1001).getName().equals("SuperPlant");
    }

    @Test
    public void TestGetSeed(){
        assert PlantDBApi.getSeed(1001).getName().equals("SuperSeed");
    }

}