package com.chinababyface.framework.kit;

import java.math.BigDecimal;

/**
 * @author ChinaBabyFace
 *         github.com/ChinaBabyFace
 */
public final class DecimalKit {

    /**
     * <b>decimalToInteger。</b>
     * <p><b>详细说明：</b></p>
     * <!-- 在此添加详细说明 -->
     * BigDecimal转化为integer。
     *
     * @param decimal
     * @return
     */
    public static int decimalToInteger(BigDecimal decimal) {
        try {
            if (decimal != null) {
                return decimal.setScale(0, BigDecimal.ROUND_UP).intValue();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

    /**
     * <b>integerToBigDecimal。</b>
     * <p><b>详细说明：</b></p>
     * <!-- 在此添加详细说明 -->
     * 将int型转化为BigDecimal。
     *
     * @param value
     * @return
     */
    public static BigDecimal integerToBigDecimal(int value) {
        try {
            return new BigDecimal(value);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return new BigDecimal(0);
    }

    /**
     * <b>stringToBigDecimalToInt。</b>
     * <p><b>详细说明：</b></p>
     * <!-- 在此添加详细说明 -->
     * 将字符串型的BigDecimal转化为int型。
     *
     * @param number
     * @return
     */
    public static int stringToBigDecimalToInteger(String number) {
        if (number == null || number.trim().equals("")) {
            return 0;
        }
        BigDecimal decimal = new BigDecimal(number);
        return decimal.intValue();
    }
}
