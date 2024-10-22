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
    String data[];
    int[] images;
    private List<String> dataListFull;

    public RVAdapter(BrowseDeals mainActivity, String[] data, int[] images) {
        this.data = data;
        this.images = images;
        dataListFull = new ArrayList<>(Arrays.asList(data));
    }

    public RVAdapter(UserProfile mainActivity, String[] data, int[] images) {
        this.data = data;
        this.images = images;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_item, parent, false);
        return new RVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        holder.tv.setText(data[position]);
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class RVHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView imageView;

        public RVHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tvbrdls);
            imageView = itemView.findViewById(R.id.imgvwbrdls);
        }
    }
    public void filter(String query) {
        data = dataListFull.toArray(new String[0]);
        if (!TextUtils.isEmpty(query)) {
            List<String> filteredList = new ArrayList<>();
            for (String item : dataListFull) {
                if (item.toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(item);
                }
            }
            data = filteredList.toArray(new String[0]);
        }
        notifyDataSetChanged();
    }
}
