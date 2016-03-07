package com.chinababyface.framework.kit;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ChinaBabyFace
 *         github.com/ChinaBabyFace
 */
public final class JavaKit {

    /**
     * <b>getOne。</b>
     * <p><b>详细说明：</b></p>
     * <!-- 在此添加详细说明 -->
     * 无。
     *
     * @param list
     * @return
     */
    public static Object getListFirstItem(List<Object> list) {
        if ((list != null) && !list.isEmpty()) {
            if (list.get(0) != null) {
                return list.get(0);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * <b>getListItemById。</b>
     * <p><b>详细说明：</b></p>
     * <!-- 在此添加详细说明 -->
     * 返回list集合中指定id的对象。
     *
     * @param list
     * @param id
     * @return
     */
    public static Object getListItemById(List<Object> list, int id) {
        if ((list != null) && !list.isEmpty() && id < list.size()) {
            if (list.get(id) != null) {
                return list.get(id);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * <b>isListEmpty。</b>
     * <p><b>详细说明：</b></p>
     * <!-- 在此添加详细说明 -->
     * list是否为空。
     *
     * @param l
     * @return
     */
    public static boolean isListEmpty(List<?> l) {
        return (l == null || l.isEmpty());
    }

    public static boolean isStringEmpty(String context) {
        return (context == null || context.trim().equals(""));
    }

    public static JSONObject mapToJson(Map<String, Object> map) {
        JSONObject json = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                json.put(entry.getKey(), entry.getValue().toString());
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json;
    }

    /**
     * <b>splitStringToList。</b>
     * <p><b>详细说明：</b></p>
     * <!-- 在此添加详细说明 -->
     * 将String按正则表达式给定的规则，拆成一个List。
     *
     * @param target
     * @param regx
     * @return
     */
    public static List<String> splitStringToList(String target, String regx) {
        List<String> stringList = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(target);
        int cursor = 0;
        while (matcher.find()) {
            if (cursor < matcher.start()) {
                stringList.add((String) target.subSequence(cursor, matcher.start()));
            }
            stringList.add(matcher.group());
            cursor = matcher.end();
        }
        if (cursor < target.length()) {
            stringList.add((String) target.subSequence(cursor, target.length()));
        }
        return stringList;
    }
}
