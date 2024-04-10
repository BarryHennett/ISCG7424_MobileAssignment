package com.example.iscg7424_mobileapplication;

import android.app.Application;

public class MyApplication extends Application {
    private static Activity activity;

    public static void setActivity(Activity details) {
        activity = details;
    }

    public static Activity getActivity() {
        return activity;
    }
}
