package model.entities;

import model.exceptions.InsufficientBalanceException;

import java.time.LocalDate;

public class CurrentAccount extends Account {
    private Double overdraftLimit;

    public CurrentAccount() {}

    public CurrentAccount(String number, String id, Double balance, LocalDate date, Double overdraftLimit) {
        super(number, id, balance, date);
        this.overdraftLimit = overdraftLimit;
    }

    public Double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(Double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double valor) {
        setBalance(getBalance() + valor);
    }

    @Override
    public void withdraw(double valor) {

        if(valor <= 0 ) {
            throw new IllegalArgumentException("Valor invalido!");
        }

        if (getBalance() + getOverdraftLimit() >= valor) {
            setBalance(getBalance() - valor + 2.50);
        } else {
            throw new InsufficientBalanceException("Limite de saque atingido!");
        }
    }

    @Override
    public String toString() {
        return getNumber()
                + "\n"
                + getBalance();
    }

}
