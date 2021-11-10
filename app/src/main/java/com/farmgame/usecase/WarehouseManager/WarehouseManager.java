package com.farmgame.usecase.WarehouseManager;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WarehouseManager implements WarehouseMunipulate{
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



//    public Item getItem(String s) {
//        ArrayList<Item> lst = this.warehouse.getItemInventory();
//        for (Item item : lst) {
//            if (item.getName().equals(s)) {
//                lst.remove(item);
//                this.warehouse.setItemInventory(lst);
//                return item;
//            }
//        }
//        return null;
//    }


    @Override
    public void addProduct(StoreAble object) {
        if (object instanceof Item) {
            HashMap<Integer, ArrayList<Item>> tempItemList = this.warehouse.getItemInventory();
            if(tempItemList.containsKey(((Item) object).getId())){
                tempItemList.put(((Item) object).getId(), tempItemList.get(((Plants) object).getPlantID()));
            }
            this.warehouse.setItemInventory(tempItemList);
        }else if (object instanceof Plants){
            HashMap<Integer, ArrayList<Plants>>tempPlantsList = this.warehouse.getPlantInventory();
            if(tempPlantsList.containsKey(((Plants) object).getPlantID())){
                tempPlantsList.put(((Plants) object).getPlantID(), tempPlantsList.get(((Plants) object).getPlantID()));

            }
            this.warehouse.setPlantInventory(tempPlantsList);
        }
    }

    @Override
    public void removeProduct(StoreAble object) {
        if (object instanceof Item) {
            HashMap<Integer, ArrayList<Item>>tempItemList = this.warehouse.getItemInventory();
            if(tempItemList.containsKey(((Plants) object).getPlantID())){
                ArrayList<Item> tempRemove = tempItemList.get(((Item) object).getId());
                assert tempRemove != null;
                if(tempRemove.size()>0){
                    tempItemList.put(((Item) object).getId(), tempItemList.remove(object));
                }else{
                    tempItemList.put(((Item) object).getId(), new ArrayList<Item>());
                }
            }


            this.warehouse.setItemInventory(tempItemList);
        }else if (object instanceof Plants){
            HashMap<Integer, ArrayList<Plants>>tempPlantsList = this.warehouse.getPlantInventory();
            if(tempPlantsList.containsKey(((Plants) object).getPlantID())){
                ArrayList<Plants> tempRemove = tempPlantsList.get(((Plants) object).getPlantID());
                assert tempRemove != null;
                if(tempRemove.size()>0){
                    tempPlantsList.put(((Plants) object).getPlantID(),tempPlantsList.remove(object));
                }else{
                    tempPlantsList.put(((Plants) object).getPlantID(), new ArrayList<Plants>());
                }
            }
            this.warehouse.setPlantInventory(tempPlantsList);
        }
    }
//
//    @Override
//    public StoreAble getProduct(String s) {
//        HashMap<Integer, ArrayList<Item>>tempItemList = this.warehouse.getItemInventory();
//        HashMap<Integer, ArrayList<Plants>>tempPlantsList = this.warehouse.getPlantInventory();
//        for (ArrayList<Item> tempIterateItemList:tempItemList.values()) {
//            if(tempIterateItemList.get(0).getName().equals(s)){
//                if(tempItemList.size()>1){
//                    Item resultItem = tempIterateItemList.get(0);
//                    tempItemList.put(tempIterateItemList.get(0).getId(), tempIterateItemList.remove(tempIterateItemList.get(0)));
//                    return (StoreAble) resultItem;
//                }else{
//                    Item resultItem = tempIterateItemList.get(0);
//                    tempItemList.remove(object.getId());
//                    return (StoreAble) resultItem;
//                }
//
//            }
//        }
//        for (ArrayList<Plants> plantIteratePlantsList:tempPlantsList.values()) {
//            if(plantIteratePlantsList.get(0).getName().equals(s)){
//                if(tempPlantsList.size()>1){
//                    Plants resultPlants = plantIteratePlantsList.get(0);
//                    plantIteratePlantsList.remove(resultPlants);
//                    tempPlantsList.put(plantIteratePlantsList.get(0).getPlantID(), plantIteratePlantsList);
//                    return (StoreAble) resultPlants;
//                }else{
//                    Plants resultPlants = plantIteratePlantsList.get(0);
//                    tempPlantsList.put(plantIteratePlantsList.get(0).getPlantID(), new ArrayList<Plants>());
//                    return (StoreAble) resultPlants;
//                }
//
//            }
//        }
//    }


}
