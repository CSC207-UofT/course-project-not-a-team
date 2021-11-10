package com.farmgame.usecase.WarehouseManager;

import com.farmgame.entity.Item.Fertilizer;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WarehouseManager<T> implements StoreAble, WarehouseMunipulate{
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
     * Add item to Warehouse's Item Inventory if capable
     * @param item an item that needs to be added to the warehouse
     */


    /**
     * Remove item from Warehouse's Item Inventory
     * @param item an item that needs to be removed from the warehouse
     */


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

    /**
     * Add plant to Warehouse's Plant Inventory
     * @param plant a plant that needs to be added to the warehouse
     */


    /**
     * Remove plant from Warehouse's plant Inventory
     * @param plant a plant that needs to be removed from the warehouse
     */



    public String getName() {
        if (object instanceof Item) {
            return ((Item) object).getName();

        }else if (object instanceof Plants){
            return ((Plants) object).getPlantName();
        }
        return null;
    }

    @Override
    public void addProduct(StoreAble object) {
        if (object instanceof Item) {
            HashMap<Integer, ArrayList<Item>> tempItemList = this.warehouse.getItemInventory();
            if(tempItemList.containsKey(object.getId())){
                tempItemList.put(object.getId(), tempItemList.get(object.getId())+1);
            }else{
                tempItemList.put(object.getId(), 1);
            }
            this.warehouse.setItemInventory(tempItemList);
        }else if (object instanceof Plants){
            HashMap<Integer, ArrayList<Plants>>tempPlantsList = this.warehouse.getPlantInventory();
            if(tempPlantsList.containsKey(object.getId())){
                tempPlantsList.put(object.getId(), tempPlantsList.get(object.getId())+1);

            }else{
                tempPlantsList.put(object.getId(), 1);
            }
            this.warehouse.setPlantInventory(tempPlantsList);
        }
    }

    @Override
    public void removeProduct(StoreAble object) {
        if (object instanceof Item) {
            HashMap<Integer, ArrayList<Item>>tempItemList = this.warehouse.getItemInventory();
            if(tempItemList.containsKey(object.getId())){
                if(tempItemList.get(object.getId())>0){
                    tempItemList.put(object.getId(), tempItemList.get(object.getId())-1);
                }else{
                    tempItemList.remove(object.getId());
                }
            }
            this.warehouse.setItemInventory(tempItemList);
        }else if (object instanceof Plants){
            HashMap<Integer, ArrayList<Plants>>tempPlantsList = this.warehouse.getPlantInventory();
            if(tempPlantsList.containsKey(object.getId())){
                if(tempPlantsList.get(object.getId())>0){
                    tempPlantsList.put(object.getId(), tempPlantsList.get(object.getId())-1);
                }else{
                    tempPlantsList.remove(object.getId());
                }
            }
            this.warehouse.setPlantInventory(tempPlantsList);
        }
    }

    @Override
    public StoreAble getProduct(String s) {
        HashMap<Integer, ArrayList<Item>>tempItemList = this.warehouse.getItemInventory();
        HashMap<Integer, ArrayList<Plants>>tempPlantsList = this.warehouse.getPlantInventory();
        for (ArrayList<Item> tempIterateItemList:tempItemList.values()) {
            if(tempIterateItemList.get(0).getName().equals(s)){
                if(tempItemList.size()>1){
                    Item resultItem = tempIterateItemList.get(0);
                    tempItemList.put(object.getId(), tempItemList.get(object.getId())-1);
                    return resultItem;
                }else{
                    Item resultItem = tempIterateItemList.get(0);
                    tempItemList.remove(object.getId());
                    return resultItem;
                }

            }
        }
        for (ArrayList<Plants> plantIteratePlantsList:tempPlantsList.values()) {
            if(plantIteratePlantsList.get(0).getName().equals(s)){
                if(tempItemList.size()>1){
                    Plants resultPlants = plantIteratePlantsList.get(0);
                    tempItemList.put(object.getId(), tempItemList.get(object.getId())-1);
                    return resultPlants;
                }else{
                    Plants resultPlants = plantIteratePlantsList.get(0);
                    tempItemList.remove(object.getId());
                    return resultPlants;
                }

            }
        }
    }


}
