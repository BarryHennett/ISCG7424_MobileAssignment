package com.example.iscg7424_mobileapplication;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVHolder3 extends RecyclerView.ViewHolder {
    TextView name;
    TextView location;
    TextView category;
    TextView pricing;
    ImageView imageView;

    public RVHolder3(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        location = itemView.findViewById(R.id.location);
        category = itemView.findViewById(R.id.category);
        pricing = itemView.findViewById(R.id.pricing);
        imageView = itemView.findViewById(R.id.imgvwbrdls);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DealDetails.class);
                context.startActivity(intent);
            }
        });
    }
}