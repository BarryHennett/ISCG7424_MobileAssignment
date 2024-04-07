package com.example.iscg7424_mobileapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomerAdapter extends ArrayAdapter<Customer>
{
    public CustomerAdapter(Context context, List<Customer> customers)
    {
        super(context, 0, customers);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Customer customer = getItem(position)
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_customer_register,parent, false);

        TextView FNameCt = convertView.findViewById(R.id.cellFirstName);


        return super.getView(position, convertView, parent);
    }
}
