package com.chinababyface.supercalendar.sample;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.chinababyface.supercalendar.core.CalendarViewAdapter;
import com.chinababyface.supercalendar.sample.custom.WeighrMonthCardView;
import com.chinababyface.supercalendar.sample.custom.WeightCalendrManager;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CalendarViewAdapter adapter;
    private WeightCalendrManager calendrManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testSuperCalendar();
    }

    public void testSuperCalendar() {
        WeighrMonthCardView[] viewArray = new WeighrMonthCardView[3];
        for (int i = 0; i < viewArray.length; i++) {
            viewArray[i] = new WeighrMonthCardView(this);
            viewArray[i].setCurrentCalendar(Calendar.getInstance());
        }
        viewPager = (ViewPager) findViewById(R.id.calendarCard);
        adapter = new CalendarViewAdapter<WeighrMonthCardView>(viewArray);
        viewPager.setAdapter(adapter);
        calendrManager = new WeightCalendrManager(this, viewPager);
    }
}
