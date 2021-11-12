package com.farmgame.entity;

import static org.junit.Assert.*;

import com.farmgame.entity.Store;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;

import org.junit.Test;

import java.util.ArrayList;


public class StoreUnitTest {
    Plants potato = new Plants("Potato", 60, 12);
    Plants berry = new Plants("Berry", 60, 11);
    Seeds potatoSeed = new Seeds("PotatoSeed", 10, 10,10,10);
    Seeds bananaSeed = new Seeds("BananaSeed", 10, 10,10,9);
    ArrayList<Plants> plantsArrayList = new ArrayList<>();
    ArrayList<Seeds> seedsArrayList = new ArrayList<>();
    ArrayList<Item> itemArrayList = new ArrayList<>();
//    Store test_store = new Store(Player());
//    @Test
//    public void test_GetStoreLevel() {
//        assertEquals(test_store.getStoreLevel(), 1);
//
//    }

//    @Test
//    public void test_SetStoreLevel(){
//        test_store.setStoreLevel(2);
//        assertEquals(test_store.getStoreLevel(), 2);
//    }
}
