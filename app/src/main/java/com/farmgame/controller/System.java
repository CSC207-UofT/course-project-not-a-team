package com.farmgame.controller;

import static com.farmgame.constants.Constants.ADD_MONEY;
import static com.farmgame.constants.Constants.OB_LAND_CHANGED;
import static com.farmgame.constants.Constants.OB_LEVEL_UP;
import static com.farmgame.constants.Constants.SUBTRACT_MONEY;
import static com.farmgame.constants.Constants.WAREHOUSE_ADD;

import java.util.Observable;
import java.util.Observer;

public abstract class System implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        int state = (int) arg;
        switch (state) {
            case OB_LEVEL_UP:
                break;
            case ADD_MONEY:
                break;
            case SUBTRACT_MONEY:
                break;
            case WAREHOUSE_ADD:
                break;
            case OB_LAND_CHANGED:
                break;

        }
    }
}
