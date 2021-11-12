package com.farmgame.usecase;

import static com.farmgame.constants.Constants.*;

import com.farmgame.entity.Player;
import com.farmgame.gateway.PlayerDBApi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Observable;

public class PlayerManager extends Observable {
    private final Player player;
    private final HashMap<Integer, Integer> expMap;

    // constant
    private final int MAX_LEVEL;

    /**
     * Constructor for PlayerManager
     *
     * @param player an instance of player to manage
     */
    public PlayerManager(Player player) {
        this.player = player;
        expMap = PlayerDBApi.getExpTable();
        MAX_LEVEL = Collections.max(expMap.keySet());
    }

    /**
     * Getter for Player attribute.
     *
     * @return Player
     */
    public Player getPlayer() { return player; }

    /**
     * Gain exp for player, and level up if necessary.
     *
     * @param exp amount of exp gained.
     */
    public void gainExp(int exp) {
        if (this.player.getLevel() < MAX_LEVEL) {
            this.player.getExp_bar()[0] += exp;
            while (this.player.getExp_bar()[0] >= this.player.getExp_bar()[1]) {
                this.player.getExp_bar()[0] -= this.player.getExp_bar()[1];
                this.levelUp();
            }
        }
    }

    /**
     * Level up for player, called during gaining exp.
     */
    public void levelUp() {
        if (this.player.getLevel() < MAX_LEVEL) {
            this.player.setLevel(this.player.getLevel() + 1) ;

            Integer exp = this.expMap.get(this.getPlayer().getLevel());
            if (exp != null) {
                this.player.getExp_bar()[1] = (int) exp;
            }
        }
        else {
            this.player.getExp_bar()[0] = 0;
        }
        setChanged();
        notifyObservers(UPDATE_PLAYER);

    }

    /**
     * Add money_num to player money attribute.
     *
     * @param money_num amount of money added
     */
    public void addMoney(int money_num) {
        this.player.setMoney(this.player.getMoney() + money_num);
        setChanged();
        notifyObservers(UPDATE_PLAYER);
    }

    /**
     * Subtract money_num away from player money attribute.
     *
     * @param money_num amount of money subtracted
     * @return boolean true if and only if there is enough money to subtract
     */
    public boolean subtractMoney(int money_num) {
        if (this.player.getMoney() < money_num) {
            return false;
        }
        else {
            this.player.setMoney(this.player.getMoney() - money_num);
            setChanged();
            notifyObservers(UPDATE_PLAYER);
            return true;
        }
    }
}

