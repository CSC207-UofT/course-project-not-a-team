package com.farmgame;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlantsTest {
    Plants Potato = new Plants("Potato", 60, 12, 18, 30);

    @Test(timeout = 50)
    public void test_name(){
        assertEquals(Potato.getPlantName(), "Potato");
    }

    @Test(timeout = 50)
    public void test_time(){
        assertEquals(Potato.getPlantingTime(), 60);
    }

    @Test(timeout = 50)
    public void test_buying(){
        assertEquals(Potato.getBuyingPrice(), 12);
    }

    @Test(timeout = 50)
    public void test_selling(){
        assertEquals(Potato.getSellingPrice(), 18);
    }

    @Test(timeout = 50)
    public void test_exp(){
        assertEquals(Potato.getExperiencePoint(), 30);
    }

}

