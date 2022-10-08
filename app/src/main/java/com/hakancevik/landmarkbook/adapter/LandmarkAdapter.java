package com.hakancevik.landmarkbook.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hakancevik.landmarkbook.view.BooksActivity;
import com.hakancevik.landmarkbook.model.Landmark;
import com.hakancevik.landmarkbook.Singleton;
import com.hakancevik.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {

    ArrayList<Landmark> landmarkArrayList;

    // adapter color
    public String[] colors = {"#a3ff00", "#ff00aa", "#b4a7d6", "#a4c2f4", "#8ee5ee", "#cd950c", "#f5f5f5", "#f47932"};


    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }


    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new LandmarkHolder(recyclerRowBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {

        // adapter color
        holder.binding.recyclerViewTextView.setBackgroundColor(Color.parseColor(colors[position % 8]));

        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(holder.getAdapterPosition()).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.itemView.getContext(), BooksActivity.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenLandmark(landmarkArrayList.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);

                //Intent intent = new Intent(holder.itemView.getContext(),BooksActivity.class);
                //intent.putExtra("landmark",landmarkArrayList.get(holder.getAdapterPosition()));
                //holder.itemView.getContext().startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }


    public static class LandmarkHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;

        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }
    }


}
