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
import com.farmgame.entity.Seeds;
import com.farmgame.gateway.LandDBApi;
import com.farmgame.gateway.WarehouseDBApi;
import com.farmgame.usecase.StoreAble;
import com.farmgame.viewModel.MainViewModel;

import static com.farmgame.constants.Constants.*;

import java.util.ArrayList;
import java.util.HashMap;

public class WarehouseFragment extends Fragment {

    private FragmentWarehouseBinding binding;

    private String isPlant = TYPE_PLANT;

    private MainViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentWarehouseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding.plants.setOnClickListener(v -> {
            isPlant = TYPE_PLANT;
            binding.capacity.setText(text());
            setAdapter();
        });

        binding.seeds.setOnClickListener(v -> {
            isPlant = TYPE_SEED;
            binding.capacity.setText(text());
            setAdapter();
        });

        binding.item.setOnClickListener(v -> {
            isPlant = "item";
            binding.capacity.setText(text());
            setAdapter();
        });

        viewModel.playerData.observe(requireActivity(), player -> {
            binding.capacity.setText(text());
        });

        viewModel.warehouseData.observe(requireActivity(), warehouse -> {
                binding.capacity.setText(text());
            setAdapter();

        });


        return root;

    }

    private String text(){
        return "Capacity: " +WarehouseDBApi.getCur() +
                "/" + WarehouseDBApi.getCapacity() + " Currently Showing: " + isPlant;
    }

    private void setAdapter(){
        ArrayList<ArrayList<StoreAble>> list;
        if (this.isVisible()){
            switch (isPlant){
                case TYPE_PLANT:
                    list = convertPlant(viewModel.getWarehouse().getPlantInventory());
                    break;
                case TYPE_SEED:
                    list = convertSeed(viewModel.getWarehouse().getSeedInventory());
                    break;
                default:
                    list = convertItem(viewModel.getWarehouse().getItemInventory());
                    break;
            }
            WarehouseAdapter adapter = new WarehouseAdapter(requireActivity(), list);
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

    private ArrayList<ArrayList<StoreAble>> convertSeed(HashMap<Integer, ArrayList<Seeds>> itemMap){
        ArrayList<ArrayList<StoreAble>> result = new ArrayList<>();
        for (ArrayList<Seeds> list : itemMap.values()){
            result.add(new ArrayList<>(list));
        }
        return result;
    }

}
