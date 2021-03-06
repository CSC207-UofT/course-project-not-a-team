package com.farmgame.gateway;

import static com.farmgame.constants.Constants.*;

import android.database.Cursor;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Item.ItemFactory;
import com.farmgame.entity.Item.WateringCan;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;
import com.farmgame.entity.Store;

import java.util.ArrayList;
import java.util.Objects;

/***
 * the database gateway to store
 */
public class StoreDBApi extends DataBaseAPI {


    /***
     *
     * @return the store instance
     */
    public static Store getStore(){
        return new Store(getPlantList(), getSeedList(), getItemList());
    }

    /***
     *
     * @return list of plant
     */
    public static ArrayList<Plants> getPlantList(){

        ArrayList<Plants> list = new ArrayList<>();

        Cursor cursor = db.query(
                PLANT,
                new String[]{"*"}, null, null,
                null, null, null);

        while (cursor.moveToNext()){

            String name = cursor.getString(cursor.getColumnIndex(PLANT_MATURE_NAME));
            int selling = cursor.getInt(cursor.getColumnIndex(PLANT_SELL_PRICE));
            int id = cursor.getInt(cursor.getColumnIndex(PLANT_ID));

            list.add(new Plants(name, selling, id));
        }

        cursor.close();

        return list;
    }

    /***
     *
     * @return list of seeds that can be bought under the current level
     */
    public static ArrayList<Seeds> getSeedList(){

        ArrayList<Seeds> list = new ArrayList<>();

        Cursor cursor = db.query(
                PLANT,
                new String[]{"*"},
                PLANT_UNLOCK_LEVEL + " <= ?", new String[]{String.valueOf(
                        Objects.requireNonNull(PlayerDBApi.getPlayer()).getLevel())},
                null, null, null);

        while (cursor.moveToNext()){

            String name = cursor.getString(cursor.getColumnIndex(PLANT_SEED_NAME));
            int time = cursor.getInt(cursor.getColumnIndex(PLANT_TIME));
            int buying = cursor.getInt(cursor.getColumnIndex(PLANT_BUY_PRICE));
            int exp = cursor.getInt(cursor.getColumnIndex(PLANT_EXP));
            int id = cursor.getInt(cursor.getColumnIndex(PLANT_ID));

            list.add(new Seeds(name, time, buying, exp, id));
        }

        cursor.close();

        return list;

    }

    /***
     *
     * @return list of item
     */
    public static ArrayList<Item> getItemList(){

        ArrayList<Item> list = new ArrayList<>();

        Cursor cursor = db.query(
                ITEM,
                new String[]{ITEM_TYPE, ITEM_ID, ITEM_PRICE}, null, null,
                null, null, null);


        ItemFactory itemFactory = new ItemFactory();
        while (cursor.moveToNext()){
            String type = cursor.getString(cursor.getColumnIndex(ITEM_TYPE));

            int price = cursor.getInt(cursor.getColumnIndex(ITEM_PRICE));
            int id = cursor.getInt(cursor.getColumnIndex(ITEM_ID));
            list.add(itemFactory.createItem(type, price, id));
        }

        cursor.close();

        return list;
    }

}
