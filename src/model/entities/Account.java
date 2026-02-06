package model.entities;

import model.exceptions.InvalidAmountException;

import java.time.LocalDate;
import java.util.Date;

public abstract class Account {

    private String number;
    private String clientId;
    private Double balance;
    private LocalDate date;

    public Account() {
    }

    public Account(String clientId, Double balance) {
        this.clientId = clientId;
        this.balance = balance;
        this.date = LocalDate.now();
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void deposit(double valor) {

        if( valor <= 0 ) {
            throw new InvalidAmountException();
        }

        setBalance(getBalance() + valor);
    };

    public abstract void withdraw(double valor);

    public abstract void monthlyUpdate();

}
