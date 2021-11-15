package com.farmgame.usecase.WarehouseManager;

import com.farmgame.entity.Seeds;
import com.farmgame.usecase.StoreAble;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
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
                if(tempPlantsList.containsKey(((Plants) object).getId())){
                    ArrayList<Plants> addPlantsArrayList =  tempPlantsList.get(((Plants) object).getId());
                    assert addPlantsArrayList != null;
                    addPlantsArrayList.add((Plants) object);
                    tempPlantsList.put(((Plants) object).getId(), addPlantsArrayList);
                }else{
                    ArrayList<Plants> addPlantsArrayListCP = new ArrayList<>();
                    addPlantsArrayListCP.add((Plants) object);
                    tempPlantsList.put(((Plants) object).getId(), addPlantsArrayListCP);
                }
                this.warehouse.setPlantInventory(tempPlantsList);
            }else if (object instanceof Seeds){
                HashMap<Integer, ArrayList<Seeds>>tempSeedList = this.warehouse.getSeedInventory();
                if(tempSeedList.containsKey(((Seeds) object).getId())){
                    ArrayList<Seeds> addSeedsArrayList =  tempSeedList.get(((Seeds) object).getId());
                    assert addSeedsArrayList != null;
                    addSeedsArrayList.add((Seeds) object);
                    tempSeedList.put(((Seeds) object).getId(), addSeedsArrayList);
                }else{
                    ArrayList<Seeds> addSeedsArrayListCP =  new ArrayList<>();
                    addSeedsArrayListCP.add((Seeds) object);
                    tempSeedList.put(((Seeds) object).getId(), addSeedsArrayListCP);
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
        switch (object.getType()){
            case TYPE_PLANT:
                remove(this.warehouse.getPlantInventory(), object);
                break;
            case TYPE_SEED:
                remove(this.warehouse.getSeedInventory(), object);
                break;
            default:
                remove(this.warehouse.getItemInventory(), object);
                break;
        }
        setChanged();
        notifyObservers(UPDATE_WAREHOUSE);
    }

    private <T extends StoreAble> void remove(
            HashMap<Integer, ArrayList<T>> map, StoreAble object
    ){
        int id = object.getId();
        ArrayList<T> list = map.get(id);
        if (Objects.requireNonNull(list).size() == 1){
            map.remove(id);
        } else {
            list.remove(object);
        }
    }
}
