package com.farmgame.usecase;


import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Hoe;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Player;
import com.farmgame.entity.Warehouse;

import static com.farmgame.constants.Constants.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LandManagerTest {
    LandManager landManager;
    Hoe hoe = new Hoe();
    Fertilizer fertilizer = new Fertilizer();
    Warehouse warehouse = new Warehouse();
    Player player = new Player("Connor", 1, 1000, new int[]{0, 10}, warehouse);
    PlayerManager pm = new PlayerManager(player);
    Plants plant1 = new Plants("plantA", 30, 23, 43, 5);
    Plants plant2 = new Plants("plantB", 30, 23, 43, 5);
    LandEntity land = new LandEntity(LOCK_STATUS_LOCKED, plant1,  0, 0 , 0,0);

    @Before
    public void setUp() throws Exception {

        landManager = new LandManager(land);
    }

    @Test
    public void planting() {
        landManager.getLand().reset();
        landManager.planting(plant2);
        assertEquals(plant2, landManager.getLand().getPlant());

    }

    @Test
    public void Harvest() {
        landManager.getLand().addStage();
        landManager.getLand().addStage();
        landManager.harvest(pm, hoe, warehouse);
        assertArrayEquals(new int[]{5, 10}, pm.getPlayer().getExp_bar());
        assertTrue(warehouse.getPlantInventory().contains(plant1));

    }
    @Test
    public void fertilize(){
        landManager.getLand().setHarvestTime(40);
        landManager.fertilize(fertilizer);
        assertEquals(100, landManager.getLand().getFertilizeTime());
        assertEquals(30, landManager.getLand().getHarvestTime());

    }
    @Test
    public void watering(){
        landManager.getLand().setWaterTime(0);
        landManager.watering();
        assertEquals(100, landManager.getLand().getWaterTime());
        assertEquals(1, landManager.getLand().getStage());
    }
}
