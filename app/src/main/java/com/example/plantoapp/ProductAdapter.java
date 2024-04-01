package com.example.plantoapp;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{
    Activity activity;
    private List<Plant> plantList = new ArrayList<>();
    public ProductAdapter( List<Plant> plantList ) {
        this.plantList = plantList;
    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater, parent);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Context context = holder.itemView.getContext();
        Plant plant = plantList.get(position);
        holder.imageViewMain.setImageResource(plant.getImageResourceId());
        holder.imageViewMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailActivity.class)
                        .putExtra("img", plant.getImageResourceId())
                        .putExtra("name", plant.getName())
                        .putExtra("image", plant.getWithoutBgImage())
                        .putExtra("rating", plant.getRating())
                        .putExtra("description", plant.getDescription())
                        .putExtra("size", plant.getSize())
                        .putExtra("plant", plant.getPlant())
                        .putExtra("height", plant.getHeight())
                        .putExtra("humidity", plant.getHumidity())
                        .putExtra("price", plant.getPrice())
                );
            }
        });



    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewMain, imgLike;
    Button imgDetailView;


        public MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.base_layout, parent, false));
            imageViewMain = itemView.findViewById(R.id.imgplant);
            imgDetailView = itemView.findViewById(R.id.btndetail);
            imgLike = itemView.findViewById(R.id.imgLike);

        }
    }
}
