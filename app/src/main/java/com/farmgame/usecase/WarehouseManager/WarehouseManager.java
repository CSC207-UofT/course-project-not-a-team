package com.farmgame.usecase.WarehouseManager;

import com.farmgame.constants.Constants;
import com.farmgame.entity.Seeds;
import com.farmgame.usecase.StoreAble;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import static com.farmgame.constants.Constants.*;


public class WarehouseManager extends Observable implements WarehouseManipulate{
    private final Warehouse warehouse;
    /**
     * Initialize warehouse
     * @param warehouse an warehouse instance
     */
    public WarehouseManager(Warehouse warehouse) {
        this.warehouse = warehouse;

    }

    /**
     * return the warehouse
     * @return warehouse
     */
    public Warehouse getWarehouse(){
        return this.warehouse;
    }


    /**
     * Add product to warehouse hashmap according to its type
     * @param object given an StoreAble object
     */
    @Override
    public void addProduct(StoreAble object) {
        if (warehouse.checkCapacity()){
            if (object instanceof Item) {
                HashMap<Integer, ArrayList<Item>> tempItemList = this.warehouse.getItemInventory();
                if(tempItemList.containsKey(((Item) object).getId())){
                    ArrayList<Item> addItemArrayList =  tempItemList.get(((Item) object).getId());
                    assert addItemArrayList != null;
                    addItemArrayList.add((Item) object);
                    tempItemList.put(((Item) object).getId(),addItemArrayList);
                }else{
                    ArrayList<Item> addItemArrayListCP = new ArrayList<>();
                    addItemArrayListCP.add((Item) object);
                    tempItemList.put(((Item) object).getId(),addItemArrayListCP);
                }
                this.warehouse.setItemInventory(tempItemList);
            }else if (object instanceof Plants){
                HashMap<Integer, ArrayList<Plants>>tempPlantsList = this.warehouse.getPlantInventory();
                if(tempPlantsList.containsKey(((Plants) object).getPlantID())){
                    ArrayList<Plants> addPlantsArrayList =  tempPlantsList.get(((Plants) object).getPlantID());
                    assert addPlantsArrayList != null;
                    addPlantsArrayList.add((Plants) object);
                    tempPlantsList.put(((Plants) object).getPlantID(), addPlantsArrayList);
                }else{
                    ArrayList<Plants> addPlantsArrayListCP = new ArrayList<>();
                    addPlantsArrayListCP.add((Plants) object);
                    tempPlantsList.put(((Plants) object).getPlantID(), addPlantsArrayListCP);
                }
                this.warehouse.setPlantInventory(tempPlantsList);
            }else if (object instanceof Seeds){
                HashMap<Integer, ArrayList<Seeds>>tempSeedList = this.warehouse.getSeedInventory();
                if(tempSeedList.containsKey(((Seeds) object).getSeedId())){
                    ArrayList<Seeds> addSeedsArrayList =  tempSeedList.get(((Seeds) object).getSeedId());
                    assert addSeedsArrayList != null;
                    addSeedsArrayList.add((Seeds) object);
                    tempSeedList.put(((Seeds) object).getSeedId(), addSeedsArrayList);
                }else{
                    ArrayList<Seeds> addSeedsArrayListCP =  new ArrayList<>();
                    addSeedsArrayListCP.add((Seeds) object);
                    tempSeedList.put(((Seeds) object).getSeedId(), addSeedsArrayListCP);
                }
                this.warehouse.setSeedInventory(tempSeedList);
            }
        }
        setChanged();
        notifyObservers(UPDATE_WAREHOUSE);

    }

    /**
     * Remove product from warehouse hashmap according to its type
     * @param object object given an StoreAble object
     */

    @Override
    public void removeProduct(StoreAble object) {
        if (object instanceof Item) {
            HashMap<Integer, ArrayList<Item>>tempItemList = this.warehouse.getItemInventory();
            if(tempItemList.containsKey(((Item) object).getId())){
                ArrayList<Item> tempRemove = tempItemList.get(((Item) object).getId());
                if (tempRemove != null){
                    if(tempRemove.size()>0){
                        tempRemove.remove(object);
                        tempItemList.put(((Item) object).getId(),tempRemove);
                    }else{
                        tempItemList.put(((Item) object).getId(), new ArrayList<>());
                    }
                }
            }
            this.warehouse.setItemInventory(tempItemList);
        }else if (object instanceof Plants){
            HashMap<Integer, ArrayList<Plants>>tempPlantsList = this.warehouse.getPlantInventory();
            if(tempPlantsList.containsKey(((Plants) object).getPlantID())){
                ArrayList<Plants> tempRemove = tempPlantsList.get(((Plants) object).getPlantID());
                if (tempRemove != null){
                    if(tempRemove.size()>0){
                        tempRemove.remove(object);
                        tempPlantsList.put(((Plants) object).getPlantID(),tempRemove);
                    }else{
                        tempPlantsList.put(((Plants) object).getPlantID(), new ArrayList<>());
                    }
                }
            }
            this.warehouse.setPlantInventory(tempPlantsList);
        }else if (object instanceof Seeds){
            HashMap<Integer, ArrayList<Seeds>>tempSeedList = this.warehouse.getSeedInventory();
            if(tempSeedList.containsKey(((Seeds) object).getSeedId())){
                ArrayList<Seeds> tempRemove = tempSeedList.get(((Seeds) object).getSeedId());
                if (tempRemove != null){
                    if(tempRemove.size()>0){
                        tempRemove.remove(object);
                        tempSeedList.put(((Seeds) object).getSeedId(),tempRemove);
                    }else{
                        tempSeedList.put(((Seeds) object).getSeedId(), new ArrayList<>());
                    }
                }
            }
            this.warehouse.setSeedInventory(tempSeedList);
        }
        setChanged();
        notifyObservers(UPDATE_WAREHOUSE);
    }


}
