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


public class StoreGridViewAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    ArrayList<StoreAble> list;


    public StoreGridViewAdapter(Context context, ArrayList<StoreAble> lst){
        layoutInflater = LayoutInflater.from(context);
        list = lst;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public StoreAble getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.store_item, null);
        ((TextView) convertView.findViewById(R.id.name)).setText("name");
        ((TextView) convertView.findViewById(R.id.item)).setText(getItem(position).getName());
        ((TextView) convertView.findViewById(R.id.priceName)).setText("price");
        ((TextView) convertView.findViewById(
                R.id.price)).setText(String.valueOf(getItem(position).getPrice()));
        return convertView;
    }
}
