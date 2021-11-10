package com.farmgame.entity;

import static com.farmgame.constants.Constants.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LandEntityTest {
    LandEntity land;

    @Before
    public void setUp() {

        Plants plant = new Plants("plantA", 30, 23, 43, 5);
        land = new LandEntity(LOCK_STATUS_LOCKED, plant,  23, 0 , 0);
    }

    @Test
    public void getLockStatus() {
        assertEquals(land.getLockStatus(), LOCK_STATUS_LOCKED);
    }
//
    @Test
    public void setLockStatus() {
        land.setLockStatus(LOCK_STATUS_BOUGHT);
        assertEquals(land.getLockStatus(), LOCK_STATUS_BOUGHT);
    }

    @Test
    public void isEmpty() {
        assertFalse(land.isEmpty());
    }


    @Test
    public void isWet() {
        assertTrue(land.isWet());
    }


    @Test
    public void isFertilize() {
        assertFalse(land.isFertilize());
    }

    @Test
    public void getWaterTime() {
        assertEquals(land.getWaterTime(), 30);
    }

    @Test
    public void setWaterTime() {
        land.setWaterTime(60);
        assertEquals(land.getWaterTime(), 60);
    }

    @Test
    public void getFertilizeTime() {
        assertEquals(land.getFertilizeTime(), 0);
    }

    @Test
    public void reset() {
        land.reset();
        assertTrue(land.isEmpty());
        assertEquals(land.getStage(), 0);
        assertFalse(land.isWet());
        assertFalse(land.isFertilize());
    }
}