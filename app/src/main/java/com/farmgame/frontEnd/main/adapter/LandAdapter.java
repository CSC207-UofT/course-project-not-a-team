package com.farmgame.frontEnd.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.farmgame.R;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Seeds;

import java.util.ArrayList;
import static com.farmgame.constants.Constants.*;

/**
 * The adapter for the grid view showing the lands in land fragment
 */
public class LandAdapter extends BaseAdapter {

    ArrayList<LandEntity> lst;
    LayoutInflater layoutInflater;

    /**
     * Constructor of the adapter
     * @param context the context of the adapter
     * @param list the list of lands to be put in the grid view
     */
    public LandAdapter(Context context, ArrayList<LandEntity> list){
        layoutInflater = LayoutInflater.from(context);
        lst = list;
    }

    /**
     *
     * @return number of lands in the grid view
     */
    @Override
    public int getCount() {
        return lst.size();
    }

    /**
     *
     * @param position the position of the land
     * @return the land positioned at the position
     */
    @Override
    public LandEntity getItem(int position) {
        return lst.get(position);
    }

    /**
     *
     * @param position the position of the land
     * @return the position
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * @param position the position of the land
     * set info about the land to be seen in the grid of the land
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.land_item, null);
        Seeds plant = getItem(position).getPlant();
        String lockStatus;
        switch (getItem(position).getLockStatus()){
            case LOCK_STATUS_BOUGHT:
                lockStatus = "Bought";
                break;
            case LOCK_STATUS_NOT_BOUGHT:
                lockStatus = "Not Bought";
                break;
            default:
                lockStatus = "Locked";
                break;
        }
        ((TextView) convertView.findViewById(R.id.lockStatus)).setText(lockStatus);
        String plantName = plant ==  null ? "No Plant" : plant.getName();
        ((TextView) convertView.findViewById(R.id.plant_name)).setText(plantName);
        return convertView;
    }
}
