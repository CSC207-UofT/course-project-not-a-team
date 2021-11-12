package com.farmgame.usecase;

import static org.junit.Assert.assertEquals;

import com.farmgame.entity.Item.Item;

import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;
import com.farmgame.entity.Warehouse;
import com.farmgame.usecase.WarehouseManager.WarehouseManager;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class WarehouseManagerTest {
    HashMap<Integer, ArrayList<Item>> itemInventory = new HashMap<>();
    HashMap<Integer, ArrayList<Plants>> plantInventory = new HashMap<>();
    HashMap<Integer, ArrayList<Seeds>> seedInventory = new HashMap<>();
    Warehouse warehouse = new Warehouse(itemInventory, plantInventory,seedInventory,20);
    Plants potato = new Plants("Potato", 60, 12);
    Plants berry = new Plants("Berry", 60, 11);
    WarehouseManager wm = new WarehouseManager(warehouse);
    @Test(timeout = 50)
    public void test_getWarehouse(){
        Warehouse warehouse2 = new Warehouse(this.itemInventory, this.plantInventory,this.seedInventory,20);
        assertEquals(warehouse2, wm.getWarehouse());
    }
    @Test(timeout = 50)
    public void test_addProduct() {
        this.wm.addProduct(this.potato);
        ArrayList<Plants> plantsArrayList = new ArrayList<>();
        plantsArrayList.add(this.potato);
        HashMap<Integer, ArrayList<Plants>> tempPlantInventory = new HashMap<>();
        tempPlantInventory.put(10, plantsArrayList);
        Warehouse warehouse2 = new Warehouse(this.itemInventory, tempPlantInventory,this.seedInventory,20);
        assertEquals(warehouse2, wm.getWarehouse());

    }
    @Test(timeout = 50)
    public void test_removeProduct() {
        ArrayList<Plants> berryArrayList = new ArrayList<>();
        berryArrayList.add(this.berry);
        berryArrayList.add(this.berry);
        this.plantInventory.put(11, berryArrayList);
        wm.getWarehouse().setPlantInventory(this.plantInventory);
        wm.removeProduct(this.berry);

        ArrayList<Plants> berryArrayList2 = new ArrayList<>();
        berryArrayList2.add(this.berry);
        HashMap<Integer, ArrayList<Plants>> tempPlantInventory2 = new HashMap<>();
        tempPlantInventory2.put(10,berryArrayList2);
        Warehouse warehouse3 = new Warehouse(this.itemInventory, tempPlantInventory2,this.seedInventory,20);
        assertEquals(warehouse3, wm.getWarehouse());

    }

}
