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

/**
 * The adapter of the selling store grid view
 */
public class SellAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    ArrayList<ArrayList<Plants>> list = new ArrayList<>();


    /**
     *
     * @param context the context of the adapter
     * @param map a map where key is the id of the plant and value is an arraylist of plants
     *            that are held
     */
    public SellAdapter(Context context, HashMap<Integer, ArrayList<Plants>> map){
        layoutInflater = LayoutInflater.from(context);
        for (ArrayList<Plants> list: map.values()){
            this.list.add(new ArrayList<>(list));
        }
    }

    /**
     *
     * @return the number of different plants held
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
    public ArrayList<Plants> getItem(int position) {
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
     * set info about the plants held in the grid of sell store
     * @param position the position of the item in the grid
     */
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