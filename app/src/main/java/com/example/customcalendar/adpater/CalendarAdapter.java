package com.example.customcalendar.adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customcalendar.R;

import java.util.ArrayList;
import java.util.List;

import model.CalendarModel;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarHolder> {

    private ArrayList<CalendarModel> itemList;

    public CalendarAdapter(ArrayList<CalendarModel> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CalendarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_day, parent, false);

        return new CalendarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void addItem(ArrayList<CalendarModel> addItemList) {
        itemList.addAll(addItemList);
        notifyDataSetChanged();
    }

    public class CalendarHolder extends RecyclerView.ViewHolder {

        public CalendarHolder(@NonNull View view) {
            super(view);


        }
    }
}
