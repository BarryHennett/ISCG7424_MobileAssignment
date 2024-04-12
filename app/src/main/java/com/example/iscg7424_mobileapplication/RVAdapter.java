package com.example.iscg7424_mobileapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.text.TextUtils;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVHolder> {

    List<Deals> list;
    public RVAdapter(List<Deals>list){
        this.list = list;
    }

    public RVAdapter(BrowseDeals browseDeals, String[] activityName, String[] activityLocation, String[] activityCategory, String[] activityDate, String[] activityPricing, String[] activityDescription, int[] images) {
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new RVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        Deals deal = list.get(position);
        holder.tvname.setText(list.get(position).getName());
        holder.tvlocation.setText(list.get(position).getLocation());
        holder.tvcategory.setText(list.get(position).getCategory());
        holder.tvdate.setText(list.get(position).getDate());
        holder.tvpricing.setText(list.get(position).getPrice());
        holder.tvdescription.setText(list.get(position).getDesciption());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class RVHolder extends RecyclerView.ViewHolder {
        TextView tvname,tvlocation,tvcategory,tvdate,tvpricing,tvdescription;
        ImageView imageView;

        public RVHolder(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.name);
            tvlocation = itemView.findViewById(R.id.location);
            tvcategory  = itemView.findViewById(R.id.category);
            tvdate  = itemView.findViewById(R.id.date);
            tvpricing  = itemView.findViewById(R.id.pricing);
            tvdescription  = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imgvwbrdls);
        }
    }
}
