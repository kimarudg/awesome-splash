package com.gadiness.kimarudg.awesome.splash.lib.utils;

import com.gadiness.kimarudg.awesome.splash.lib.cnst.Flags;
import com.gadiness.kimarudg.awesome.splash.lib.model.ConfigSplash;

/**
 * Created by kimaru on 5/8/18 using Android Studio.
 * Maintainer: David Kimaru
 *
 * @github https://github.com/kimarudg
 * @email kimarudg@gmail.com
 * @phone +254722384549
 * @web gakuu.co.ke
 */
public class ValidationUtil {

    public static int hasPath(ConfigSplash cs) {
        if (cs.getPathSplash().isEmpty())
            return Flags.WITH_LOGO;
        else
            return Flags.WITH_PATH;
    }
}
