package com.example.iscg7424_mobileapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RVHolder extends RecyclerView.ViewHolder {
    TextView tv;
    TextView name;
    TextView location;
    TextView category;
    TextView pricing;
    ImageView images;
    public RVHolder(@NonNull View itemView){
        super(itemView);

        name = itemView.findViewById(R.id.name);
        location = itemView.findViewById(R.id.location);
        category = itemView.findViewById(R.id.category);
        pricing = itemView.findViewById(R.id.pricing);
        //tv = itemView.findViewById(R.id.date);

        //tv = itemView.findViewById(R.id.description);


    }
}
