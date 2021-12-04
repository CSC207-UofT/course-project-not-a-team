package com.farmgame.entity;

import static com.farmgame.constants.Constants.TYPE_FERTILIZER;
import static com.farmgame.constants.Constants.TYPE_WATERING_CAN;
import static org.junit.Assert.*;
import com.farmgame.entity.Item.*;
import org.junit.Test;

public class ItemUnitTest {
    ItemFactory factory = new ItemFactory();
    Item fertilizer =  factory.createItem(TYPE_FERTILIZER, 5, 10);
    Item wateringCan =  factory.createItem(TYPE_WATERING_CAN, 10, 20);


    @Test
    public void test_createItem() {
        assertTrue(fertilizer instanceof Fertilizer);
        assertTrue(wateringCan instanceof WateringCan);
        Item null_obj = factory.createItem("blah", 10, 10);
        assertNull(null_obj);
    }

    @Test
    public void test_getPrice() {
        assertEquals(10, fertilizer.getPrice());
        assertEquals(5, wateringCan.getPrice());
    }

    @Test
    public void test_getName() {
        assertEquals(TYPE_FERTILIZER, fertilizer.getName());
        assertEquals(TYPE_WATERING_CAN, wateringCan.getName());
    }

    @Test
    public void test_getId() {
        assertEquals(14159, fertilizer.getId());
        assertEquals(26535, wateringCan.getId());
    }

    @Test
    public void test_getType() {
        assertEquals(TYPE_FERTILIZER, fertilizer.getType());
        assertEquals(TYPE_WATERING_CAN, wateringCan.getType());
    }

    // use method is test in LandActivitySystem
}