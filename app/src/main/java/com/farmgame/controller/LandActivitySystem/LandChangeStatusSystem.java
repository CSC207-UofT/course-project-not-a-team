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

    public String unlockLand() {
        ChangeStatusPresenter changeStatusPresenter = new ChangeStatusPresenter();
        Integer max_unlock = LandDBApi.getLandMaxTable().get(playerManager.getPlayer().getLevel());
        if (landManager.getLand().getLockStatus() == 0
                && max_unlock !=null
                && landManager.getLand().getIndex() <= max_unlock) {
            landManager.getLand().setLockStatus(1);
            // inform player that he/she has unlocked the land successfully

        }
        return changeStatusPresenter.lockSuccess();
    }

    public String buyLand() {
        ChangeStatusPresenter changeStatusPresenter = new ChangeStatusPresenter();
        String message = "";
        if (landManager.getLand().getLockStatus() == 1) {
            if (playerManager.subtractMoney(landManager.getLand().getPrice())) {
                landManager.getLand().setLockStatus(2);
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
}
