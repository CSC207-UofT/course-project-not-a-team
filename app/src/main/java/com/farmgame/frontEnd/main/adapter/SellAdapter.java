package com.farmgame.frontEnd.main.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.farmgame.R;
import com.farmgame.entity.Plants;

import java.util.ArrayList;
import java.util.HashMap;


public class SellAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    ArrayList<ArrayList<Plants>> list = new ArrayList<>();


    public SellAdapter(Context context, HashMap<Integer, ArrayList<Plants>> map){
        layoutInflater = LayoutInflater.from(context);
        for (ArrayList<Plants> list: map.values()){
            this.list.add(new ArrayList<>(list));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ArrayList<Plants> getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.sell_item, null);
        ((TextView) convertView.findViewById(R.id.item)).setText(getItem(position).get(0).getName());
        ((TextView) convertView.findViewById(R.id.quantityValue)).setText(
                String.valueOf(getItem(position).size()));
        ((TextView) convertView.findViewById(
                R.id.priceValue)).setText(String.valueOf(getItem(position).get(0).getPrice()));
        return convertView;
    }
}