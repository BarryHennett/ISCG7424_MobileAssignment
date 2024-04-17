package com.example.iscg7424_mobileapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RVAdapter3 extends RecyclerView.Adapter<RVHolder3> {

    String [] name;
    String [] location;
    String [] category;
    String [] pricing;
    int[] images;
    public RVAdapter3(UserProfile userProfile, String [] name, String [] location, String [] category, String [] pricing, int [] images){
        this.name = name;
        this.location = location;
        this.category = category;
        this.pricing = pricing;
        this.images = images;
    }

    @NonNull
    @Override
    public RVHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View view = inflater.inflate(R.layout.rv_item, parent, false);
        return new RVHolder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder3 holder3, int position) {
        holder3.name.setText(name[position]);
        holder3.location.setText(location[position]);
        holder3.category.setText(category[position]);
        holder3.pricing.setText(pricing[position]);
        holder3.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount()
    {return name.length;}

}
