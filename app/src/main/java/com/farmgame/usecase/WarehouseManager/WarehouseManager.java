package com.farmgame.usecase.WarehouseManager;

import com.farmgame.usecase.StoreAble;
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
            switch (object.getType()){
                case TYPE_PLANT:
                    add(this.warehouse.getPlantInventory(), object);
                    break;
                case TYPE_SEED:
                    add(this.warehouse.getSeedInventory(), object);
                    break;
                default:
                    add(this.warehouse.getItemInventory(), object);
                    break;
            }
            setChanged();
            notifyObservers(UPDATE_WAREHOUSE);
        }

    }

    /**
     * helper function for addProduct
     *
     * @param map the inventory map
     * @param object the object to add
     * @param <T> the type of StoreAble object
     */
    @SuppressWarnings("unchecked")
    private <T extends StoreAble> void add(HashMap<Integer, ArrayList<T>> map, StoreAble object){
        int id = object.getId();
        if (map.containsKey(id)){
            Objects.requireNonNull(map.get(id)).add((T) object);
        } else {
            ArrayList<T> list = new ArrayList<>();
            list.add((T) object);
            map.put(id, list);
        }
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

    /**
     * helper function for removeProduct
     *
     * @param map inventory map
     * @param object the object to remove
     * @param <T> the type of StoreAble object
     */
    private <T extends StoreAble> void remove(
            HashMap<Integer, ArrayList<T>> map, StoreAble object
    ){
        int id = object.getId();
        ArrayList<T> list = map.get(id);
        if (Objects.requireNonNull(list).size() == 1){
            map.remove(id);
        } else {
            list.remove(list.get(0));
        }
    }
}
