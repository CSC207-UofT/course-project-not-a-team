package com.farmgame.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlantsTest {
    Plants Potato = new Plants("Potato", 60, 1);

    @Test(timeout = 50)
    public void test_name(){
        assertEquals(Potato.getName(), "Potato");
    }

    @Test(timeout = 50)
    public void test_selling(){
        assertEquals(Potato.getPrice(), 60);
    }

    @Test(timeout = 50)
    public void test_id(){
        assertEquals(Potato.getId(), 1);
    }

    @Test(timeout = 50)
    public void test_type(){
        assertEquals(Potato.getType(), "plant");
    }
}

