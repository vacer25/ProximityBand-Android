package com.queensu.apsc_100_mod_3_group_h.proximityband;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin on 3/6/2017.
 * Test
 */

public class HelperFunctions {

    private static ArrayList<String> includedPackages = new ArrayList<String>() {{
        add("com.android.mms"); // Messages
        add("com.android.email"); // Email
        add("com.android.calendar"); // Calendar
        add("com.android.phone"); // Phone
    }};

    public static boolean isSystemPackage(PackageInfo pkgInfo) {
        return (((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) && !includedPackages.contains(pkgInfo.packageName)) ? true : false;
    }

    static void vibrate(Activity activity, int time) {
        Vibrator v = (Vibrator) activity.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(time);
    }

    // ------------------------------ ACTIVITY SETTINGS ------------------------------

    static void hideActionBarAndStatusBar(Activity activity) {

        // Hide the action bar.
        ActionBar actionBar = ((AppCompatActivity)activity).getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        // Hide the status bar.
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

    }

    // ------------------------------ DISPLAY TOAST MESSAGE ------------------------------

    public static void displayToastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    // ------------------------------ LINEAR INTERPOLATION ------------------------------

    public static float map(float x, float in_min, float in_max, float out_min, float out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

}
