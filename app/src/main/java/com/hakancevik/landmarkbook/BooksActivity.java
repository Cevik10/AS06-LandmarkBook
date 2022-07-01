package com.hakancevik.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hakancevik.landmarkbook.databinding.ActivityBooksBinding;
import com.hakancevik.landmarkbook.databinding.ActivityMainBinding;

public class BooksActivity extends AppCompatActivity {

    private ActivityBooksBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBooksBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        Singleton singleton = Singleton.getInstance();
        Landmark selectedLandmark = singleton.getSelectedLandmark();

        binding.nameText.setText(selectedLandmark.name);
        binding.countryText.setText(selectedLandmark.country);
        binding.imageView.setImageResource(selectedLandmark.image);


        //Intent intent = getIntent();
        //Landmark comesLandmark = (Landmark) intent.getSerializableExtra("landmark");

        //binding.nameText.setText(comesLandmark.name);
        //binding.countryText.setText(comesLandmark.country);
        //binding.imageView.setImageResource(comesLandmark.image);


    }
}