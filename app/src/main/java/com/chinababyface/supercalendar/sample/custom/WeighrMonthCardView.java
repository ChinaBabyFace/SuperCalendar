package com.chinababyface.supercalendar.sample.custom;

import android.content.Context;
import android.util.AttributeSet;

import com.chinababyface.supercalendar.month.MonthCardView;
import com.chinababyface.supercalendar.month.MonthDayRow;

import java.util.Calendar;
import java.util.List;

/**
 * Created by renyuxiang on 2016/3/7.
 */
public class WeighrMonthCardView extends MonthCardView<WeightDayCell> {
    private List<WeightVo> dataList;

    public WeighrMonthCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public WeighrMonthCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WeighrMonthCardView(Context context) {
        super(context);
    }

    @Override
    public void fillDate() {
        Calendar currentMonthCalendar = getCurrentCalendar();
        currentMonthCalendar.set(Calendar.DAY_OF_MONTH, 1);
        Calendar lastMonthCalendar = (Calendar) currentMonthCalendar.clone();
        lastMonthCalendar.add(Calendar.MONTH, -1);
        Calendar nextMonthCalendar = (Calendar) currentMonthCalendar.clone();
        nextMonthCalendar.add(Calendar.MONTH, 1);
        int todayOfMonth = currentMonthCalendar.get(Calendar.DAY_OF_MONTH);
        int lastMonthDayCount = lastMonthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int currentMonthDayCount = currentMonthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int firstDayWeek = currentMonthCalendar.get(Calendar.DAY_OF_WEEK) - 1;
        int day = 0;

        for (int row = 0; row < TOTAL_ROW; row++) {
            rows[row] = new MonthDayRow<WeightDayCell>(row, new WeightDayCell[TOTAL_COL]);
            for (int col = 0; col < TOTAL_COL; col++) {
                int position = col + row * TOTAL_COL; // 单元格位置
                if (position >= firstDayWeek && position < firstDayWeek + currentMonthDayCount) {
                    //设置本月的日数据
                    day++;
                    currentMonthCalendar.set(Calendar.DAY_OF_MONTH, day);
                    rows[row].cellArray[col] = new WeightDayCell(
                            (Calendar) (currentMonthCalendar.clone()),
                            new WeightVo(58),
                            row,
                            col,
                            getCellSize());
                } else if (position < firstDayWeek) {
                    //设置上一个月的数据
                    lastMonthCalendar.set(Calendar.DAY_OF_MONTH, lastMonthDayCount - (firstDayWeek - position - 1));
                    rows[row].cellArray[col] = new WeightDayCell(
                            (Calendar) lastMonthCalendar.clone(),
                            new WeightVo(58),
                            row,
                            col,
                            getCellSize());
                } else if (position >= firstDayWeek + currentMonthDayCount) {
                    //设置看下一个月的数据
                    nextMonthCalendar.set(Calendar.DAY_OF_MONTH, position - firstDayWeek - currentMonthDayCount + 1);
                    rows[row].cellArray[col] = new WeightDayCell(
                            (Calendar) nextMonthCalendar.clone(),
                            new WeightVo(58),
                            row,
                            col,
                            getCellSize());
                }
            }
        }
    }

    public List<WeightVo> getDataList() {
        return dataList;
    }

    public void setDataList(List<WeightVo> dataList) {
        this.dataList = dataList;
    }
}
