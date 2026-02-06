package model.entities;

import model.exceptions.InsufficientBalanceException;
import model.exceptions.InvalidAmountException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CurrentAccount extends Account {

    private Double overdraftLimit;
    private Double overdraftInterestRate;

    public CurrentAccount() {}

    public CurrentAccount(String clientId, Double balance, Double overdraftLimit) {
        super(clientId, balance);
        this.overdraftLimit = overdraftLimit;
        this.overdraftInterestRate = 0.08;
    }

    public Double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(Double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public Double getOverdraftInterestRate() {
        return overdraftInterestRate;
    }

    public void setOverdraftInterestRate(Double overdraftInterestRate) {
        this.overdraftInterestRate = overdraftInterestRate;
    }

    @Override
    public void withdraw(double valor) {

        double fee = 2.50;

        if (valor <= 0) {
            throw new InvalidAmountException();
        }

        if (getBalance() + overdraftLimit < valor + fee) {
            throw new InsufficientBalanceException();
        }

        setBalance(getBalance() - valor - fee);
    }

    @Override
    public void monthlyUpdate() {

        if (getBalance() < 0) {
            double debit = Math.abs(getBalance());

            double interest = debit * getOverdraftInterestRate();

            setBalance(getBalance() - interest);
        }

    }

    @Override
    public String toString() {
        return getNumber()
                + "\n"
                + getBalance();
    }

}
