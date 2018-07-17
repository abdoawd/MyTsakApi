package com.example.abdulrahman.mytsakapi.utils;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.widget.TextView;

import com.example.abdulrahman.mytsakapi.applicatoin.App;

public class TextUtils {
    private TextUtils() {

    }

    public static void setMediumTypeFace(TextView view) {
        AssetManager am = App.getContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(am, "medium.ttf");
        view.setTypeface(typeface);

    }

    public static void setMontserratTypeFace(TextView view) {
        AssetManager am = App.getContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(am, "regular.ttf");
        view.setTypeface(typeface);
    }
}
