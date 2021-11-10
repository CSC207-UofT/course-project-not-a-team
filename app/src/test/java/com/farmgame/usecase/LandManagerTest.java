package com.farmgame.usecase;


import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.WateringCan;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Player;
import com.farmgame.entity.Seeds;
import com.farmgame.entity.Warehouse;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;
import com.farmgame.usecase.WarehouseManager.WarehouseMunipulate;

import static com.farmgame.constants.Constants.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LandManagerTest {
    LandManager landManager;
    Fertilizer fertilizer = new Fertilizer();
    WateringCan wateringCan = new WateringCan();
    Player player = new Player("Connor", 1, 1000, new int[]{0, 10});
    Warehouse warehouse = new Warehouse(player);
    WarehouseMunipulate wm = new WarehouseManager<>(warehouse);
    PlayerManager pm = new PlayerManager(player);
    Seeds plant1 = new Seeds("plantA", 30, 23, 10, 1);
    Seeds plant2 = new Seeds("plantB", 40, 33, 20, 2);
    LandEntity land = new LandEntity(LOCK_STATUS_LOCKED, plant1,  0, 0 , 0);

    @Before
    public void setUp() {

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
        landManager.harvest(pm, wm);
        assertArrayEquals(new int[]{5, 10}, pm.getPlayer().getExp_bar());

    }
    @Test
    public void fertilize(){
        landManager.fertilize(fertilizer);
        assertEquals(100, landManager.getLand().getFertilizeTime());

    }
    @Test
    public void watering(){
        landManager.getLand().setWaterTime(0);
        landManager.watering(wateringCan);
        assertEquals(100, landManager.getLand().getWaterTime());
        assertEquals(1, landManager.getLand().getStage());
    }
}
