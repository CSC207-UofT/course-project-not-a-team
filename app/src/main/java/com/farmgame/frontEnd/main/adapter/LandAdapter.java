package com.farmgame.frontEnd.main.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.land_item, null);

        TextView landText = convertView.findViewById(R.id.landtext);
        ImageView landImage = convertView.findViewById(R.id.landimage);

        Seeds plant = getItem(position).getPlant();
        switch (getItem(position).getLockStatus()){
            case LOCK_STATUS_NOT_BOUGHT:
                landText.setText("Not Bought");
                break;
            case LOCK_STATUS_LOCKED:
                landText.setText("Locked");
                break;
            default:
                break;
        }
        convertView.findViewById(R.id.landBackground).setBackgroundResource(R.drawable.land_background);
        if (plant == null) {
            landText.setVisibility(View.VISIBLE);
            landImage.setVisibility(View.INVISIBLE);
        } else {
            String imageName = "p" + plant.getId();
            int resID = layoutInflater.getContext().getResources().getIdentifier(imageName, "drawable", layoutInflater.getContext().getPackageName());
            landImage.setBackgroundResource(resID);

            landText.setVisibility(View.INVISIBLE);
            landImage.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
}
