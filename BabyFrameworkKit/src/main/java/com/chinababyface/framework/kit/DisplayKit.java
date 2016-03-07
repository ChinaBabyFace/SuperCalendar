package com.chinababyface.framework.kit;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

import java.math.BigDecimal;

/**
 * @author ChinaBabyFace
 *         github.com/ChinaBabyFace
 */
public final class DisplayKit {

    public static final int SCREEN_WIDTH_320 = 320;
    public static final int SCREEN_WIDTH_480 = 480;
    public static final int SCREEN_WIDTH_640 = 640;
    public static final int SCREEN_WIDTH_720 = 720;
    public static final int SCREEN_WIDTH_1080 = 1080;

    public static final float MDPI_SCALE_CHANGE = 1.0f;
    public static final float HDPI_SCALE_CHANGE = 1.5f;
    //	public static final float XHDPI_SCALE_CHANGE = 2.25f;
    public static final float XHDPI_SCALE_CHANGE = 2.0f;
    //	public static final float XXHDPI_SCALE_CHANGE = 3.375f;
    public static final float XXHDPI_SCALE_CHANGE = 2.5f;

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    @SuppressWarnings("deprecation")
    public static int getScaleValue(Activity activity, int originalValue) {
        int value = 0;
        BigDecimal sacle = new BigDecimal(originalValue);
        BigDecimal sacleChange = null;
        switch (activity.getWindowManager().getDefaultDisplay().getWidth()) {
            case 320:
                sacleChange = new BigDecimal(MDPI_SCALE_CHANGE);
                break;
            case 480:
                sacleChange = new BigDecimal(HDPI_SCALE_CHANGE);
                break;
            case 640:
                sacleChange = new BigDecimal(HDPI_SCALE_CHANGE);
                break;
            case 720:
                sacleChange = new BigDecimal(XHDPI_SCALE_CHANGE);
                break;
            case 1080:
                sacleChange = new BigDecimal(XXHDPI_SCALE_CHANGE);
                break;
            default:
                sacleChange = new BigDecimal(activity.getWindowManager().getDefaultDisplay().getWidth() / 320);
        }
        sacle = sacle.multiply(sacleChange).setScale(0, BigDecimal.ROUND_DOWN);
        value = sacle.intValue();
        Log.e("value", value + "=================value");
        return value;
    }

    public static int getSelfScaleValue(Activity activity, int originalValue) {
        int value = 0;
        BigDecimal sacle = new BigDecimal(originalValue);
        BigDecimal sacleChange = null;
        switch (activity.getWindowManager().getDefaultDisplay().getWidth()) {
            case 320:
                sacleChange = new BigDecimal(MDPI_SCALE_CHANGE);
                break;
            case 480:
                sacleChange = new BigDecimal(HDPI_SCALE_CHANGE);
                break;
            case 640:
                sacleChange = new BigDecimal(HDPI_SCALE_CHANGE);
                break;
            case 720:
                sacleChange = new BigDecimal(2.25);
                break;
            case 1080:
                sacleChange = new BigDecimal(3.375);
                break;
            default:
                sacleChange = new BigDecimal(activity.getWindowManager().getDefaultDisplay().getWidth() / 320);
        }
        sacle = sacle.multiply(sacleChange).setScale(0, BigDecimal.ROUND_DOWN);
        value = sacle.intValue();
        Log.e("value", value + "=================value");
        return value;
    }

    public static DisplayMetrics getScreenMetric(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric;
    }

    public static int sp2px(Context contex, int value) {
        return (int) (value * contex.getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
