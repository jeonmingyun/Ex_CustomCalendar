package com.example.customcalendar.vo;

public class CalendarDateVO {
    private int maxDateOfMonth = 0; // 현재 달의 일 수
    private int year = 2021; // 현재 년도
    private int month = 1; // 현재 월 (1월은 0)
    private int date = 1; // 현재 월의 날짜
    private int weekOfYear = 6; // 현재 년도의 몇째 주
    private int weekOfMonth = 1; // 현재 월의 몇째 주
    private int dayOfYear = 32; // 현재 년도의 날짜
    private int dayOfMonth = 1; // 현재 월의 날짜(date와 동일)
    private int dayOfWeek = 2; // 현재 요일 (일요일:1, 토요일:7)
    private int hour = 4; // 현재시간 (12시간제)
    private int hourOfDay = 16; // 현재시간 (24시간제)
    private int minute = 40; // 현재 분
    private int second = 4; // 현재 초

    public int getMaxDateOfMonth() {
        return maxDateOfMonth;
    }

    public void setMaxDateOfMonth(int maxDateOfMonth) {
        this.maxDateOfMonth = maxDateOfMonth;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getWeekOfYear() {
        return weekOfYear;
    }

    public void setWeekOfYear(int weekOfYear) {
        this.weekOfYear = weekOfYear;
    }

    public int getWeekOfMonth() {
        return weekOfMonth;
    }

    public void setWeekOfMonth(int weekOfMonth) {
        this.weekOfMonth = weekOfMonth;
    }

    public int getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(int dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHourOfDay() {
        return hourOfDay;
    }

    public void setHourOfDay(int hourOfDay) {
        this.hourOfDay = hourOfDay;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
