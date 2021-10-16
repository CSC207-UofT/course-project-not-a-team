package com.farmgame;

import static org.junit.Assert.*;

import org.junit.Test;

public class StoreUnitTest {
    Store test_store = new Store(1);
    @Test
    public void test_GetStoreLevel() {
        assertEquals(test_store.getStoreLevel(), 1);

    }

    @Test
    public void test_SetStoreLevel(){
        test_store.setStoreLevel(2);
        assertEquals(test_store.getStoreLevel(), 2);
    }
}
