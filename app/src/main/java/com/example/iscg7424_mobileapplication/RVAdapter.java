package com.example.iscg7424_mobileapplication;

import static android.view.View.inflate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iscg7424_mobileapplication.db.Deals;

import java.util.List;



public class RVAdapter extends RecyclerView.Adapter<RVHolder> {

    String[] tvname;
    String[] tvcategory;
    String[] tvpricing;
    String[] tvdescription;
    String[] tvdate;
    String[] tvlocation;

    int[] images;

    public RVAdapter(String[] tvname,
                     String[] tvlocation, String[] tvcategory,
                     String[] tvdate, String[] tvpricing,
                     String[] tvdescription, int[] images) {

        this.tvname = tvname;
        this.tvlocation = tvlocation;
        this.tvcategory  = tvcategory;
        this.tvdate  = tvdate;
        this.tvpricing  = tvpricing;
        this.tvdescription  = tvdescription;
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
        holder.tv.setText(tvname[position]);
        holder.tv.setText(tvlocation[position]);
        holder.tv.setText(tvcategory[position]);
        holder.tv.setText(tvdate[position]);
        holder.tv.setText(tvpricing[position]);
        holder.tv.setText(tvdescription[position]);

    }

    @Override
    public int getItemCount() {return tvname.length;}


}
