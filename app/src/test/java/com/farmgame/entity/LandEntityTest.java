package com.farmgame.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class LandEntityTest {
    LandEntity land = new LandEntity(LandEntity.LOCK_STATUS_LOCKED, true, false, false, -1, -1,-1);
    @Test
    public void setUnlocked() {
        land.setUnlocked(true);
        assertTrue(land.isUnlocked());
    }

    @Test
    public void getLockStatus() {
        assertEquals(land.getLockStatus(), LandEntity.LOCK_STATUS_LOCKED);
    }

//    @Test
//    public void setLockStatus() {
//    }
//
//    @Test
//    public void isEmpty() {
//    }
//
//    @Test
//    public void setEmpty() {
//    }
//
//    @Test
//    public void isWet() {
//    }
//
//    @Test
//    public void setWet() {
//    }
//
//    @Test
//    public void isFertilize() {
//    }
//
//    @Test
//    public void setFertilize() {
//    }
//
//    @Test
//    public void getHarvestTime() {
//    }
//
//    @Test
//    public void setHarvestTime() {
//    }
//
//    @Test
//    public void getWaterTime() {
//    }
//
//    @Test
//    public void setWaterTime() {
//    }
//
//    @Test
//    public void getFertilizeTime() {
//    }
//
//    @Test
//    public void setFertilizeTime() {
//    }
}