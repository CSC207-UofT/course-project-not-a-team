package com.farmgame.usecase;

import com.farmgame.entity.Player;

public class PlayerManager {
    private Player player;

    // constant
    private final int MAX_LEVEL = 50;
    private final int LEVEL_1_EXP = 10;

    /**
     * Constructor for PlayerManager
     *
     * @param player an instance of player to manage
     */
    public PlayerManager(Player player) {
        this.player = player;
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

            // how to calculate new exp_bar when level up?
            this.player.getExp_bar()[1] = this.player.getLevel() * LEVEL_1_EXP;
        }
        else {
            this.player.getExp_bar()[0] = 0;
        }
    }

    /**
     * Add money_num to player money attribute.
     *
     * @param money_num amount of money added
     */
    public void addMoney(int money_num) {
        this.player.setMoney(this.player.getMoney() + money_num);
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
            return true;
        }
    }
}

