package com.example.mazebank.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingsAccount extends Account{
    private final DoubleProperty withdrawlimit;

    public SavingsAccount(String owner, String accountNumber, double balance, double withdrawlimit){
        super(owner,accountNumber,balance);
        this.withdrawlimit = new SimpleDoubleProperty(this, "Withdraw Limit",withdrawlimit);

    }

    public DoubleProperty withdrawlimitProp(){
        return withdrawlimit;
    }
}
