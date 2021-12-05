package com.farmgame.frontEnd.main;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.farmgame.R;
import com.farmgame.databinding.FragmentSellBinding;
import com.farmgame.frontEnd.main.adapter.SellAdapter;
import com.farmgame.viewModel.MainViewModel;


/**
 * The sell fragment of the main activity (third tab page)
 */
public class SellFragment extends Fragment {


    private FragmentSellBinding binding;

    private MainViewModel viewModel;

    /**
     * when creating the fragment, call the viewModel from activity, set observer to live data, set
     * adapter to the grid view
     */
    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentSellBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        setAdapter();



        viewModel.playerData.observe(requireActivity(), player ->
                binding.money.setText("money:" + player.getMoney()));

        viewModel.warehouseData.observe(requireActivity(), warehouse -> {
            if (this.isVisible()){
                setAdapter();
            }
        });

        binding.sellAll.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
            builder.setMessage("Sell All?")
                    .setPositiveButton(R.string.confirm, (dialog, which)
                            -> Toast.makeText(requireActivity(),
                            viewModel.getStoreSystem().sellAll(),
                            Toast.LENGTH_SHORT).show()
                    )
                    .setNegativeButton(R.string.cancel, null)
                    .create().show();
        });


        return root;
    }


    /**
     * set adapter to the sell grid view
     */
    private void setAdapter(){
        SellAdapter adapter = new SellAdapter(requireActivity(),
                viewModel.getWarehouse().getPlantInventory());

        GridView gridView = binding.gv;

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
            builder.setMessage("Sell the product")
                    .setPositiveButton(R.string.confirm, (dialog, which)
                            -> Toast.makeText(requireActivity(),
                            viewModel.getStoreSystem().sell(adapter.getItem(position).get(0)),
                            Toast.LENGTH_SHORT).show()
                    )
                    .setNegativeButton(R.string.cancel, null)
                    .create().show();
        });
    }
}