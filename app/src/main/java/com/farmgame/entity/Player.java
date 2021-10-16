package com.farmgame.entity;

public class Player {
    private final String name;
    private int level;
    private int money;
    private final int[] exp_bar;
    private final Warehouse warehouse;

    /**
     * Constructor for Player.
     *
     * @param name name of player
     * @param level level of player
     * @param money money of player
     * @param exp_bar exp bar of player
     * @param warehouse warehouse of player
     */
    public Player(String name, int level, int money, int[] exp_bar, Warehouse warehouse) {
        this.name = name;
        this.level = level;
        this.money = money;
        this.exp_bar = exp_bar;
        this.warehouse = warehouse;
    }

    /**
     * Getter for name attribute.
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for level attribute.
     *
     * @return int
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Getter for money attribute.
     *
     * @return int
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Getter for exp bar attribute.
     *
     * @return int[]
     */
    public int[] getExp_bar() {
        return this.exp_bar;
    }

    /**
     * Getter for Warehouse attribute.
     *
     * @return Warehouse
     */
    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    /**
     * Setter for level attribute.
     *
     * @param level new level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Setter for money attribute.
     *
     * @param money new money
     */
    public void setMoney(int money) {this.money = money; }
}