package com.farmgame.frontEnd.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.farmgame.databinding.FragmentWarehouseBinding;
import com.farmgame.frontEnd.main.adapter.WarehouseAdapter;
import com.farmgame.gateway.WarehouseDBApi;
import com.farmgame.usecase.StoreAble;
import com.farmgame.viewModel.MainViewModel;

import static com.farmgame.constants.Constants.*;

import java.util.ArrayList;

/**
 * the warehouse fragment of the main activity (fourth tab page)
 */
public class WarehouseFragment extends Fragment {

    private FragmentWarehouseBinding binding;

    private String isPlant = TYPE_PLANT;

    private MainViewModel viewModel;

    /**
     * when creating the fragment, call viewModel from activity, set onclick listeners to the
     * buttons, set observers to live data
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentWarehouseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding.plants.setOnClickListener(v -> {
            if (this.isVisible()){
                isPlant = TYPE_PLANT;
                binding.capacity.setText(text());
                setAdapter();
            }
        });

        binding.seeds.setOnClickListener(v -> {
            if (this.isVisible()){
                isPlant = TYPE_SEED;
                binding.capacity.setText(text());
                setAdapter();
            }
        });

        binding.item.setOnClickListener(v -> {
            if (this.isVisible()){
                isPlant = "item";
                binding.capacity.setText(text());
                setAdapter();
            }
        });

        viewModel.playerData.observe(requireActivity(), player -> binding.capacity.setText(text()));

        viewModel.warehouseData.observe(requireActivity(), warehouse -> {
            if (this.isVisible()){
                binding.capacity.setText(text());
                setAdapter();
            }
        });

        setAdapter();


        return root;

    }

    /**
     *
     * @return the texting showing capacity and currently showing inventory
     */
    private String text(){
        return "Capacity: " +WarehouseDBApi.getCur() +
                "/" + WarehouseDBApi.getCapacity() + " Currently Showing: " + isPlant;
    }

    /**
     * set adapter to the grid view
     */
    private void setAdapter(){
        ArrayList<ArrayList<StoreAble>> list;
        switch (isPlant) {
            case TYPE_PLANT:
                list = viewModel.convertPlant();
                break;
            case TYPE_SEED:
                list = viewModel.convertSeed();
                break;
            default:
                list = viewModel.convertItem();
                break;
        }
        WarehouseAdapter adapter = new WarehouseAdapter(requireActivity(), list);
        binding.gv.setAdapter(adapter);


    }


}
