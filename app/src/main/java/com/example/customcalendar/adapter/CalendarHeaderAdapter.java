package com.example.customcalendar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customcalendar.R;
import com.example.customcalendar.vo.CalendarItemVO;

import java.util.ArrayList;

public class CalendarHeaderAdapter extends RecyclerView.Adapter<CalendarHeaderAdapter.CalendarHeaderHolder> {
    private ArrayList<CalendarItemVO> itemList;
    private String TAG = "CalendarHeaderAdapter";

    public class CalendarHeaderHolder extends RecyclerView.ViewHolder {
        public TextView dateOfMonth, dayOfWeek;
        public View datePoint;

        public CalendarHeaderHolder(View view) {
            super(view);

            dateOfMonth = view.findViewById(R.id.header_date_of_month);
            dayOfWeek = view.findViewById(R.id.header_day_of_week);
            datePoint = view.findViewById(R.id.header_date_point);
        }
    }

    public CalendarHeaderAdapter(ArrayList<CalendarItemVO> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CalendarHeaderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.calendar_header_item, parent, false);

        return new CalendarHeaderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarHeaderHolder holder, int position) {
//        Log.e(TAG, itemList.get(position).getDateOfMonth());
        holder.dateOfMonth.setText(itemList.get(position).getDateOfMonth());
        holder.dayOfWeek.setText(itemList.get(position).getDayOfWeek());

        if(itemList.get(position).getProductName() == null && itemList.get(position).getProductMemo() == null) {
            holder.datePoint.setVisibility(View.GONE);
        } else {
            holder.datePoint.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void addItem(ArrayList<CalendarItemVO> addItemList) {
        itemList.addAll(addItemList);
        this.notifyDataSetChanged();
    }

    public void updateItem(ArrayList<CalendarItemVO> addItemList) {
        itemList = addItemList;
        this.notifyDataSetChanged();
    }


}

