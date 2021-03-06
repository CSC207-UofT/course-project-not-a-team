package com.farmgame.viewModel;

import static com.farmgame.constants.Constants.*;

import com.farmgame.gateway.LandDBApi;
import com.farmgame.gateway.PlayerDBApi;
import com.farmgame.gateway.WarehouseDBApi;

import java.util.Observable;
import java.util.Observer;

/***
 * the abstract class is the parent class of all systems
 */
public abstract class System implements Observer {
    /***
     * update database and UI when the system is notified by the observable
     * @param o the observable
     * @param arg the message
     */
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
            case AUTO_UNLOCK:
                break;
            default:
                // To handle land
                int landIndex = state - UPDATE_LAND;
                LandDBApi.updateLand(landIndex);
                break;
        }
    }
}
