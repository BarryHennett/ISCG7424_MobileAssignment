package com.example.iscg7424_mobileapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RVAdapter2 extends RecyclerView.Adapter<RVHolder2> {

    String [] fname;
    String [] lname;
    String [] email;

    public RVAdapter2( AdminProfile adminProfile,
                      String [] fname, String [] lname, String [] email){
        this.fname = fname;
        this.lname = lname;
        this.email = email;

    }

    @NonNull
    @Override
    public RVHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View view = inflater.inflate(R.layout.rv_admin_profile, parent, false);
        return new RVHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder2 holder2, int position) {
        holder2.fname.setText(fname[position]);
        holder2.lname.setText(lname[position]);
        holder2.email.setText(email[position]);
    }

    @Override
    public int getItemCount()
    {return fname.length;}

}
