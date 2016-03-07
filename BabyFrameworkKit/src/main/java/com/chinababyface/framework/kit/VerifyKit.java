package com.chinababyface.framework.kit;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * @author ChinaBabyFace
 *         github.com/ChinaBabyFace
 */
public final class VerifyKit {

    /**
     * <b>isMobileNO。</b>
     * <p>
     * <b>详细说明：</b>
     * </p>
     * <!-- 在此添加详细说明 --> 验证手机格式
     * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、182、187、188
     * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobile(String mobiles) {
        String telRegex = "^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$";
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        } else {
            return mobiles.matches(telRegex);
        }
    }

    /**
     * 验证邮箱格式
     */
    public static boolean isEmail(String email) {
        String emailStr = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        // if (TextUtils.isEmpty(email)) {
        // return false;
        // } else {
        // return email.matches(emailStr);
        // }

        return email.matches(emailStr);

    }

    public static boolean isHeight(String height) {
        String heightRegex = "^(1|2)[0-9]{2}$";
        if (TextUtils.isEmpty(height)) {
            return false;
        } else {
            return height.matches(heightRegex);
        }
    }

    public static boolean isNumber(String numberString) {
        Pattern pattern = Pattern.compile("[0-9]*");
        if (TextUtils.isEmpty(numberString)) {
            return false;
        } else {
            return pattern.matcher(numberString).matches();
        }
    }
}
