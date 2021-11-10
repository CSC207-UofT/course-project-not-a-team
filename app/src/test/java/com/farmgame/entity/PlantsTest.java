package com.farmgame.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlantsTest {
    Plants Potato = new Plants("Potato", 60);

    @Test(timeout = 50)
    public void test_name(){
        assertEquals(Potato.getPlantName(), "Potato");
    }

    @Test(timeout = 50)
    public void test_selling(){
        assertEquals(Potato.getSellingPrice(), 60);
    }

}

