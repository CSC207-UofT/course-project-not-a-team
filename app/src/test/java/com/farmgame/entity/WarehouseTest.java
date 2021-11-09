package com.farmgame.entity;

import static org.junit.Assert.assertEquals;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Item;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class WarehouseTest {
    Player player = new Player("Harriet", 1, 1000, new int[]{0, 10});
    Warehouse warehouse = new Warehouse(player);
    Plants Potato = new Plants("Potato", 60, 12, 18, 30);
    Plants Berry = new Plants("Berry", 60, 12, 18, 30);

    Fertilizer fertilizer = new Fertilizer();
    ArrayList<Item> itemInventory = new ArrayList<Item>(Arrays.asList(fertilizer, fertilizer));
    ArrayList<Plants> plantInventory = new ArrayList<Plants>(Arrays.asList(Potato, Berry, Potato));


    @Test(timeout = 50)
    public void test_getItemInventory(){
        warehouse.setItemInventory(itemInventory);
        assertEquals(new ArrayList<Item>(Arrays.asList(fertilizer, fertilizer)), itemInventory);
    }

    @Test(timeout = 50)
    public void test_getPlantInventory(){
        warehouse.setPlantInventory(plantInventory);
        assertEquals(new ArrayList<Plants>(Arrays.asList(Potato, Berry, Potato)), plantInventory);
    }

    @Test(timeout = 50)
    public void test_getCapacity(){
        assertEquals(warehouse.getCapacity(),5);
        warehouse.setCapacity(5);
        assertEquals(warehouse.getCapacity(),10);
    }
}
