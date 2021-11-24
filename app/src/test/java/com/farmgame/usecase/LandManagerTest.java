package com.farmgame.usecase;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.WateringCan;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Player;
import com.farmgame.entity.Seeds;
import static com.farmgame.constants.Constants.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

public class LandManagerTest {
    LandManager landManager;
    Fertilizer fertilizer = new Fertilizer(10, 14159);
    WateringCan wateringCan = new WateringCan(5, 26535);
    Player player = new Player("Connor", 1, 1000, new int[]{0, 10});
    // unused code: HashMap<Integer, ArrayList<Item>> itemInventory = new HashMap<>();
    // unused code: HashMap<Integer, ArrayList<Plants>> plantInventory = new HashMap<>();
    // unused code: HashMap<Integer, ArrayList<Seeds>> seedInventory = new HashMap<>();
    // unused code: Warehouse warehouse = new Warehouse(itemInventory, plantInventory, seedInventory, 10);
    // unused code: WarehouseManipulate wm = new WarehouseManager(warehouse);
    HashMap<Integer, Integer> test_exp_map = new HashMap<>();
    PlayerManager pm;
    // unused code: Seeds plant1 = new Seeds("plantA", 30, 23, 10, 1);
    Seeds plant2 = new Seeds("plantB", 40, 33, 20, 2);
    LandEntity land = new LandEntity(LOCK_STATUS_LOCKED, null,  "-1", 0 ,
            false, 0, 0, 2);
    HashMap<Integer, LandEntity> landMap = new HashMap<>();

    @Before
    public void setUp() {
        landManager = new LandManager(landMap);
        landMap.put(1, land);
        test_exp_map.put(1, 10);
        pm = new PlayerManager(player, test_exp_map);
    }


    @Test
    public void test_getLand() {
        assertEquals(land, landManager.getLand(1));
    }

    @Test
    public void planting() {
        landManager.getLand(1).reset();
        landManager.planting(1, plant2);
        assertEquals(plant2, landManager.getLand(1).getPlant());
    }

    @Test
    public void Harvest() {
        landManager.harvest(1);
        assertNull(landManager.getLand(1).getPlant());

    }
    @Test
    public void fertilize(){
        landManager.fertilize(1, fertilizer);
        assertTrue(landManager.getLand(1).isFertilize());

    }
    @Test
    public void watering(){
        landManager.getLand(1).setPlant(plant2);
        landManager.watering(1, wateringCan);
        assertEquals(1, landManager.getLand(1).getStage());
    }

    @Test
    public void test_buy_unlock() {
        landManager.unLock(1);
        assertEquals(1, landManager.getLand(1).getLockStatus());
        landManager.buy(1);
        assertEquals(2, landManager.getLand(1).getLockStatus());
    }
}
