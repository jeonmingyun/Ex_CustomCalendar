package com.example.customcalendar;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customcalendar.adpater.CalendarAdapter;
import com.example.customcalendar.fragment.CalendarFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.CalendarModel;

public class MainActivity extends AppCompatActivity {
    Calendar calendar = Calendar.getInstance();

    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int date = calendar.get(Calendar.DATE );
    int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR );
    int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH );
    int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR );
    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    int hour = calendar.get(Calendar.HOUR );
    int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE );
    int second = calendar.get(Calendar.SECOND );

    private int maxDateOfMonth = 0;
    private CalendarFragment calendarFrag;
    private FragmentManager fragMngr;
    private FragmentTransaction fragTran;
    private ArrayList<CalendarModel> calendarItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.e("Calendar",
//                year + " -1- " + month  + " -2- " + date  + " -3- " + weekOfYear  + " -4- " + weekOfMonth
//                        + "-5- " + dayOfYear  + " -6- " + dayOfMonth  + " --7--" + dayOfWeek
//                        + " -8- " +  hour + " -9- " +  hourOfDay  + " -10- " + minute  + " -11- " + second);

        Log.e("Calendar", calendar.getActualMaximum(Calendar.DATE) +"");

        setCalendarData(calendar.YEAR, calendar.MONTH, calendar.DATE);
        calendarFrag = new CalendarFragment();
        setFrag();

        CalendarAdapter calendarAdapter = new CalendarAdapter(calendarItemList);
        RecyclerView calendarRecyclerView = findViewById(R.id.calendar_listview);

    }

    private void setCalendarData(int year, int month, int date) {
        calendar.set(year, month, date);
        maxDateOfMonth = calendar.getActualMaximum(Calendar.DATE);
        calendarItemList = new ArrayList<>();
        CalendarModel calendarModel = new CalendarModel();

        calendarModel.setMaxDateOfMonth(maxDateOfMonth);
        calendarModel.setYear(year);
        calendarModel.setMonth(month);
        calendarModel.setDate(date);

        calendarItemList.add(calendarModel);
    }

    private void setFrag() {
        fragMngr = getSupportFragmentManager();
        fragTran = fragMngr.beginTransaction();

        fragTran.replace(R.id.calendar_frame, calendarFrag).commit();
    }


}
