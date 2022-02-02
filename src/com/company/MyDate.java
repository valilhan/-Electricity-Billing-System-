package com.company;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void increaseDay(){
        day += 1;
        if(day == 31) {
            day = 1;
            month += 1;
        }
        if(month == 13){
            month = 1;
            year += 1;
        }
    }
}
