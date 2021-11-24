package com.farmgame.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Item.WateringCan;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

public class WarehouseTest {
    HashMap<Integer, ArrayList<Item>> itemInventory = new HashMap<>();
    HashMap<Integer, ArrayList<Plants>> plantInventory = new HashMap<>();
    HashMap<Integer, ArrayList<Seeds>> seedInventory = new HashMap<>();
    Warehouse warehouse = new Warehouse(itemInventory, plantInventory,seedInventory,20);
    Plants potato = new Plants("Potato", 60, 12);
    Plants berry = new Plants("Berry", 60, 11);
    Fertilizer fertilizer = new Fertilizer(10, 14159);
    WateringCan wateringCan = new WateringCan(5, 26535);
    Seeds potatoSeed = new Seeds("PotatoSeed", 10, 10,10,10);
    Seeds bananaSeed = new Seeds("BananaSeed", 10, 10,10,9);

    @Test(timeout = 50)
    public void test_getItemInventory_setItemInventory(){
        ArrayList<Item> fertilizerArrayList = new ArrayList<>();
        ArrayList<Item> wateringCanArrayList = new ArrayList<>();
        fertilizerArrayList.add(this.fertilizer);
        wateringCanArrayList.add(this.wateringCan);
        this.itemInventory.put(1, fertilizerArrayList);
        this.itemInventory.put(2, wateringCanArrayList);
        this.warehouse.setItemInventory(this.itemInventory);
        assertEquals(this.warehouse.getItemInventory(), this.itemInventory);
    }

    @Test(timeout = 50)
    public void test_getPlantInventory_setPlantInventory(){
        ArrayList<Plants> potatoArrayList = new ArrayList<>();
        ArrayList<Plants> berryArrayList = new ArrayList<>();
        potatoArrayList.add(this.potato);
        berryArrayList.add(this.berry);
        this.plantInventory.put(12, potatoArrayList);
        this.plantInventory.put(11, berryArrayList);
        this.warehouse.setPlantInventory(this.plantInventory);
        assertEquals(this.warehouse.getPlantInventory(), this.plantInventory);
    }

    @Test(timeout = 50)
    public void test_getSeedsInventory_setSeedInventory(){
        ArrayList<Seeds> potatoSeedsArrayList = new ArrayList<>();
        ArrayList<Seeds> bananaSeedsArrayList = new ArrayList<>();
        potatoSeedsArrayList.add(this.potatoSeed);
        bananaSeedsArrayList.add(this.bananaSeed);
        this.seedInventory.put(10, potatoSeedsArrayList);
        this.seedInventory.put(9, bananaSeedsArrayList);
        this.warehouse.setSeedInventory(this.seedInventory);
        assertEquals(this.warehouse.getSeedInventory(), this.seedInventory);
    }

    @Test(timeout = 50)
    public void test_contains(){
        ArrayList<Plants> potatoArrayList = new ArrayList<>();
        potatoArrayList.add(this.potato);
        this.plantInventory.put(12, potatoArrayList);
        warehouse.setPlantInventory(this.plantInventory);
        assertTrue(warehouse.contains("Potato"));
        assertFalse(warehouse.contains("Giraffe"));
    }

    @Test(timeout = 50)
    public void test_getCapacity_setCapacity(){
        assertEquals(warehouse.getCapacity(),20);
        warehouse.setCapacity(10);
        assertEquals(warehouse.getCapacity(),10);
    }

    @Test(timeout = 50)
    public void test_getPlants(){
        ArrayList<Plants> potatoArrayList = new ArrayList<>();
        potatoArrayList.add(this.potato);
        potatoArrayList.add(this.potato);
        ArrayList<Plants> berryArrayList = new ArrayList<>();
        berryArrayList.add(this.berry);
        this.plantInventory.put(11, berryArrayList);
        this.plantInventory.put(12, potatoArrayList);
        this.warehouse.setPlantInventory(this.plantInventory);
        assertEquals(this.warehouse.getPlants("Potato"), this.potato);
    }

    @Test(timeout = 50)
    public void test_getSeeds(){
        ArrayList<Seeds> potatoSeedsArrayList = new ArrayList<>();
        potatoSeedsArrayList.add(this.potatoSeed);
        ArrayList<Seeds> bananaSeedsArrayList = new ArrayList<>();
        bananaSeedsArrayList.add(this.bananaSeed);
        potatoSeedsArrayList.add(this.potatoSeed);
        this.seedInventory.put(10, potatoSeedsArrayList);
        this.seedInventory.put(9, bananaSeedsArrayList);
        this.warehouse.setSeedInventory(this.seedInventory);
        assertEquals(this.warehouse.getSeeds("PotatoSeed"), this.potatoSeed);
        assertEquals(this.warehouse.getSeeds(10), this.potatoSeed);
    }

    @Test(timeout = 50)
    public void test_getItems(){
        ArrayList<Item> fertilizerArrayList = new ArrayList<>();
        fertilizerArrayList.add(this.fertilizer);
        ArrayList<Item> wateringCanArrayList = new ArrayList<>();
        wateringCanArrayList.add(this.wateringCan);
        this.itemInventory.put(1, fertilizerArrayList);
        this.itemInventory.put(2, wateringCanArrayList);
        this.warehouse.setItemInventory(this.itemInventory);
        assertEquals(this.warehouse.getItem("Fertilizer"), this.fertilizer);
    }

    // unused code: @Test
    // unused code: public void test_checkCapacity() {
    // unused code: }
}
