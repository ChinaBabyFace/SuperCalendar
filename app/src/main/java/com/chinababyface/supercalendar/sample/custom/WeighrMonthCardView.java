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
    public WeightDayCell getDayCell(Calendar date, int r, int c, float cellSize) {
        return new WeightDayCell(date, new WeightVo(58), r, c, cellSize);
    }

    @Override
    public MonthDayRow<WeightDayCell> getRow(int row, int colNum) {
        return new MonthDayRow<>(row, new WeightDayCell[colNum]);
    }


    public List<WeightVo> getDataList() {
        return dataList;
    }

    public void setDataList(List<WeightVo> dataList) {
        this.dataList = dataList;
    }
}
