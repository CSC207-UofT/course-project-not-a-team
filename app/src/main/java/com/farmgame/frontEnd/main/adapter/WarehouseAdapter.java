package com.farmgame.frontEnd.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.farmgame.R;
import com.farmgame.entity.Seeds;
import com.farmgame.usecase.StoreAble;

import java.util.ArrayList;

public class WarehouseAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<ArrayList<StoreAble>> list;


    public WarehouseAdapter(Context context, ArrayList<ArrayList<StoreAble>> lst){
        layoutInflater = LayoutInflater.from(context);
        list = lst;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ArrayList<StoreAble> getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getSeedId(int position){
        return ((Seeds) getItem(position).get(0)).getId();
    }

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
