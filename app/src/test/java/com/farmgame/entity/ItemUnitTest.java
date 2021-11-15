package com.farmgame.entity;

import static com.farmgame.constants.Constants.TYPE_FERTILIZER;
import static com.farmgame.constants.Constants.TYPE_WATERING_CAN;
import static org.junit.Assert.*;
import com.farmgame.entity.Item.*;
import org.junit.Test;

public class ItemUnitTest {
    ItemFactory factory = new ItemFactory();
    Item fertilizer =  factory.createItem(TYPE_FERTILIZER);
    Item wateringCan =  factory.createItem(TYPE_WATERING_CAN);


    @Test
    public void test_createItem() {
        assertTrue(fertilizer instanceof Fertilizer);
        assertTrue(wateringCan instanceof WateringCan);
        Item null_obj = factory.createItem("blah");
        assertNull(null_obj);
    }

    @Test
    public void test_getPrice() {
        assertEquals(fertilizer.getPrice(), 10);
        assertEquals(wateringCan.getPrice(), 5);
    }

    @Test
    public void test_getName() {
        assertEquals(fertilizer.getName(), TYPE_FERTILIZER);
        assertEquals(wateringCan.getName(), TYPE_WATERING_CAN);
    }

    @Test
    public void test_getId() {
        assertEquals(fertilizer.getId(), 14159);
        assertEquals(wateringCan.getId(), 26535);
    }

    @Test
    public void test_getType() {
        assertEquals(fertilizer.getType(), TYPE_FERTILIZER);
        assertEquals(wateringCan.getType(), TYPE_WATERING_CAN);
    }

    // use method is test in LandActivitySystem
}