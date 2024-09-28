package com.example.mazebank.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Client {
    private final StringProperty firstname;
    private final StringProperty lastname;
    private final StringProperty payeeAddress;
    private final ObjectProperty<Account> checkingAccount;
    private final ObjectProperty<Account> savingAccount;
    private final ObjectProperty<LocalDate> dateCreated;

    public Client(String fname, String lname, String pAddress, Account cAccount, Account sAccount, LocalDate date){
        this.firstname = new SimpleStringProperty(this,"FirstName", fname);
        this.lastname = new SimpleStringProperty(this,"LastName", lname);
        this.payeeAddress = new SimpleStringProperty(this,"Payee Address",pAddress);
        this.checkingAccount = new SimpleObjectProperty<>(this, "Checking Account", cAccount);
        this.savingAccount = new SimpleObjectProperty<>(this, "Savings Accounts",sAccount);
        this.dateCreated = new SimpleObjectProperty<>(this,"Date",date);

    }
    public StringProperty firstNameProperty(){
        return firstname;
    }
    public StringProperty lastNameProperty(){
        return lastname;
    }
    public StringProperty pAddressProperty(){
        return payeeAddress;
    }
    public ObjectProperty<Account>checkingAccountProperty(){
        return checkingAccount;
    }
    public ObjectProperty<Account>savingsAccountProperty(){
        return savingAccount;
    }
    public ObjectProperty<LocalDate>dateProperty(){
        return dateCreated;
    }

}
