package com.example.abdulrahman.mytsakapi.utils;

import android.widget.ImageView;

import com.example.abdulrahman.mytsakapi.R;
import com.example.abdulrahman.mytsakapi.applicatoin.App;
import com.example.abdulrahman.mytsakapi.network.Constants;
import com.squareup.picasso.Picasso;

public class ImageUtils {
    private static Picasso picasso;

    public static void loadImage(ImageView target, String url) {
        if (url == null || url.isEmpty() || target == null)
            return;
        if (url.equals(Constants.NO_IMG_URL)) {
            getPicasso().load(R.drawable.cat_no_img).placeholder(R.drawable.cat_no_img).fit().into(target);
        } else {
            getPicasso().load(url).placeholder(R.drawable.cat_no_img).fit().into(target);
        }

    }

    private static Picasso getPicasso() {
        if (picasso == null) {
            Picasso.Builder builder = new Picasso.Builder(App.getContext());
            picasso = builder.build();
        }
        return picasso;
    }

}
