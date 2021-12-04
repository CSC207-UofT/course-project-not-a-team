package com.farmgame.frontEnd.main;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import com.farmgame.viewModel.LandActivitySystem.LandHarvestPlantSystem;
import com.farmgame.viewModel.LandActivitySystem.LandManagePlantStatusSystem;
import com.farmgame.databinding.FragmentLandBinding;
import com.farmgame.entity.LandEntity;
import com.farmgame.entity.Player;
import com.farmgame.entity.Seeds;
import com.farmgame.frontEnd.main.adapter.LandAdapter;
import com.farmgame.frontEnd.main.adapter.WarehouseAdapter;
import com.farmgame.gateway.LandDBApi;
import com.farmgame.viewModel.MainViewModel;

import static com.farmgame.constants.Constants.*;

import java.util.ArrayList;

/**
 * the fragment of the land page (first tab page), in MainActivity
 */
@SuppressLint("InflateParams")
public class LandFragment extends Fragment {


    private FragmentLandBinding binding;
    private MainViewModel viewModel;

    /**
     * create the fragment
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentLandBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }


    /**
     * when the fragment started, initialize viewModel and add observers to live data
     */
    @Override
    public void onStart() {
        super.onStart();
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding.playerInfo.setText(playerInfo());

        binding.harvestAll.setOnClickListener(v -> viewModel.getLHS().auto_harvest());

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

    /**
     *
     * @return the player's info to be presented
     */
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

    /**
     * set adapter to land grid view
     */
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

    /**
     * set the window of planting a plant into an empty bought land
     * @param landIndex the index of the plant
     */
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
                                        viewModel.getLHS().planting(landIndex,
                                                adapter.getItem(position).get(0).getId()),
                                        Toast.LENGTH_SHORT).show();
                                popupWindow.dismiss();
                            }
                    )
                    .setNegativeButton(R.string.cancel, null)
                    .create().show();
        });
    }

    /**
     * set the window of planting actions(watering, harvest, fertilize) of a land
     * @param land the land that the actions to be executed on
     */
    @SuppressLint("SetTextI18n")
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
        LandManagePlantStatusSystem lms = viewModel.getLMS();
        LandHarvestPlantSystem lhs = viewModel.getLHS();
        layout.findViewById(R.id.exit).setOnClickListener(
                v -> popupWindow.dismiss());
        layout.findViewById(R.id.harvest).setOnClickListener(
                v -> {
                    Toast.makeText(requireActivity(), lhs.harvest(landIndex), Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
        );
        layout.findViewById(R.id.fertilize).setOnClickListener(
                v -> {
                    Toast.makeText(requireActivity(), lms.fertilize(landIndex), Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
        );
        layout.findViewById(R.id.watering).setOnClickListener(
                v -> {
                    Toast.makeText(requireActivity(), lms.watering(landIndex), Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
        );
    }

    /**
     * set the window of buying an unlocked but unbought land
     * @param land the land to be bought
     */
    private void setBuyLandAlert(LandEntity land){
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setMessage("Buy the land? Cost: " + land.getPrice())
                .setPositiveButton(R.string.confirm, (dialog, which)
                                -> Toast.makeText(requireActivity(), viewModel.getLCS().buyLand(
                                        land.getIndex()), Toast.LENGTH_SHORT).show()
                )
                .setNegativeButton(R.string.cancel, null)
                .create().show();
    }
}