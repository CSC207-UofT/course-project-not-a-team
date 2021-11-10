package com.farmgame.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.farmgame.R;

import com.farmgame.databinding.FragmentRegisterBinding;
import com.farmgame.entity.Player;
import com.farmgame.gateway.Initializer;
import com.farmgame.gateway.UserUpdater;
import com.farmgame.viewModel.LoginViewModel;

public class RegisgerFragment extends Fragment {

    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final LoginViewModel viewModel =
                new ViewModelProvider(requireActivity()).get(LoginViewModel.class);


        SQLiteDatabase db = viewModel.getDB();

        Cursor cursor = db.query("User", new String[]{"name"}, null, null, null, null, null);


        boolean hasData = cursor.moveToFirst();

        cursor.close();

        Context that = this.getActivity();


        binding.register.setOnClickListener(v -> {
            if (hasData){
                Player player = viewModel.getPlayer();
                Toast.makeText(that, "成功了！", Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(RegisgerFragment.this)
                        .navigate(R.id.action_RegisterFragment_to_SecondFragment);
            } else {
                if (binding.username.getText().toString().length() > 0){
                    viewModel.setPlayer(UserUpdater.createPlayer(binding.username.getText().toString()));
                } else {
                    Toast.makeText(that, "please enter your ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}