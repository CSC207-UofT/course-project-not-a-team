package com.farmgame.entity;

import static com.farmgame.constants.Constants.TYPE_PLANT;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlantsTest {
    Plants Potato = new Plants("Potato", 60, 1);

    @Test(timeout = 50)
    public void test_name(){
        assertEquals("Potato", Potato.getName());
    }

    @Test(timeout = 50)
    public void test_selling(){
        assertEquals(60, Potato.getPrice());
    }

    @Test(timeout = 50)
    public void test_id(){
        assertEquals(1, Potato.getId());
    }

    @Test(timeout = 50)
    public void test_type(){
        assertEquals(TYPE_PLANT, Potato.getType());
    }
}

