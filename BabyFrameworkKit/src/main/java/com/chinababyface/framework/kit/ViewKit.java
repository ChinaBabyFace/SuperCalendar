package com.chinababyface.framework.kit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * @author ChinaBabyFace
 *         github.com/ChinaBabyFace
 */
public final class ViewKit {

    /**
     * <b>setListViewHeightBasedOnChildren。</b>
     * <p><b>详细说明：</b></p>
     * <!-- 在此添加详细说明 -->
     * 无。
     *
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public static void showToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_LONG).show();
    }
}
