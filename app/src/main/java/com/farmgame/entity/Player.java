package com.farmgame.entity;

public class Player {
    private int level;
    private int[] exp_bar;
    private Warehouse warehouse;
    private int money;
    private String name;

    // Question, about the initial value of the following parameters
    private final int LEVEL_1_EXP = 10;
    private final int INITIAL_MONEY = 1000;
    private final int MAX_LEVEL = 50;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.exp_bar = new int[]{0, LEVEL_1_EXP};
        this.warehouse = new Warehouse();
        this.money = INITIAL_MONEY;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public int[] getExp_bar() {
        return this.exp_bar;
    }

    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    public int getMoney() {
        return this.money;
    }

    public void gainExp(int exp) {
        if (this.level < MAX_LEVEL) {
            this.exp_bar[0] += exp;
            while (this.exp_bar[0] >= this.exp_bar[1]) {
                this.exp_bar[0] -= this.exp_bar[1];
                this.levelUp();
            }
        }
    }

    public void levelUp() {
        if (this.level < MAX_LEVEL) {
            this.level += 1;

            // how to calculate new exp_bar when level up?
            this.exp_bar[1] = this.level * LEVEL_1_EXP;

            // unlock new features?

        }
        else {
            this.exp_bar[0] = 0;
        }
    }
}