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
    WarehouseManager wm = new WarehouseManager(warehouse);

    HashMap<Integer, ArrayList<Item>> itemInventory2 = new HashMap<>();
    HashMap<Integer, ArrayList<Plants>> plantInventory2 = new HashMap<>();
    HashMap<Integer, ArrayList<Seeds>> seedInventory2 = new HashMap<>();
    Warehouse warehouse2 = new Warehouse(itemInventory2, plantInventory2,seedInventory2,20);
    WarehouseManager wm2 = new WarehouseManager(warehouse2);

    Plants potato = new Plants("Potato", 60, 12);
    Plants berry = new Plants("Berry", 60, 11);

    @Test(timeout = 50)
    public void test_getWarehouse(){
        assertEquals(this.warehouse, wm.getWarehouse());
    }

    @Test(timeout = 50)
    public void test_addProduct() {
        this.wm.addProduct(this.potato, 1);

        ArrayList<Plants> plantsArrayList = new ArrayList<>();
        plantsArrayList.add(this.potato);
        plantInventory2.put(12, plantsArrayList);
        warehouse2.setPlantInventory(plantInventory2);

        assertEquals(wm.getWarehouse().getPlantInventory().get(12),wm2.getWarehouse().getPlantInventory().get(12));


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
        this.plantInventory2.put(11,berryArrayList2);
        warehouse2.setPlantInventory(this.plantInventory2);
        assertEquals(this.wm2.getWarehouse().getPlantInventory(), this.wm.getWarehouse().getPlantInventory());

    }

}
