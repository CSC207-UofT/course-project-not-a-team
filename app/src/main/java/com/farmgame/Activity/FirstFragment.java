package com.farmgame.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.farmgame.R;
import com.farmgame.databinding.FragmentFirstBinding;
import com.farmgame.gateway.Initializer;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Initializer init = new Initializer(this.getActivity());
        SQLiteDatabase db = init.getReadableDatabase();

        Cursor cursor = db.query("User", new String[]{"name"}, null, null, null, null, null);

        cursor.close();

        Context that = this.getActivity();

        Boolean hasData = cursor.moveToFirst();

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasData){
                    Toast.makeText(that, "成功了！", Toast.LENGTH_SHORT).show();
                } else {
                    if (binding.username.getText().toString().length() > 0){
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("name", binding.username.getText().toString());
                        contentValues.put("level", 1);
                        contentValues.put("exp", 1);
                        db.insert("User", null, contentValues);
                    }
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