package com.farmgame.entity;

import static org.junit.Assert.assertEquals;

import com.farmgame.entity.Seeds;

import org.junit.Test;

public class SeedsTest {
    Seeds potatoseed = new Seeds("PotatoSeed", 30, 12, 10);

    @Test(timeout = 50)
    public void test_name(){
        assertEquals(potatoseed.getSeedsName(), "PotatoSeed");
    }


    @Test(timeout = 50)
    public void test_planttime(){
        assertEquals(potatoseed.getPlantingTime(), 30);
    }

    @Test(timeout = 50)
    public void test_buyingprice(){
        assertEquals(potatoseed.getBuyingPrice(), 12);
    }

    @Test(timeout = 50)
    public void test_exp(){
        assertEquals(potatoseed.getExperiencePoint(), 10);
    }

    @Test(timeout = 50)
    public void test_namechange(){
        assertEquals(potatoseed.getPlantFromSeed(), "Potato");
    }
}
