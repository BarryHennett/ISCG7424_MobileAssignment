package com.example.iscg7424_mobileapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVHolder2 extends RecyclerView.ViewHolder {
    TextView fname;
    TextView lname;
    TextView email;

    public RVHolder2(@NonNull View itemView){
        super(itemView);

        fname = itemView.findViewById(R.id.fname);
        lname = itemView.findViewById(R.id.lname);
        email = itemView.findViewById(R.id.email);
    }
}
