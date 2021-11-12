package com.farmgame.controller.LandActivitySystem;

import com.farmgame.controller.System;
import com.farmgame.gateway.LandDBApi;
import com.farmgame.presenter.LandPresenter.ChangeStatusPresenter;
import com.farmgame.usecase.LandManager;
import com.farmgame.usecase.PlayerManager;

public class LandChangeStatusSystem extends System {
    private final LandManager landManager;
    private final PlayerManager playerManager;

    public LandChangeStatusSystem(LandManager landManager, PlayerManager playerManager) {
        this.landManager = landManager;
        this.playerManager = playerManager;
    }

    public void unlockLand() {
        ChangeStatusPresenter changeStatusPresenter = new ChangeStatusPresenter();
        Integer max_unlock = LandDBApi.getLandMaxTable().get(playerManager.getPlayer().getLevel());
        if (landManager.getLand().getLockStatus() == 0
                && max_unlock !=null
                && landManager.getLand().getIndex() <= max_unlock) {
            landManager.getLand().setLockStatus(1);
            // inform player that he/she has unlocked the land successfully
            changeStatusPresenter.lockSuccess();

        }
        else {
            // return error: invalid initial lock status. This should not happen during game
        }
    }

    public void buyLand() {
        ChangeStatusPresenter changeStatusPresenter = new ChangeStatusPresenter();
        if (landManager.getLand().getLockStatus() == 1) {
            if (playerManager.subtractMoney(landManager.getLand().getPrice())) {
                landManager.getLand().setLockStatus(2);
                // inform player that he/she has bought the land successfully
                changeStatusPresenter.buySuccess();
            }
            else {
                // inform player that he/she doesn't have enough money to buy
                changeStatusPresenter.not_enough_money();
                changeStatusPresenter.remaining_money(playerManager.getPlayer().getMoney());

            }
        }
        else {
            // return error" invalid initial lock status. This should not happen during game
        }
    }
}
