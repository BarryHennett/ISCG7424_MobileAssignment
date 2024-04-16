package com.example.iscg7424_mobileapplication;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
    public RVHolder(@NonNull View itemView){
        super(itemView);

        name = itemView.findViewById(R.id.name);
        location = itemView.findViewById(R.id.location);
        category = itemView.findViewById(R.id.category);
        pricing = itemView.findViewById(R.id.pricing);
        tv = itemView.findViewById(R.id.cardview);
        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), DealDetails.class);
                view.getContext().startActivity(intent);
            }
        });

    }

}
