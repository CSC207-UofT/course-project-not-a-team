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
 * the adapter for the grid view in the buying store fragment
 */
public class StoreGridViewAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    ArrayList<StoreAble> list;


    /**
     *
     * @param context the context of the adapter
     * @param lst list of store able items that to can be purchased at the store
     */
    public StoreGridViewAdapter(Context context, ArrayList<StoreAble> lst){
        layoutInflater = LayoutInflater.from(context);
        list = lst;
    }

    /**
     *
     * @return the number of different items in the store
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     *
     * @param position the position of the item in the grid
     * @return the item at that position
     */
    @Override
    public StoreAble getItem(int position) {
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
     * set info about the store able object in the grid of buying store
     * @param position the position of the object in the grid
     */
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
