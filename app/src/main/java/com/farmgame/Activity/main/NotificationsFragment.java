package com.farmgame.Activity.main;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.farmgame.R;
import com.farmgame.databinding.FragmentNotificationsBinding;
import com.farmgame.gateway.StoreDBApi;
import com.farmgame.usecase.StoreAble;
import com.farmgame.viewModel.MainViewModel;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {


    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MainViewModel viewModel =
                new ViewModelProvider(requireActivity()).get(MainViewModel.class);


        viewModel.playerData.observe(requireActivity(), player ->
                binding.money.setText("money:" + player.getMoney()));

        GridView gridView = binding.gv;

        viewModel.warehouseData.observe(requireActivity(), warehouse -> {
            sellAdapter adapter = new sellAdapter(requireActivity(),
                    viewModel.getWarehouse().getPlantInventory());


            gridView.setAdapter(adapter);
            gridView.setOnItemClickListener((parent, view, position, id) -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
                builder.setMessage("Sell the product")
                        .setPositiveButton(R.string.confirm, (dialog, which)
                                -> Toast.makeText(requireActivity(),
                                viewModel.getStoreSystem().sell(adapter.getItem(position).get(0)),
                                Toast.LENGTH_LONG).show()
                        )
                        .setNegativeButton(R.string.cancel, null)
                        .create().show();
            });
        });


        return root;
    }
}