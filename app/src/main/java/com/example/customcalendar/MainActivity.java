package com.example.customcalendar;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customcalendar.adapter.CalendarAdapter;
import com.example.customcalendar.adapter.CalendarHeaderAdapter;
import com.example.customcalendar.vo.CalendarItemVO;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Calendar calendar;
    private int year, month, date, maxDateOfMonth, firstDayOfMonth;
    private ArrayList<CalendarItemVO> itemList;
    private RecyclerView calendarListview, calendarHeaderListview;
    private CalendarAdapter calendarAdapter;
    private CalendarHeaderAdapter calendarHeaderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCurrentDate();
        setCalendarDate(year, month, date);
        setItemList(maxDateOfMonth, firstDayOfMonth);

        findViewById(R.id.open_date_picker_btn).setOnClickListener(this);

        calendarHeaderListview = findViewById(R.id.calender_header_listview);
        calendarHeaderAdapter = new CalendarHeaderAdapter(itemList);
        calendarHeaderListview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        calendarHeaderListview.setAdapter(calendarHeaderAdapter);

        calendarListview = findViewById(R.id.calender_detail_listview);
        calendarAdapter = new CalendarAdapter(itemList);
        calendarListview.setLayoutManager(new LinearLayoutManager(this));
        calendarListview.setAdapter(calendarAdapter);

    }

    private void setCurrentDate(int year, int month, int date) {
        this.year = year;
        this.month = month;
        this.date = date;
    }

    private void setCurrentDate() {
        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        date = calendar.get(Calendar.DATE);
    }

    private void setCalendarDate(int year, int month, int date) {
        calendar.set(year, month, date);
        maxDateOfMonth = calendar.getActualMaximum(Calendar.DATE);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);

    }


    private void setItemList(int maxDateOfMonth, int firstDayOfMonth) {
        CalendarItemVO calendarItemVO;
        itemList = new ArrayList<>();
        String dateFormat;
        int day;

        for(int i = 1; i <= maxDateOfMonth; i++) {
            dateFormat = year + "." + month+1 + "." + i;
            day = (i + firstDayOfMonth - 1) % 7;
            calendarItemVO = new CalendarItemVO();

            calendarItemVO.setDateOfMonth(i+""); // 날짜
            calendarItemVO.setDayOfWeek(dayStringFormat(day)); // 요일
            calendarItemVO.setDate(dateFormat); // 2020.01.01

            /* 가데이터 */
            calendarItemVO.setChecked(false);
            calendarItemVO.setProductName("계란");
            calendarItemVO.setProductMemo("메모 입력");

            itemList.add(calendarItemVO);
        }

    }

    private String dayStringFormat(int day) {
        switch (day) {
            case 1:
                return "일";
            case 2:
                return "월";
            case 3:
                return "화";
            case 4:
                return "수";
            case 5:
                return "목";
            case 6:
                return "금";
            case 0:
                return "토";
            default:
                return " ";
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.open_date_picker_btn:
                DatePickerDialog dialog = new DatePickerDialog(this, listener, year, month, date);
                dialog.show();
                break;
        }
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int date) {
            int position = date-1;
            Toast.makeText(getApplicationContext(), year + "년" + (month+1) + "월" + date +"일", Toast.LENGTH_SHORT).show();

            setCurrentDate(year, month, date);
            setCalendarDate(year, month, date);
            setItemList(maxDateOfMonth, firstDayOfMonth);

            calendarAdapter.updateItem(itemList);
            calendarHeaderAdapter.updateItem(itemList);
            scrollPosition(position);

        }
    };

    private void scrollPosition(int position) {
        LinearLayoutManager calendarLayoutManager = (LinearLayoutManager) calendarListview.getLayoutManager();
        if(calendarLayoutManager != null)
            calendarLayoutManager.scrollToPositionWithOffset(position, 0);

        LinearLayoutManager headerLayoutManager = (LinearLayoutManager) calendarHeaderListview.getLayoutManager();
        if(headerLayoutManager != null)
            headerLayoutManager.scrollToPositionWithOffset(position, 0);
    }

}
