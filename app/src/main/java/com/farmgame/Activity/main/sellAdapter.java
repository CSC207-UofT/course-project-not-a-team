package com.farmgame.Activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.farmgame.R;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Plants;
import com.farmgame.usecase.StoreAble;

import java.util.ArrayList;
import java.util.HashMap;


public class sellAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    ArrayList<ArrayList<Plants>> list = new ArrayList<>();


    public sellAdapter(Context context, HashMap<Integer, ArrayList<Plants>> map){
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.warehouse_item, null);
        ((TextView) convertView.findViewById(R.id.name)).setText("name");
        ((TextView) convertView.findViewById(R.id.item)).setText(getItem(position).get(0).getName());
        ((TextView) convertView.findViewById(R.id.priceName)).setText("price");
        ((TextView) convertView.findViewById(
                R.id.price)).setText(String.valueOf(getItem(position).get(0).getPrice()));
        return convertView;
    }
}