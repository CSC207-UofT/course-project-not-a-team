package com.farmgame.entity;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerUnitTest {
    Player player = new Player("Connor", 1, 1000, new int[]{0, 10});

    @Test(timeout = 50)
    public void test_getName() {
        assertEquals("Connor", player.getName());
    }

    @Test(timeout = 50)
    public void test_getLevel() {
        assertEquals(1, player.getLevel());
    }

    @Test(timeout = 50)
    public void test_getMoney() {
        assertEquals(1000, player.getMoney());
    }

    @Test(timeout = 50)
    public void test_getExp_bar() {
        assertArrayEquals(new int[]{0, 10}, player.getExp_bar());
    }

    @Test(timeout = 50)
    public void test_setLevel() {
        player.setLevel(2);
        assertEquals(2, player.getLevel());
    }

    @Test(timeout = 50)
    public void test_setMoney() {
        player.setMoney(2000);
        assertEquals(2000, player.getMoney());
    }
}