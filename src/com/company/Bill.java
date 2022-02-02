package com.company;

public class Bill {
    private int month;
    private int year;
    private float price;
    private boolean isPaid;

    public Bill(int month, int year, float price, boolean isPaid) {
        this.month = month;
        this.year = year;
        this.price = price;
        this.isPaid = isPaid;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void increasePrice( float value ){
        this.price += value;
    }

}
