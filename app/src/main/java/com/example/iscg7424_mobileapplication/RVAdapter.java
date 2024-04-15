package com.example.iscg7424_mobileapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVHolder> {

    String [] name;
    String [] location;
    String [] category;
    String [] pricing;
    int[] images;
    public RVAdapter(BrowseDeals browseDeals, String [] name, String [] location, String [] category, String [] pricing, int [] images){
        this.name = name;
        this.location = location;
        this.category = category;
        this.pricing = pricing;
        this.images = images;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View view = inflater.inflate(R.layout.rv_item, parent, false);
        return new RVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        holder.name.setText(name[position]);
        holder.location.setText(location[position]);
        holder.category.setText(category[position]);
        holder.pricing.setText(pricing[position]);
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount()
    {return name.length;}
    public static class RVHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView location;
        TextView category;
        TextView pricing;
        ImageView imageView;

        public RVHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            location = itemView.findViewById(R.id.location);
            category = itemView.findViewById(R.id.category);
            pricing = itemView.findViewById(R.id.pricing);
            imageView = itemView.findViewById(R.id.imgvwbrdls);
        }
    }
}
