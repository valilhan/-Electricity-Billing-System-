package com.company;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Database {
    List<Customer> customers = new ArrayList<Customer>();
    MyDate CurrentDate = new MyDate(1, 10, 2021);

    //Singleton
    private static Database InstanceDatabase;

    private Database(){}

    public static Database getInstance(){
        if(InstanceDatabase == null)
            InstanceDatabase = new Database();
        return InstanceDatabase;
    }
    //Singleton

    private void findDebtors(){
        for(Customer customer: customers) {
            if (customer.balance - customer.sumOfUnpaidBills < 0) {
                customer.setToDebtor();
            }
            else{
                customer.balance -= customer.sumOfUnpaidBills;
                customer.currentBill.isPaid();
            }
        }
    }
    public void calculateCosts() {
        for(Customer customer: customers) {
            if (customer.isDebtor == false)
                customer.currentBill.increasePrice(newRandom());
            if( CurrentDate.getDay() == 1) {
                customer.updateCurrentBill(CurrentDate.getMonth(), CurrentDate.getYear());
            }
        }
        if( CurrentDate.getDay() == 1) {
            findDebtors();
        }
    }

    public void deleteCustomer(Customer customer){
        customers.remove(customer);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    private float newRandom(){
        Random random = new Random();
        int a = random.nextInt(3) + 1;
        int b = random.nextInt(33) + 1;
        float c = (float) random.nextInt(100);
        float result = (float)(a * b);
        result += c / 100;
        return result;
    }

    public Customer getCostumer( Account account ){
        for( Customer customer: customers ){
            if( customer.account.getEmail().equals(account.getEmail()) && customer.account.getPassword().equals(account.getPassword()) ) {
                return customer;
            }
        }
        return null;
    }
    public boolean accountExist( String mail ){
        for( Customer customer: customers ){
            if( customer.account.getEmail().equals(mail) ) {
                return true;
            }
        }
        return false;
    }
}
