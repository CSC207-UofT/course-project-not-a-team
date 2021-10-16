package com.farmgame.usecase;

import com.farmgame.entity.LandEntity;

public class LandManager {

    private final LandEntity[] landArray;

    public LandManager(LandEntity[] landArray){
        this.landArray = landArray;
    }

    /**
     *
     * @param index the index
     * @precondition index < landArray.length.
     * response to clicking an item
     */
    public void onClick(int index){
        switch (this.landArray[index].getLockStatus()){
            case LandEntity.LOCK_STATUS_LOCKED:
                break;
            case LandEntity.LOCK_STATUS_NOT_BOUGHT:
                break;
            case LandEntity.LOCK_STATUS_BOUGHT:
                break;
        }
    }



}
