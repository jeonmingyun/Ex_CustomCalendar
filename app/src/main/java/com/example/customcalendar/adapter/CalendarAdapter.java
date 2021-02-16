package com.example.customcalendar.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customcalendar.R;
import com.example.customcalendar.vo.CalendarItemVO;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarHolder> {
    private ArrayList<CalendarItemVO> itemList;
    private String TAG = "CalendarAdapter";

    public class CalendarHolder extends RecyclerView.ViewHolder {
        public TextView dateOfMonth, dayOfWeek, productName, date, productMemo;
        public CheckBox checkBtn;
        public RelativeLayout productWrapper;

        public CalendarHolder(View view) {
            super(view);

            productWrapper = view.findViewById(R.id.product_wrapper);
            dateOfMonth = view.findViewById(R.id.date_of_month);
            dayOfWeek = view.findViewById(R.id.day_of_week);
            productName = view.findViewById(R.id.product_name);
            date = view.findViewById(R.id.date);
            productMemo = view.findViewById(R.id.product_memo);
            checkBtn = view.findViewById(R.id.check_btn);
        }
    }

    public CalendarAdapter(ArrayList<CalendarItemVO> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CalendarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.calendar_detail_item, parent, false);

        return new CalendarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarHolder holder, int position) {
        if(itemList.get(position).getProductName() == null && itemList.get(position).getProductMemo() == null) {
            holder.productWrapper.setVisibility(View.GONE);
        } else {
            holder.dateOfMonth.setText(itemList.get(position).getDateOfMonth());
            holder.dayOfWeek.setText(itemList.get(position).getDayOfWeek());
            holder.productName.setText(itemList.get(position).getProductName());
            holder.date.setText(itemList.get(position).getDate());
            holder.productMemo.setText(itemList.get(position).getProductMemo());

            if (itemList.get(position).isChecked()) {
                holder.checkBtn.setChecked(true);
            } else {
                holder.checkBtn.setChecked(false);
            }
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

    private String dateFormat(String date){
        String year = date.substring(0,4).trim();
        String month = date.substring(4,6).trim();
        String dateTime = date.substring(6,8).trim();
        String hour = date.substring(8,10).trim();
        String min = date.substring(10,12).trim();
        String sec = date.substring(12,14).trim();

        return year + "." + month + "." + dateTime + " " + hour + ":" + min + ":" + sec;
    }

}

