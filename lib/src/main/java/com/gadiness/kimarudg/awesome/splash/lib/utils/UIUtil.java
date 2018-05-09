package com.gadiness.kimarudg.awesome.splash.lib.utils;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gadiness.kimarudg.awesome.splash.lib.cnst.Flags;

/**
 * Created by kimaru on 5/8/18 using Android Studio.
 * Maintainer: David Kimaru
 *
 * @github https://github.com/kimarudg
 * @email kimarudg@gmail.com
 * @phone +254722384549
 * @web gakuu.co.ke
 */
public class UIUtil {

    public static int getRevealDirection(RelativeLayout rl, int flag){
        int result = 0;
        switch (flag){
            case Flags.REVEAL_BOTTOM:
                result = rl.getBottom();
                break;
            case Flags.REVEAL_TOP:
                result = rl.getTop();
                break;
            case Flags.REVEAL_LEFT:
                result = rl.getLeft();
                break;
            case Flags.REVEAL_RIGHT:
                result = rl.getRight();
                break;
        }

        return result;
    }


    public static void setFont(Activity a, TextView txtView, String font) {
        Typeface type = Typeface.createFromAsset(a.getAssets(), font);
        txtView.setTypeface(type);
    }
}
