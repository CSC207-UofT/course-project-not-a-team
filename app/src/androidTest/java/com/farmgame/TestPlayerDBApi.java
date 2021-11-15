package com.farmgame;


import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


import com.farmgame.gateway.PlayerDBApi;

import java.util.Objects;

@RunWith(AndroidJUnit4.class)
public class TestPlayerDBApi extends DataBaseApiTest{


    @Test
    public void TestGetPlayer(){
        assert Objects.requireNonNull(PlayerDBApi.getPlayer()).getName().equals("farmer");
    }

    @Test
    public void TestGetExpTable(){
        assert PlayerDBApi.getExpTable().keySet().size() == 20;
    }


}
