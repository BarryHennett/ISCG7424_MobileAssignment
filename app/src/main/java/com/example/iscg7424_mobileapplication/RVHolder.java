package com.example.iscg7424_mobileapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RVHolder extends RecyclerView.ViewHolder {
    TextView tv;

    public RVHolder(@NonNull View itemView){
        super(itemView);

        tv = itemView.findViewById(R.id.name);
        tv = itemView.findViewById(R.id.location);
        tv = itemView.findViewById(R.id.category);
        tv = itemView.findViewById(R.id.date);
        tv = itemView.findViewById(R.id.pricing);
        tv = itemView.findViewById(R.id.description);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(itemView.getContext(),
                        tv.getText()+"Clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
