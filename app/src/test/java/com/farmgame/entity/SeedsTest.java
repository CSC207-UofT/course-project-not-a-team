package com.farmgame.entity;

import static com.farmgame.constants.Constants.TYPE_SEED;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SeedsTest {
    Seeds potatoSeed = new Seeds("PotatoSeed", 30, 12, 10, 1);

    @Test(timeout = 50)
    public void test_getName(){
        assertEquals("PotatoSeed", potatoSeed.getName());
    }

    @Test(timeout = 50)
    public void test_getPlantTime(){
        assertEquals(30, potatoSeed.getPlantingTime());
    }

    @Test(timeout = 50)
    public void test_getPrice(){
        assertEquals(12, potatoSeed.getPrice());
    }

    @Test(timeout = 50)
    public void test_getExperiencePoint(){
        assertEquals(10, potatoSeed.getExperiencePoint());
    }

    @Test(timeout = 50)
    public void test_getPlantFromSeed(){
        assertEquals("Potato", potatoSeed.getPlantFromSeed());
    }

    @Test(timeout = 50)
    public void test_getId(){
        assertEquals(1, potatoSeed.getId());
    }

    @Test(timeout = 50)
    public void test_type(){
        assertEquals(TYPE_SEED, potatoSeed.getType());
    }
}
