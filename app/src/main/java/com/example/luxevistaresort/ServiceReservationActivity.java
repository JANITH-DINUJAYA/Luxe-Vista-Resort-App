package com.example.luxevistaresort;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import java.util.*;
import java.text.SimpleDateFormat;

public class ServiceReservationActivity extends AppCompatActivity {

    MaterialCalendarView calendarView;
    DBhelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation);

        calendarView = findViewById(R.id.calendarView);
        dbhelper = new DBhelper(this);

        List<String> dateStrings = dbhelper.getAllBookingDates();
        List<CalendarDay> calendarDays = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        for (String dateStr : dateStrings) {
            try {
                Date date = sdf.parse(dateStr);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                calendarDays.add(CalendarDay.from(cal));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        calendarView.addDecorator(new EventDecorator(Color.YELLOW, calendarDays));
    }

    public class EventDecorator implements DayViewDecorator {
        private final int color;
        private final HashSet<CalendarDay> dates;

        public EventDecorator(int color, List<CalendarDay> dates) {
            this.color = color;
            this.dates = new HashSet<>(dates);
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return dates.contains(day);
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.setBackgroundDrawable(new CircleDrawable(color));
        }
    }

    public class CircleDrawable extends android.graphics.drawable.ColorDrawable {
        public CircleDrawable(int color) {
            super(color);
        }
    }
}
