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
    Fertilizer fertilizer = new Fertilizer();
    WateringCan wateringCan = new WateringCan();
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

    @Before
    public void setUp() {
        landManager = new LandManager(land);
        test_exp_map.put(1, 10);
        pm = new PlayerManager(player, test_exp_map);
    }

    @Test
    public void test_getLand() {
        assertEquals(land, landManager.getLand());
    }

    @Test
    public void planting() {
        landManager.getLand().reset();
        landManager.planting(plant2);
        assertEquals(plant2, landManager.getLand().getPlant());
    }

    @Test
    public void Harvest() {
        landManager.harvest();
        assertNull(landManager.getLand().getPlant());

    }
    @Test
    public void fertilize(){
        landManager.fertilize(fertilizer);
        assertTrue(landManager.getLand().isFertilize());

    }
    @Test
    public void watering(){
        landManager.getLand().setPlant(plant2);
        landManager.watering(wateringCan);
        assertEquals(1, landManager.getLand().getStage());
    }

    @Test
    public void test_buy_unlock() {
        landManager.unLock();
        assertEquals(1, landManager.getLand().getLockStatus());
        landManager.buy();
        assertEquals(2, landManager.getLand().getLockStatus());
    }
}
