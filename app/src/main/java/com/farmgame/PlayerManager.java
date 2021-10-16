package com.farmgame;

public class PlayerManager {
    private Player player;
    private final int MAX_LEVEL = 50;
    private final int LEVEL_1_EXP = 10;

    public PlayerManager(Player player) {
        this.player = player;
    }

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
     * level up for player, called during gaining exp.
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
}
