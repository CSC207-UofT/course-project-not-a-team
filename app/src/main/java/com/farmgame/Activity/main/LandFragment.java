package com.farmgame.Activity.main;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.farmgame.R;
import com.farmgame.databinding.FragmentLandBinding;
import com.farmgame.gateway.LandDBApi;
import com.farmgame.viewModel.MainViewModel;


public class LandFragment extends Fragment {


    private FragmentLandBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentLandBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }


    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainViewModel viewModel =
                new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        LandAdapter adapter = new LandAdapter(requireActivity(), LandDBApi.getLandList());
        binding.landGv.setAdapter(adapter);
    }
}