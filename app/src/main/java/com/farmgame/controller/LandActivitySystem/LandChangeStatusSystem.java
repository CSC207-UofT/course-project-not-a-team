package com.farmgame.controller.LandActivitySystem;

import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;

public class LandChangeStatusSystem {
    private final LandManager landManager;
    private final PlayerManager playerManager;

    public LandChangeStatusSystem(LandManager landManager, PlayerManager playerManager) {
        this.landManager = landManager;
        this.playerManager = playerManager;
    }

    public void unlockLand() {
        if (landManager.getLand().getLockStatus() == 0) {
            landManager.getLand().setLockStatus(1);
            // inform player that he/she has unlocked the land successfully
        }
        else {
            // return error: invalid initial lock status. This should happen during game
        }
    }

    public void buyLand() {
        if (landManager.getLand().getLockStatus() == 1) {
            if (playerManager.subtractMoney(landManager.getLand().getPrice())) {
                landManager.getLand().setLockStatus(2);
                // inform player that he/she has bought the land successfully
            }
            else {
                // inform player that he/she doesn't have enough money to buy
            }
        }
        else {
            // return error" invalid initial lock status. This should happen during game
        }
    }
}
