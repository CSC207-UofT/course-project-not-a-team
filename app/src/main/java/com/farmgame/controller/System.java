package com.farmgame.controller;

import static com.farmgame.constants.Constants.UPDATE_PLAYER;
import static com.farmgame.constants.Constants.UPDATE_LAND;
import static com.farmgame.constants.Constants.UPDATE_WAREHOUSE;

import com.farmgame.constants.Constants;
import com.farmgame.gateway.LandDBApi;
import com.farmgame.gateway.PlayerDBApi;
import com.farmgame.gateway.WarehouseDBApi;

import java.util.Observable;
import java.util.Observer;

public abstract class System implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        int state = (int) arg;
        switch (state) {
            case UPDATE_PLAYER:
                PlayerDBApi.updatePlayer();
                break;
            case UPDATE_WAREHOUSE:
                WarehouseDBApi.update_warehouse();
                break;
            default:
                // To handle land
                int landIndex = state - UPDATE_LAND;
                LandDBApi.updateLand(landIndex);
                break;
        }
    }
}
