package com.farmgame.Activity.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.farmgame.R;
import com.farmgame.databinding.FragmentHomeBinding;
import com.farmgame.entity.LandEntity;
import com.farmgame.gateway.LandDBApi;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private static final int ROW_NUM = 5;
    private static final int COL_NUM = 4;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        populateLandButtons();
        final TextView textView = binding.textHome;
        return root;
    }
    private void populateLandButtons() {
        LandDBApi landDBApi = new LandDBApi();
        ArrayList<LandEntity> landList = landDBApi.getLandList();
        for(int row = 0; row < ROW_NUM; row ++){
            TableLayout table = binding.tableForLandButtons;
            TableRow tableRow = new TableRow(requireActivity());
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(tableRow);
            for (int col = 0; col < COL_NUM; col ++){
                Button button = new Button(requireActivity());
                tableRow.addView(button);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));
                // Setting up LandButtons
                button.setText(row + "," + col);
                button.setPadding(0,0,0, 0);
                button.setBackgroundResource(R.drawable.land_background);

                int finalCol = col;
                int finalRow = row;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        landButtonClick(finalRow, finalCol);
                    }
                });
            }
        }
    }
    private void landButtonClick(int col, int row){
        Toast.makeText(requireActivity(), col + "," + row + "Has been Clicked", Toast.LENGTH_SHORT).show();

        // if this land is unlocked and purchased
            //show attributes(plant, waterTime, etc...
            //show action buttons: harvest, water, fertilize...
        // Else if this land is unlock and not purchased
            // show buy button
        // else
            // show text message
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}