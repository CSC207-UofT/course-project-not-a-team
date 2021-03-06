package com.farmgame.entity;

public class Player {
    private final String name;
    private int level;
    private int money;
    private int[] exp_bar;

    /**
     * Constructor for Player.
     *
     * @param name name of player
     * @param level level of player
     * @param money money of player
     * @param exp_bar exp bar of player
     */
    public Player(String name, int level, int money, int[] exp_bar) {
        this.name = name;
        this.level = level;
        this.money = money;
        this.exp_bar = exp_bar;
    }

    /**
     * Getter for name attribute.
     *
     * @return String the name of player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for level attribute.
     *
     * @return int the level of player
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Getter for money attribute.
     *
     * @return int the money of player
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Getter for exp bar attribute.
     *
     * @return int[] the exp bar of player
     */
    public int[] getExp_bar() {
        return this.exp_bar;
    }

    public void setExpBar(int[] exp_bar){
        this.exp_bar = exp_bar;
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