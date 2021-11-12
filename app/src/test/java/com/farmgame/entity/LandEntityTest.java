package com.farmgame.entity;

import static com.farmgame.constants.Constants.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LandEntityTest {
    LandEntity land;

    @Before
    public void setUp() {

        land = new LandEntity(LOCK_STATUS_LOCKED, null,  "-1", 0 , 0, 0, 0);
    }

    @Test
    public void getLockStatus() {
        assertEquals(land.getLockStatus(), LOCK_STATUS_LOCKED);
    }

    @Test
    public void test_getIndex_setIndex(){
        land.setIndex(1);
        assertEquals(1, land.getIndex());
    }

    @Test
    public void test_setPrice() {
        land.setPrice(1000);
        assertEquals(1000, land.getPrice());
    }

    @Test
    public void setLockStatus() {
        land.setLockStatus(LOCK_STATUS_BOUGHT);
        assertEquals(land.getLockStatus(), LOCK_STATUS_BOUGHT);
    }

    @Test
    public void isEmpty() {
        assertTrue(land.isEmpty());
    }


    @Test
    public void isWet() {
        assertFalse(land.isWet());
    }


    @Test
    public void isFertilize() {
        assertFalse(land.isFertilize());
    }

    @Test
    public void getWaterTime() {
        assertEquals(land.getWaterTime(), "-1");
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