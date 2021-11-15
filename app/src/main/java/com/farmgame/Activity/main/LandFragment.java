package com.farmgame.Activity.main;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.farmgame.R;
import com.farmgame.controller.LandActivitySystem.LandHarvestPlantSystem;
import com.farmgame.controller.LandActivitySystem.LandManagePlantStatusSystem;
import com.farmgame.databinding.FragmentLandBinding;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Player;
import com.farmgame.entity.Seeds;
import com.farmgame.gateway.LandDBApi;
import com.farmgame.viewModel.MainViewModel;

import static com.farmgame.constants.Constants.*;

import java.util.ArrayList;


public class LandFragment extends Fragment {


    private FragmentLandBinding binding;
    private MainViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentLandBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }


    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding.playerInfo.setText(playerInfo());

        viewModel.playerData.observe(requireActivity(), player -> {
            if (this.isVisible()){
                binding.playerInfo.setText(playerInfo());
                setAdapter();
            }
        });

        viewModel.landMapData.observe(requireActivity(), land -> {
            if (this.isVisible()){
                binding.playerInfo.setText(playerInfo());
                setAdapter();
            }
        });

        viewModel.warehouseData.observe(requireActivity(), land -> {
            if (this.isVisible()){
                binding.playerInfo.setText(playerInfo());
                setAdapter();
            }
        });

        setAdapter();
    }

    private String playerInfo(){
        ArrayList<String> list = new ArrayList<>();
        Player player = viewModel.getPlayer();

        String name = "name: " + player.getName();
        String level = "level: " + player.getLevel();
        String exp = "exp: " + player.getExp_bar()[0] + " / " + player.getExp_bar()[1];

        list.add(name);
        list.add(level);
        list.add(exp);

        return String.join("\n", list);
    }

    private void setAdapter(){
        LandAdapter adapter = new LandAdapter(requireActivity(), LandDBApi.getLandList());
        binding.landGv.setAdapter(adapter);
        binding.landGv.setOnItemClickListener((parent, view, position, id) -> {
            LandEntity land = adapter.getItem(position);
            switch (land.getLockStatus()){
                case LOCK_STATUS_BOUGHT:
                    Seeds seeds = land.getPlant();
                    if (seeds == null){
                        setPlantingWindow(land.getIndex());
                    } else {
                        setActionWindow(land);
                    }
                    break;
                case LOCK_STATUS_NOT_BOUGHT:
                    setBuyLandAlert(land);
                    break;
            }
        });
    }

    private void setPlantingWindow(int landIndex){
        View contentView = LayoutInflater.from(requireActivity()).inflate(R.layout.planting_popup, null);
        PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        View rootView = LayoutInflater.from(requireActivity()).inflate(R.layout.fragment_land, null);
        popupWindow.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        popupWindow.getContentView().findViewById(R.id.cancel_button).setOnClickListener(
                v -> popupWindow.dismiss());
        GridView gridView = popupWindow.getContentView().findViewById(R.id.gv);
        WarehouseAdapter adapter = new WarehouseAdapter(requireActivity(), viewModel.convertSeed());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
            builder.setMessage("Plant the land?")
                    .setPositiveButton(R.string.confirm, (dialog, which)
                            -> {
                                Toast.makeText(requireActivity(),
                                        viewModel.getLHS(landIndex).planting(
                                                adapter.getSeedId(position)),
                                        Toast.LENGTH_SHORT).show();
                                popupWindow.dismiss();
                            }
                    )
                    .setNegativeButton(R.string.cancel, null)
                    .create().show();
        });
    }

    private void setActionWindow(LandEntity land){
        View contentView = LayoutInflater.from(requireActivity()).inflate(R.layout.land_action_popup, null);
        PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        View rootView = LayoutInflater.from(requireActivity()).inflate(R.layout.fragment_land, null);
        popupWindow.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        View layout = popupWindow.getContentView();
        ((TextView) layout.findViewById(R.id.name)).setText("plant: " + land.getPlant().getName());
        ((TextView) layout.findViewById(R.id.stage)).setText("stage: " + land.getStage());
        ((TextView) layout.findViewById(R.id.water_time)).setText("water time: " + land.getWaterTime());
        ((TextView) layout.findViewById(R.id.is_wet)).setText("wet: " + (land.isWet()? "Yes" : "No"));
        ((TextView) layout.findViewById(R.id.fertilized)).setText("fertilized: " + (land.isFertilize()? "Yes" : "No"));
        int landIndex = land.getIndex();
        LandManagePlantStatusSystem lms = viewModel.getLMS(landIndex);
        LandHarvestPlantSystem lhs = viewModel.getLHS(landIndex);
        layout.findViewById(R.id.exit).setOnClickListener(
                v -> popupWindow.dismiss());
        layout.findViewById(R.id.harvest).setOnClickListener(
                v -> {
                    Toast.makeText(requireActivity(), lhs.harvest(), Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
        );
        layout.findViewById(R.id.fertilize).setOnClickListener(
                v -> {
                    Toast.makeText(requireActivity(), lms.fertilize(), Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
        );
        layout.findViewById(R.id.watering).setOnClickListener(
                v -> {
                    Toast.makeText(requireActivity(), lms.watering(), Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
        );
    }

    private void setBuyLandAlert(LandEntity land){
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setMessage("Buy the land? Cost: " + land.getPrice())
                .setPositiveButton(R.string.confirm, (dialog, which)
                                -> {
                    Toast.makeText(requireActivity(), viewModel.getLCS(land.getIndex()).buyLand(),
                            Toast.LENGTH_SHORT).show();
                        }
                )
                .setNegativeButton(R.string.cancel, null)
                .create().show();
    }
}