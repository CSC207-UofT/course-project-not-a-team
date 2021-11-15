package com.farmgame.controller.LandActivitySystem;

import static com.farmgame.constants.Constants.*;

import com.farmgame.controller.System;
import com.farmgame.gateway.LandDBApi;
import com.farmgame.presenter.LandPresenter.ChangeStatusPresenter;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;

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
//        ChangeStatusPresenter changeStatusPresenter = new ChangeStatusPresenter();
        if (playerManager.getPlayer().getLevel() >= landManager.getLand().getUnLockLevel()
                && landManager.getLand().getLockStatus() == LOCK_STATUS_LOCKED) {
            landManager.unLock();
            // inform player that he/she has unlocked the land successfully

        }
//        return changeStatusPresenter.lockSuccess();
    }

    public String buyLand() {
        ChangeStatusPresenter changeStatusPresenter = new ChangeStatusPresenter();
        String message = "";
        if (landManager.getLand().getLockStatus() == LOCK_STATUS_NOT_BOUGHT) {
            if (playerManager.subtractMoney(landManager.getLand().getPrice())) {
                landManager.buy();
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
