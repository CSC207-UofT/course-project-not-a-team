package com.farmgame.frontEnd.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.farmgame.R;
import com.farmgame.usecase.StoreAble;

import java.util.ArrayList;

/**
 * the adapter for the grid view in warehouse fragment
 */
public class WarehouseAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<ArrayList<StoreAble>> list;


    /**
     *
     * @param context the context of the adapter
     * @param lst list of store able objects in the inventory
     */
    public WarehouseAdapter(Context context, ArrayList<ArrayList<StoreAble>> lst){
        layoutInflater = LayoutInflater.from(context);
        list = lst;
    }

    /**
     *
     * @return the number of different store able objects in one inventory
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     *
     * @param position position of the object in the grid
     * @return a list of all that type of objects in the inventory
     */
    @Override
    public ArrayList<StoreAble> getItem(int position) {
        return list.get(position);
    }

    /**
     *
     * @param position the position of the item in the grid
     * @return the position
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * set info about the store able object in the grid of the inventory
     * @param position the position of the item in the grid
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.warehouse_item, null);
        ((TextView) convertView.findViewById(R.id.name)).setText("name");
        ((TextView) convertView.findViewById(R.id.item)).setText(getItem(position).get(0).getName());
        ((TextView) convertView.findViewById(R.id.quantity)).setText("quantity");
        ((TextView) convertView.findViewById(
                R.id.quantityValue)).setText(String.valueOf(getItem(position).size()));
        return convertView;
    }
}
