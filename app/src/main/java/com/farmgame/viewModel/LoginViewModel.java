package com.farmgame.viewModel;

import android.database.sqlite.SQLiteDatabase;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.farmgame.entity.Player;
import com.farmgame.gateway.PlantDBApi;
import com.farmgame.gateway.PlayerDBApi;
import com.farmgame.gateway.WarehouseDBApi;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<SQLiteDatabase> dbMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<Player>  playerMutableLiveData = new MutableLiveData<>();

    public void initViewModel(SQLiteDatabase db){
        dbMutableLiveData.setValue(db);
        initUpdaters();
        playerMutableLiveData.setValue(PlayerDBApi.getPlayer());
    }

    public SQLiteDatabase getDB(){
        return dbMutableLiveData.getValue();
    }

    public Player getPlayer(){
        return playerMutableLiveData.getValue();
    }

    public void setPlayer(Player player){
        playerMutableLiveData.setValue(player);
    }

    private void initUpdaters(){
        PlayerDBApi.setDb(getDB());
        WarehouseDBApi.setDb(getDB());
        PlantDBApi.setDb(getDB());
    }

}
