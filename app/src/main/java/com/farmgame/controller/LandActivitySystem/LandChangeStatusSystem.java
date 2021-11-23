package com.farmgame.controller.LandActivitySystem;

import static com.farmgame.constants.Constants.*;

import com.farmgame.controller.System;
import com.farmgame.gateway.LandDBApi;
import com.farmgame.presenter.LandPresenter.ChangeStatusPresenter;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;

import java.util.ArrayList;
import java.util.Observable;

public class LandChangeStatusSystem extends System {
    private final LandManager landManager;
    private final PlayerManager playerManager;

    public LandChangeStatusSystem(LandManager landManager, PlayerManager playerManager) {
        this.landManager = landManager;
        this.playerManager = playerManager;

        this.playerManager.addObserver(this);
        this.landManager.addObserver(this);
    }

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

    public String buyLand(int index) {
        ChangeStatusPresenter changeStatusPresenter = new ChangeStatusPresenter();
        String message = "";
        if (landManager.getLand(index).getLockStatus() == LOCK_STATUS_NOT_BOUGHT) {
            if (playerManager.subtractMoney(landManager.getLand(index).getPrice())) {
                landManager.buy(index);
                // inform player that he/she has bought the land successfully
                message += changeStatusPresenter.buySuccess() + "\n";
            }
            else {
                // inform player that he/she doesn't have enough money to buy
                message += changeStatusPresenter.not_enough_money() + "\n";
                message += changeStatusPresenter.remaining_money(
                        playerManager.getPlayer().getMoney()) + "\n";

            }
        }
        return message;
    }

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
        if ((int) arg == AUTO_UNLOCK){
            unlockLand();
        }
    }
}
