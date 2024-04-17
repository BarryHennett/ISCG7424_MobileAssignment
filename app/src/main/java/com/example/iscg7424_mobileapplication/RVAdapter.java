package com.example.iscg7424_mobileapplication;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RVAdapter extends RecyclerView.Adapter<RVHolder> {

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

}