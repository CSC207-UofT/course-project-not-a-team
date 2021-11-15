package com.farmgame.usecase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.farmgame.entity.Player;
import java.util.HashMap;

public class PlayerManagerUnitTest {
    Player player = new Player("Connor", 1, 1000, new int[]{0, 10});
    HashMap<Integer, Integer> test_exp_map = new HashMap<>();
    PlayerManager pm;

    @Before
    public void set_up() {
        test_exp_map.put(1, 10);
        test_exp_map.put(2, 20);
        test_exp_map.put(3, 30);
        test_exp_map.put(4, 40);
        test_exp_map.put(50, 500);
        pm = new PlayerManager(player, test_exp_map);

    }

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