package com.chinababyface.framework.kit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ChinaBabyFace
 *         github.com/ChinaBabyFace
 */
public final class NumberKit {

    public static int praseStringToInteger(String valueString, int defaultValue) {
        if (valueString == null)
            return defaultValue;
        int result = defaultValue;
        try {
            result = Integer.parseInt(valueString);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static long praseStringToLong(String valueString, long defaultValue) {
        if (valueString == null)
            return defaultValue;
        long result = defaultValue;
        try {
            result = Long.parseLong(valueString);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static float praseStringToFloat(String valueString, float defaultValue) {
        if (valueString == null)
            return defaultValue;
        float result = defaultValue;
        try {
            result = Float.parseFloat(valueString);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
