package com.example.iscg7424_mobileapplication;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private String FNameCt;
    private String LNameCt;
    private String email;
    private String pword;

    public Customer() {
    }

    public Customer(int id, String FNameCt, String LNameCt, String email, String pword) {
        this.id = id;
        this.FNameCt = FNameCt;
        this.LNameCt = LNameCt;
        this.email = email;
        this.pword = pword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFNameCt() {
        return FNameCt;
    }

    public void setFNameCt(String FNameCt) {
        this.FNameCt = FNameCt;
    }

    public String getLNameCt() {
        return LNameCt;
    }

    public void setLNameCt(String LNameCt) {
        this.LNameCt = LNameCt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }
}

class CustomerManager {
    private static final String PREF_NAME = "CustomerData";
    private static final String CUSTOMER_KEY = "customer";

    // Save customer data to SharedPreferences
    public static void saveCustomer(Context context, Customer customer) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", customer.getId());
            jsonObject.put("FNameCt", customer.getFNameCt());
            jsonObject.put("LNameCt", customer.getLNameCt());
            jsonObject.put("email", customer.getEmail());
            jsonObject.put("pword", customer.getPword());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        editor.putString(CUSTOMER_KEY, jsonObject.toString());
        editor.apply();
    }

    // Retrieve customer data from SharedPreferences
    public static Customer getCustomer(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String jsonString = sharedPreferences.getString(CUSTOMER_KEY, null);
        if (jsonString != null) {
            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                Customer customer = new Customer();
                customer.setId(jsonObject.getInt("id"));
                customer.setFNameCt(jsonObject.getString("FNameCt"));
                customer.setLNameCt(jsonObject.getString("LNameCt"));
                customer.setEmail(jsonObject.getString("email"));
                customer.setPword(jsonObject.getString("pword"));
                return customer;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
