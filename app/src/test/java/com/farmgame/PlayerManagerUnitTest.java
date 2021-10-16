package com.farmgame;

import static org.junit.Assert.*;
import org.junit.Test;

import com.farmgame.entity.Player;
import com.farmgame.usecase.PlayerManager;

public class PlayerManagerUnitTest {
    Warehouse warehouse = new Warehouse();
    Player player = new Player("Connor", 1, 1000, new int[]{0, 10}, warehouse);
    PlayerManager pm = new PlayerManager(player);

    @Test(timeout = 50)
    public void test_getPlayer() {
        assertEquals(player, pm.getPlayer());
    }

    @Test(timeout = 50)
    public void test_gainExp() {
        pm.gainExp(10);
        assertEquals(2, pm.getPlayer().getLevel());
        assertArrayEquals(new int[]{0, 20}, pm.getPlayer().getExp_bar());

        pm.gainExp(60);
        assertEquals(4, pm.getPlayer().getLevel());
        assertArrayEquals(new int[]{10, 40}, pm.getPlayer().getExp_bar());

        pm.getPlayer().setLevel(49);
        pm.gainExp(1000);
        assertEquals(50, pm.getPlayer().getLevel());
        assertArrayEquals(new int[]{0, 500}, pm.getPlayer().getExp_bar());
    }

    @Test(timeout = 50)
    public void test_addMoney() {
        pm.addMoney(500);
        assertEquals(1500, pm.getPlayer().getMoney());
    }

    @Test(timeout = 50)
    public void test_subtractMoney() {
        assertTrue(pm.subtractMoney(500));
        assertEquals(500, pm.getPlayer().getMoney());
        assertFalse(pm.subtractMoney(1000));
        assertEquals(500, pm.getPlayer().getMoney());
    }
}
