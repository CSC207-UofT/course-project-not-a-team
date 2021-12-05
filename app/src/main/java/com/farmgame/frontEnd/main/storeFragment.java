package com.farmgame.frontEnd.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.farmgame.databinding.FragmentStoreBinding;
import com.farmgame.frontEnd.main.adapter.StoreGridViewAdapter;
import com.farmgame.gateway.StoreDBApi;
import com.farmgame.usecase.StoreAble;
import com.farmgame.viewModel.MainViewModel;

import java.util.ArrayList;

/**
 * the store fragment in the main activity (second tab page)
 */
public class storeFragment extends Fragment {

    private FragmentStoreBinding binding;

    /**
     * when creating the fragment, call the viewModel from activity, set adapter to the grid view
     */
    @SuppressLint("SetTextI18n")
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
            BuyDialog buyDialog = new BuyDialog(requireActivity());
            buyDialog.show();
            buyDialog.setConfirmListener(v -> Toast.makeText(requireActivity(),
                    viewModel.getStoreSystem().makePurchase(adapter.getItem(position),
                            buyDialog.getQuantity()),
                    Toast.LENGTH_SHORT).show());
        });

        return root;
    }

}