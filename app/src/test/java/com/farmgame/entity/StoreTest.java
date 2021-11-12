package com.farmgame.entity;

import static org.junit.Assert.assertEquals;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.WateringCan;
import com.farmgame.entity.Item.Item;

import org.junit.Test;

import java.util.ArrayList;


public class StoreTest {
    Plants potato = new Plants("Potato", 60, 12);
    Plants berry = new Plants("Berry", 60, 11);
    ArrayList<Plants> plantsArrayList = new ArrayList<>();
    ArrayList<Seeds> seedsArrayList = new ArrayList<>();
    ArrayList<Item> itemArrayList = new ArrayList<>();
    Store store = new Store(plantsArrayList, seedsArrayList, itemArrayList);
    Seeds potatoSeed = new Seeds("PotatoSeed", 10, 10,10,10);
    Seeds bananaSeed = new Seeds("BananaSeed", 10, 10,10,9);
    Fertilizer fertilizer = new Fertilizer();
    WateringCan wateringCan = new WateringCan();

    @Test(timeout = 50)
    public void test_getCurrentProducts_plants(){
        this.plantsArrayList.add(potato);
        this.plantsArrayList.add(berry);
        assertEquals(this.plantsArrayList, store.getCurrentProducts_plants());
        }

    @Test(timeout = 50)
    public void test_getCurrentSeed(){
        this.seedsArrayList.add(potatoSeed);
        this.seedsArrayList.add(bananaSeed);
        assertEquals(this.seedsArrayList, store.getCurrentSeed());
    }

    @Test(timeout = 50)
    public void test_getCurrentProducts_items(){
        this.itemArrayList.add(fertilizer);
        this.itemArrayList.add(wateringCan);
        assertEquals(this.itemArrayList, store.getCurrentProducts_items());
    }
}
