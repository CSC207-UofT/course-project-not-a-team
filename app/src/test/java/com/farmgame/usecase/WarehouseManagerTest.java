package com.farmgame.usecase;

import static org.junit.Assert.assertEquals;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Player;
import com.farmgame.entity.Warehouse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WarehouseManagerTest {
    Player player = new Player("Harriet", 1, 1000, new int[]{0, 10});
    Warehouse warehouse = new Warehouse(player);
    Plants Potato = new Plants("Potato", 60, 12, 18, 30);
    Plants Berry = new Plants("Berry", 60, 12, 18, 30);
    WarehouseManager wm = new WarehouseManager(warehouse);
    Fertilizer fertilizer = new Fertilizer();
    @Test(timeout = 50)
    public void test_getWarehouse(){
        assertEquals(new Warehouse(player), wm.getWarehouse());
    }
    @Test(timeout = 50)
    public void test_addItem() {
        wm.addItem(fertilizer);
        assertEquals(new ArrayList<Item>(Collections.singletonList(fertilizer)), warehouse.getItemInventory());

    }
    @Test(timeout = 50)
    public void test_removeItem() {
        wm.removeItem(fertilizer);
        assertEquals(new ArrayList<Item>(), warehouse.getItemInventory());

    }
    @Test(timeout = 50)
    public void test_addPlant() {
        wm.addPlant(Potato);
        assertEquals(new ArrayList<Plants>(Collections.singletonList(Potato)), warehouse.getPlantInventory());
    }
    @Test(timeout = 50)
    public void test_removePlant() {
        wm.removePlant(Potato);
        assertEquals(new ArrayList<Plants>(), warehouse.getPlantInventory());

    }
}
