package com.hakancevik.landmarkbook.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;


import com.hakancevik.landmarkbook.R;
import com.hakancevik.landmarkbook.adapter.LandmarkAdapter;
import com.hakancevik.landmarkbook.databinding.ActivityMainBinding;
import com.hakancevik.landmarkbook.model.Landmark;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarkList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        landmarkList = new ArrayList<>();

        // Data
        Landmark pisa = new Landmark("Pisa", "Italy", R.drawable.pisatower);
        Landmark eiffel = new Landmark("Eiffel", "France", R.drawable.eiffeltower);
        Landmark colosseum = new Landmark("Colosseum", "Italy", R.drawable.colesseum);
        Landmark londonBridge = new Landmark("London Bridge", "England", R.drawable.londonbridge);

        landmarkList.add(pisa);
        landmarkList.add(eiffel);
        landmarkList.add(colosseum);
        landmarkList.add(londonBridge);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkList);
        binding.recyclerView.setAdapter(landmarkAdapter);


    }


}


