package com.farmgame.viewModel;

import android.database.sqlite.SQLiteDatabase;

import androidx.lifecycle.ViewModel;

import com.farmgame.gateway.InitData;

/***
 * the android viewModel for the login activity
 */
public class RegisterViewModel extends ViewModel {

    /***
     *
     * @param database our database
     */
    public RegisterViewModel(SQLiteDatabase database){
        InitData.setDb(database);
    }

    /***
     *
     * @return whether the player has been created
     */
    public boolean hasPlayer(){
        return InitData.hasPlayer();
    }
}
