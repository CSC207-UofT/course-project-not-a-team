package com.farmgame;


import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


import com.farmgame.gateway.LandDBApi;

@RunWith(AndroidJUnit4.class)
public class TestLandDBApi extends DataBaseApiTest{


    @Test
    public void TestGetLand(){
        assert LandDBApi.getLandList().size() == 20;
    }


}