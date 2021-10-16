package com.farmgame;

import static org.junit.Assert.*;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Hoe;

import org.junit.Test;

public class ItemUnitTest {
    Hoe hoe = new Hoe();
    Fertilizer fertilizer = new Fertilizer();

    @Test
    public void test_getNum_usage() {
        assertEquals(10, fertilizer.getNum_usage());
        assertEquals(-1, hoe.getNum_usage());
    }
}
