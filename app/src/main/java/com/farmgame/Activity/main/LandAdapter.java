package com.farmgame.Activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.farmgame.R;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Plants;
import com.farmgame.entity.Seeds;

import java.util.ArrayList;
import static com.farmgame.constants.Constants.*;

public class LandAdapter extends BaseAdapter {

    ArrayList<LandEntity> lst;
    LayoutInflater layoutInflater;

    public LandAdapter(Context context, ArrayList<LandEntity> list){
        layoutInflater = LayoutInflater.from(context);
        lst = list;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public LandEntity getItem(int position) {
        return lst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

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
