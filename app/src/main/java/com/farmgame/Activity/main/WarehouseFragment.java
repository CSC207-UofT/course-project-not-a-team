package com.farmgame.Activity.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.farmgame.databinding.FragmentNotificationsBinding;
import com.farmgame.databinding.FragmentWarehouseBinding;
import com.farmgame.entity.Item.Item;
import com.farmgame.entity.Plants;
import com.farmgame.gateway.LandDBApi;
import com.farmgame.gateway.WarehouseDBApi;
import com.farmgame.usecase.StoreAble;
import com.farmgame.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.HashMap;

public class WarehouseFragment extends Fragment {

    private FragmentWarehouseBinding binding;

    private boolean isPlant = true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentWarehouseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        MainViewModel viewModel =
                new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        HashMap<Integer, ArrayList<Item>> itemMap = viewModel.getWarehouse().getItemInventory();
        HashMap<Integer, ArrayList<Plants>> plantMap = viewModel.getWarehouse().getPlantInventory();

        GridView gridView = binding.gv;

        binding.plants.setOnClickListener(v -> {
            isPlant = true;
            setAdapter(itemMap, plantMap);
        });

        binding.item.setOnClickListener(v -> {
            isPlant = false;
            setAdapter(itemMap, plantMap);
        });

        viewModel.playerData.observe(requireActivity(), player -> {
            binding.capacity.setText("Capacity: " +WarehouseDBApi.getCur() +
                    "/" + WarehouseDBApi.getCapacity());
        });

        viewModel.warehouseData.observe(requireActivity(), warehouse -> {
                binding.capacity.setText("Capacity: " +WarehouseDBApi.getCur() +
                        "/" + WarehouseDBApi.getCapacity());
            setAdapter(itemMap, plantMap);

        });


        return root;

    }

    private void setAdapter(HashMap<Integer, ArrayList<Item>> itemMap, HashMap<Integer, ArrayList<Plants>> plantMap){
        if (this.isVisible()){
            WarehouseAdapter adapter =
                    isPlant ? new WarehouseAdapter(requireActivity(), convertPlant(plantMap)) :
                            new WarehouseAdapter(requireActivity(), convertItem(itemMap));
            binding.gv.setAdapter(adapter);
        }

    }

    private ArrayList<ArrayList<StoreAble>> convertItem(HashMap<Integer, ArrayList<Item>> itemMap){
        ArrayList<ArrayList<StoreAble>> result = new ArrayList<>();
        for (ArrayList<Item> list : itemMap.values()){
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    private ArrayList<ArrayList<StoreAble>> convertPlant(HashMap<Integer, ArrayList<Plants>> itemMap){
        ArrayList<ArrayList<StoreAble>> result = new ArrayList<>();
        for (ArrayList<Plants> list : itemMap.values()){
            result.add(new ArrayList<>(list));
        }
        return result;
    }

}
