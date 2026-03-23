package com.atm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "atm_users")
public class User {

    @Id
    private Long accNo;

    private String name;
    private int pin;
    private double balance;
    private String type;

    // Getters & Setters
    public Long getAccNo() { return accNo; }
    public void setAccNo(Long accNo) { this.accNo = accNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPin() { return pin; }
    public void setPin(int pin) { this.pin = pin; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}