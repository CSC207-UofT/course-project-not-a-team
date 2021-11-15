package com.farmgame.frontEnd.main;

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
import com.farmgame.databinding.FragmentStoreBinding;
import com.farmgame.frontEnd.main.adapter.StoreGridViewAdapter;
import com.farmgame.gateway.StoreDBApi;
import com.farmgame.usecase.StoreAble;
import com.farmgame.viewModel.MainViewModel;

import java.util.ArrayList;

public class storeFragment extends Fragment {

    private FragmentStoreBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentStoreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MainViewModel viewModel =
                new ViewModelProvider(requireActivity()).get(MainViewModel.class);


        viewModel.playerData.observe(requireActivity(), player ->
                binding.money.setText("money:" + player.getMoney()));



        ArrayList<StoreAble> lst = new ArrayList<>();
        lst.addAll(StoreDBApi.getSeedList());
        lst.addAll(StoreDBApi.getItemList());
        StoreGridViewAdapter adapter = new StoreGridViewAdapter(requireActivity(), lst);


        GridView gridView = binding.gv;
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
            builder.setMessage("Buy the product")
                    .setPositiveButton(R.string.confirm, (dialog, which)
                            -> Toast.makeText(requireActivity(),
                            viewModel.getStoreSystem().makePurchase(adapter.getItem(position)),
                            Toast.LENGTH_SHORT).show()
                            )
                    .setNegativeButton(R.string.cancel, null)
                    .create().show();
        });

        return root;
    }

}