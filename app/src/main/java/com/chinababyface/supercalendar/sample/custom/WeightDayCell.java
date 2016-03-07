package com.chinababyface.supercalendar.sample.custom;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.chinababyface.supercalendar.day.BaseDayCell;

import java.util.Calendar;

/**
 * Created by renyuxiang on 2016/3/7.
 */
public class WeightDayCell extends BaseDayCell<WeightVo> {
    private Paint mTextPaint;

    public WeightDayCell(Calendar date, WeightVo dDate, int r, int c, float cellSize) {
        super(date, dDate, r, c, cellSize);
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(25);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawText(""+getCalendar().get(Calendar.DAY_OF_MONTH), (float) ((getCol() + 0.5) * getCellSize() - mTextPaint.measureText(""+getCalendar().get(Calendar.DAY_OF_MONTH)) / 2),
                (float) ((getRow() + 0.7) * getCellSize() - mTextPaint.measureText(""+getCalendar().get(Calendar.DAY_OF_MONTH), 0, 1) / 2), mTextPaint);
    }
}
