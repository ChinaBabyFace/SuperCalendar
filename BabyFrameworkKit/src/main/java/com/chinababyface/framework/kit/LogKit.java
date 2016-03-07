package com.chinababyface.framework.kit;

import android.util.Log;

/**
 * @author ChinaBabyFace
 *         github.com/ChinaBabyFace
 */
public final class LogKit {

    public static final boolean IS_DEBUG = KitSettings.IS_DEBUG_MODE;
    public static final String GLOBAL_TAG = KitSettings.APP_LOG_TAG;

    public static String getObjectName(Object object) {
        String temp = object.getClass().getName();
        return temp.substring(temp.lastIndexOf(".") + 1, temp.length());
    }

    public static void v(Object obj, String msg) {
        if (IS_DEBUG) {
            Log.v(getObjectName(obj), GLOBAL_TAG + msg);
        }
    }

    public static void e(Object obj, String msg) {
        if (IS_DEBUG) {
            Log.e(getObjectName(obj), GLOBAL_TAG + msg);
        }
    }

    public static void i(Object obj, String msg) {
        if (IS_DEBUG) {
            Log.i(getObjectName(obj), GLOBAL_TAG + msg);
        }
    }

    public static void d(Object obj, String msg) {
        if (IS_DEBUG) {
            Log.d(getObjectName(obj), GLOBAL_TAG + msg);
        }
    }
}
