package com.company;
import java.sql.Timestamp;

public class Information {
    private String name;
    private String surname;
    private MyDate dateRegistration;

    private Information() {}

    public Information(String name, String surname, MyDate dateRegistration) {
        this.name = name;
        this.surname = surname;
        this.dateRegistration = dateRegistration;
    }

    public String getName() {
        return name;
    }

    protected String getSurname() {
        return surname;
    }

    public MyDate getDataRegistration() {
        return dateRegistration;
    }

    public void printInfo() {
        System.out.println(this.name + " " + this.surname);
        System.out.println("Date of Registration: " + this.dateRegistration);
    }
}
