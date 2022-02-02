package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    protected Account account;
    protected Information info;
    protected List<Bill> billSummary = new ArrayList <Bill> ();
    protected Bill currentBill;
    protected float balance = 0;
    protected float sumOfUnpaidBills = 0;
    protected boolean isDebtor = false;

    public Customer(Information info, Account account, Bill currentBill) {
        this.info = info;
        this.account = account;
        this.currentBill = currentBill;

    }

    public void makePayment(float payment) {
        this.balance += payment;
        if(this.balance > this.sumOfUnpaidBills){
            this.balance -= this.sumOfUnpaidBills;
            this.isDebtor = false;
            for(Bill bill : billSummary){
                if(bill.isPaid() == false){
                    bill.setPaid(true);
                    break;
                }
            }
            this.sumOfUnpaidBills = 0;
        }
    }

    public List<Bill> getSummary() {
        return billSummary;
    }

    public float getRemainder() {
        return sumOfUnpaidBills;
    }

    public float getBalance() {
        return balance;
    }

    public void setToDebtor( ){
        isDebtor = true;
    }



    public void updateCurrentBill(int month, int year) {
        billSummary.add(currentBill);
        sumOfUnpaidBills += currentBill.getPrice();
        currentBill = new Bill( month, year, 0, false);
    }

}
