package com.example.customcalendar.vo;


public class CalendarItemVO {
    private String dateOfMonth;
    private String dayOfWeek;
    private String productName;
    private String date;
    private String productMemo;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getDateOfMonth() {
        return dateOfMonth;
    }

    public void setDateOfMonth(String dateOfMonth) {
        this.dateOfMonth = dateOfMonth;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProductMemo() {
        return productMemo;
    }

    public void setProductMemo(String productMemo) {
        this.productMemo = productMemo;
    }


}
