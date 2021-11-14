package com.farmgame.Activity.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.farmgame.R;
import com.farmgame.databinding.FragmentStoreBinding;
import com.farmgame.entity.Plants;
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


        binding.money.setText("Money :" + viewModel.getPlayer().getMoney());


        ArrayList<StoreAble> lst = new ArrayList<>();
        lst.addAll(StoreDBApi.getSeedList());
        StoreGridViewAdapter adapter = new StoreGridViewAdapter(requireActivity(), lst);

        GridView gridView = binding.gv;
        gridView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}