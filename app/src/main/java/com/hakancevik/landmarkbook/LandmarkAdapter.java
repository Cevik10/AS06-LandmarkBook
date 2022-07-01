package com.hakancevik.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hakancevik.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {

    // liste size'ını öğrenmek için.
    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }



    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    }




    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {

        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(holder.getAdapterPosition()).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.itemView.getContext(),BooksActivity.class);
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



    public class LandmarkHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;

        public LandmarkHolder(RecyclerRowBinding binding){
            super(binding.getRoot());
            this.binding = binding;


        }
    }


}
