package com.farmgame.viewModel.LandActivitySystem;

import static com.farmgame.constants.Constants.*;
import static com.farmgame.constants.Message.*;

import com.farmgame.constants.Message;
import com.farmgame.viewModel.System;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;

import java.util.ArrayList;
import java.util.Observable;

public class LandChangeStatusSystem extends System {
    private final LandManager landManager;
    private final PlayerManager playerManager;

    /**
     * Constructor for LandChangeStatusSystem
     *
     * @param landManager the land(manager) that LandChangeStatusSystem interacts with
     * @param playerManager the player(manager) that LandChangeStatusSystem interacts with
     */
    public LandChangeStatusSystem(LandManager landManager, PlayerManager playerManager) {
        this.landManager = landManager;
        this.playerManager = playerManager;

        this.playerManager.addObserver(this);
        this.landManager.addObserver(this);
    }

    /**
     * If the land is locked, then unlock this land
     */
    public void unlockLand() {
        ArrayList<Integer> indexList = landManager.getAllIndices();
        for (int index : indexList){
            if (playerManager.getPlayer().getLevel() >= landManager.getLand(index).getUnLockLevel()
                    && landManager.getLand(index).getLockStatus() == LOCK_STATUS_LOCKED) {
                landManager.unLock(index);
                // inform player that he/she has unlocked the land successfully
            }
        }
//        ChangeStatusPresenter changeStatusPresenter = new ChangeStatusPresenter();
//        return changeStatusPresenter.lockSuccess();
    }

    /**
     * Buy the land at the given index, if the land is unlocked and player has enough money
     *
     * @param index the index of the land that player want to buy
     * @return a message indicating the result of buying land
     */
    public String buyLand(int index) {
        String message = "";
        if (landManager.getLand(index).getLockStatus() == LOCK_STATUS_NOT_BOUGHT) {
            if (playerManager.subtractMoney(landManager.getLand(index).getPrice())) {
                landManager.buy(index);
                // inform player that he/she has bought the land successfully
                message += BUY_SUCCESS + "\n";
            }
            else {
                // inform player that he/she doesn't have enough money to buy
                message += Message.NO_ENOUGH_MONEY + "\n";
            }
        }
        return message;
    }

    /**
     * update this Observer
     *
     * @param o Observable
     * @param arg argument
     */
    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
        if ((int) arg == AUTO_UNLOCK){
            unlockLand();
        }
    }
}
