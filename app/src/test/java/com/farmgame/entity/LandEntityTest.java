package com.farmgame.entity;

import static com.farmgame.constants.Constants.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LandEntityTest {
    LandEntity land;

    @Before
    public void setUp() {
        land = new LandEntity(LOCK_STATUS_LOCKED, null,  "-1", 0 ,
                false, 10, 0, 1);
    }

    @Test
    public void test_getPrice_setPrice() {
        assertEquals(10, land.getPrice());
        land.setPrice(100);
        assertEquals(100, land.getPrice());
    }

    @Test
    public void test_getIndex_setIndex() {
        assertEquals(0, land.getIndex());
        land.setIndex(1);
        assertEquals(1, land.getIndex());
    }

    @Test
    public void test_getLockStatus_setLockStatus() {
        assertEquals(LOCK_STATUS_LOCKED, land.getLockStatus());
        land.setLockStatus(1);
        assertEquals(LOCK_STATUS_NOT_BOUGHT, land.getLockStatus());
    }

    @Test
    public void test_setFertilized_isFertilized() {
        assertFalse(land.isFertilize());
        land.setFertilize(true);
        assertTrue(land.isFertilize());
    }

    @Test
    public void test_isEmpty() {
        assertTrue(land.isEmpty());
    }

    @Test // might need further test
    public void test_isWet() {
        assertFalse(land.isWet());
    }

    @Test
    public void test_getWaterTime_setWaterTime_getPlant_setPlant() {
         assertEquals("-1", land.getWaterTime());
         Seeds test_seed = new Seeds("test", 5, 5, 5, 5);
         assertNull(land.getPlant());
         land.setPlant(test_seed);
         assertEquals(test_seed, land.getPlant());
         land.setWaterTime();
         // not sure how to test get water time after set water time
    }

    @Test
    public void test_addStage_getStage() {
        assertEquals(0, land.getStage());
        land.addStage();
        assertEquals(1, land.getStage());
        land.addStage();
        land.addStage();
        assertEquals(2, land.getStage());
    }

    @Test
    public void reset() {
        Seeds test_seed = new Seeds("test", 5, 5, 5, 5);
        land.setPlant(test_seed);
        land.addStage();
        land.setWaterTime();
        land.setFertilize(true);
        land.reset();
        assertNull(land.getPlant());
        assertEquals(0, land.getStage());
        assertEquals("-1", land.getWaterTime());
        assertFalse(land.isFertilize());
    }
}